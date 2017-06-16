/**
 * Created on: 9/10/2014
 */
package controllers;

import static play.libs.Json.toJson;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Query;

import models.Branch;
import models.Role;
import models.User;
import models.dto.JQueryDataTableParamModelDto;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import play.db.jpa.JPA;
import play.db.jpa.Transactional;
import play.mvc.Result;
import play.mvc.Security;
import utils.CABConstantKeys;
import utils.DateUtils;
import utils.StringUtil;
import annotation.AuthorizationAnnotation;

import com.fasterxml.jackson.databind.JsonNode;

import controllers.core.AbstractController;
import controllers.core.Secured;

/**
 * @author vichrak
 *
 */
@Security.Authenticated(Secured.class)
@AuthorizationAnnotation({"role_administrator"})
public class UserController extends AbstractController{
    
    private static final Log LOG = LogFactory.getLog(UserController.class);
    private static User _user;
    
    @Transactional(readOnly = true)
    public static Result index(){
        requestUri = request().uri();
        _user = User.findByLogin(request().username());
        final List<Branch> branches = Branch.findAll();
        final List<Role> roles = Role.findAll();
        return ok(views.html.admin.user.render(_user, branches, roles, "user"));
    }
    
    /**
     * @return {@link Result}
     */
    @Transactional
    public static Result saveOrUpdateUser(){
        try{
            final JsonNode rootNode = request().body().asJson();
            if(rootNode != null){
                final String username = rootNode.path("username").asText();
                User user = null;
                
                if(rootNode.path("userId").asInt() == 0){
                    /* add user */
                    final User creatingUser = User.findByLogin(username);
                    if(creatingUser == null){
                        user = new User();
                    }
                    else{
                        return ok(toJson("user_exists"));
                    }
                }
                else{
                    /* edit user */
                    final Long userId = rootNode.path("userId").asLong();
                    user = (User) User.findById(User.class, userId);
                }
                
                final String fullName = rootNode.path("fullName").asText();
                final Date dateOfBirth = DateUtils.getDate(rootNode.path("dateOfBirth").asText());
                final String phone = rootNode.path("phone").asText();
                final String email = rootNode.path("email").asText();
                final String address = rootNode.path("address").asText();
                final Long branchId = rootNode.path("branch").asLong();
                final Long roleId = rootNode.path("role").asLong();
                final boolean active = rootNode.path("active").asBoolean();
                final String password = rootNode.path("password").asText();
                
                user.setFullName(fullName);
                user.setDateOfBirth(dateOfBirth);
                user.setPhone(phone);
                user.setEmail(email);
                user.setAddress(address);
                user.setBranch((Branch) Branch.findById(Branch.class, branchId));
                user.setRole((Role) Role.findById(Role.class, roleId));
                user.setActive(active);
                user.setUsername(username);
                user.setPassword(password);
                user = (User) User.saveOrUpdate(user);
                return ok(toJson(user.getId().toString()));
            }
            else{
                return ok(toJson("json_expected"));
            }
        }
        catch(final Exception e){
            LOG.error(e.getMessage(), e);
            return null;
        }
    }
    
    /**
     * @return {@link Result}
     */
    @Transactional
    public static Result saveOrUpdateBranch(){
        try{
            final JsonNode rootNode = request().body().asJson();
            if(rootNode != null){
                final String branchName = rootNode.path("branchName").asText();
                Branch branch = null;
                
                if(rootNode.path("branchId").asInt() == 0){
                    /* add branch */
                    final Branch creatingBranch = Branch.findByName(branchName);
                    if(creatingBranch == null){
                        branch = new Branch();
                    }
                    else{
                        return ok(toJson("branch_exists"));
                    }
                }
                else{
                    /* edit branch */
                    final Long branchId = rootNode.path("branchId").asLong();
                    branch = (Branch) Branch.findById(Branch.class, branchId);
                }
                
                final String phone = rootNode.path("branchPhone").asText();
                final String address = rootNode.path("branchAddress").asText();
                final String bankRef = rootNode.path("branchBankRef").asText();
                final String branchInitBankCode = rootNode.path("branchInitBankCode").asText();
                
                branch.setName(branchName);
                branch.setPhone(phone);
                branch.setAddress(address);
                branch.setBankReference(bankRef);
                branch.setInitBankCode(branchInitBankCode);
                
                branch = (Branch) Branch.saveOrUpdate(branch);
                return ok(toJson(branch.getId().toString() + LoginController.DELIMITER + branch.getName()));
            }
            else{
                return ok(toJson("json_expected"));
            }
        }
        catch(final Exception e){
            LOG.error(e.getMessage(), e);
            return null;
        }
    }
    
    /**
     * @return {@link Result}
     */
    @SuppressWarnings("unchecked")
    @Transactional(readOnly = true)
    public static Result filterUser(){
        final Map<String, String[]> parames = request().queryString();
        final JQueryDataTableParamModelDto jQueryDataTableParamModel = new JQueryDataTableParamModelDto(parames);
        try{
            final String filterString = jQueryDataTableParamModel.getsSearch();
            Query query = null;
            if(StringUtils.isNotBlank(filterString)){
                final StringBuilder queryString = new StringBuilder("FROM User u WHERE ");
                queryString.append("LOWER(u.branch.name) like :filterStr ");
                queryString.append("OR LOWER(u.username) like :filterStr ");
                queryString.append("OR LOWER(u.role.label) like :filterStr ");
                queryString.append("OR LOWER(u.fullName) like :filterStr ");
                queryString.append("OR LOWER(u.phone) like :filterStr ");
                queryString.append(buildOrderByClause(jQueryDataTableParamModel));
                query = JPA.em().createQuery(queryString.toString());
                query.setParameter("filterStr", CABConstantKeys.PERCENT + filterString.toLowerCase() + CABConstantKeys.PERCENT);
            }
            else{
                final StringBuilder queryString = new StringBuilder("FROM User u ");
                queryString.append(buildOrderByClause(jQueryDataTableParamModel));
                query = JPA.em().createQuery(queryString.toString());
            }
            
            jQueryDataTableParamModel.setiTotalRecords(query.getResultList().size());
            
            query.setFirstResult(Integer.parseInt(jQueryDataTableParamModel.getiDisplayStart()));
            query.setMaxResults(Integer.parseInt(jQueryDataTableParamModel.getiDisplayLength()));
            final List<User> users = query.getResultList();
            final JsonNode jsonNode = buildUserAsJsonNode(users, jQueryDataTableParamModel);
            return ok(jsonNode);
        }
        catch(final Exception e){
            LOG.error(e.getMessage(), e);
            return null;
        }
    }
    
    @SuppressWarnings("unchecked")
    private static JsonNode buildUserAsJsonNode(final List<User> users, final JQueryDataTableParamModelDto jQueryDataTableParamModel){
        final JSONArray[] jsonData = new JSONArray[users.size()];
        int i = 0;
        for(final User user : users){
            final JSONArray jsonArray = new JSONArray();
            jsonArray.add(i + 1);
            jsonArray.add(user.getId());
            jsonArray.add(user.getBranch().getName());
            jsonArray.add(user.getUsername());
            jsonArray.add(user.getRole().getLabel());
            jsonArray.add(user.getFullName());
            jsonArray.add(DateUtils.getDateLabel(user.getDateOfBirth()));
            jsonArray.add(user.getPhone());
            jsonArray.add(user.getEmail());
            jsonArray.add(user.getAddress());
            jsonArray.add(user.isActive());
            jsonArray.add(user.getBranch().getId());
            jsonArray.add(user.getRole().getId());
            jsonArray.add(user.getPassword());
            jsonData[i] = jsonArray;
            i++;
        }
        final JSONObject jsonObject = new JSONObject();
        jsonObject.put(CABConstantKeys.SECHO, jQueryDataTableParamModel.getsEcho());
        jsonObject.put(CABConstantKeys.ITOTALRECORDS, jQueryDataTableParamModel.getiTotalRecords());
        jsonObject.put(CABConstantKeys.ITOTALDISPLAYRECORDS, jQueryDataTableParamModel.getiTotalRecords());
        jsonObject.put(CABConstantKeys.AADATA, jsonData);
        final JsonNode jsonNode = play.libs.Json.toJson(jsonObject);
        return jsonNode;
    }
    
    private static String buildOrderByClause(final JQueryDataTableParamModelDto jQueryDataTableParam){
        StringBuilder orderByClause = new StringBuilder();
        orderByClause.append(" ORDER BY ").append(getMapColumnSort(jQueryDataTableParam)).append(" ").append(jQueryDataTableParam.getSSortDir_0());
        return orderByClause.toString();
    }
    
    private static String getMapColumnSort(final JQueryDataTableParamModelDto jQueryDataTableParamModel){
        Map<String, String> columnsName = new HashMap<String, String>();
        columnsName.put(StringUtil.ZERO, "u.fullName");
        columnsName.put("2", "u.branch.name");
        columnsName.put("3", "u.username");
        columnsName.put("4", "u.role.label");
        columnsName.put("5", "u.fullName");
        columnsName.put("6", "u.dateOfBirth");
        columnsName.put("7", "u.phone");
        columnsName.put("10", "u.active");
        return columnsName.get(jQueryDataTableParamModel.getiSortCol_0());
    }
}
