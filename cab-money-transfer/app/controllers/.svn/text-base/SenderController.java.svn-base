/**
 * Created on: 5/10/2014
 */
package controllers;

import static play.libs.Json.toJson;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Query;

import models.CurrencyExchange;
import models.Sender;
import models.SenderReceiverTransaction;
import models.User;
import models.dto.JQueryDataTableParamModelDto;
import models.dto.SenderDto;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import play.cache.Cache;
import play.db.jpa.JPA;
import play.db.jpa.Transactional;
import play.libs.Json;
import play.mvc.Result;
import play.mvc.Security;
import utils.CABConstantKeys;
import utils.DateUtils;
import utils.StringUtil;
import annotation.AuthorizationAnnotation;

import com.fasterxml.jackson.databind.JsonNode;
import com.typesafe.config.ConfigFactory;

import controllers.core.AbstractController;
import controllers.core.Secured;

/**
 * @author Vichrak
 *
 */
@Security.Authenticated(Secured.class)
public class SenderController extends AbstractController{
    
    private static final Log LOG = LogFactory.getLog(SenderController.class);
    private static final String ACCOUNT_NO = "accountNo";
    private static final String SENDER_ID = "senderId";
    private static User _user;
    private static String NAV_SENDER = "sender";
    
    @AuthorizationAnnotation({"role_administrator", "role_compliance_officer" })
    @SuppressWarnings("unchecked")
    @Transactional(readOnly = true)
    public static Result index(){
        requestUri = request().uri();
        _user = User.findByLogin(request().username());
        final List<CurrencyExchange> currencies = (List<CurrencyExchange>) Cache.get(CABConstantKeys.CURRENCY);
        final Long branchId = (Long) Cache.get(getUsername() + CABConstantKeys.BRANCH_SUFFIX);
        final List<SenderReceiverTransaction> blockedRemittanceTransactions = SenderReceiverTransaction.getBlockingRemittanceTransaction(branchId, getUsername());
        final String notificationInterval = ConfigFactory.load().getString("NOTIFICATION_INTERVAL");
        return ok(views.html.co.sender.render(_user, NAV_SENDER, blockedRemittanceTransactions, notificationInterval, currencies));
    }
    
    @SuppressWarnings("unchecked")
    @AuthorizationAnnotation({"role_administrator", "role_compliance_officer", "role_teller" })
    @Transactional(readOnly = true)
    public static Result filterSenderByFullName(){
        final Map<String, String[]> requestString = request().queryString();
        final String fullName = (requestString.get("q") != null) ? requestString.get("q")[0] : "";
        if(requestString.get("minLength") == null){
            final JsonNode senderJson = Json.toJson(new ArrayList<SenderDto>());
            final JSONObject jsonObject = new JSONObject();
            jsonObject.put("total", 0);
            jsonObject.put("rows", senderJson);
            final JsonNode jsonNode = play.libs.Json.toJson(jsonObject);
            return ok(jsonNode);
        }
        else{
            final int minLength = Integer.parseInt(requestString.get("minLength")[0]);
            if(fullName.length() < minLength){
                //{"total":0,"records":0,"rows":[]}
                final JsonNode senderJson = Json.toJson(new ArrayList<SenderDto>());
                final JSONObject jsonObject = new JSONObject();
                jsonObject.put("total", 0);
                jsonObject.put("rows", senderJson);
                final JsonNode jsonNode = play.libs.Json.toJson(jsonObject);
                return ok(jsonNode);
            }
            //        final String accNumber = (requestBody.get("accNumber") != null) ? requestBody.get("accNumber")[0] : "";
            final List<SenderDto> listSender = Sender.filterByFullName(fullName);
            // build JSON
            final JsonNode senderJson = Json.toJson(listSender);
            final JSONObject jsonObject = new JSONObject();
            
            //            final int limit = Integer.parseInt(requestBody.get("rows")[0]);
            //            int totalPage = listSender.size() / limit;
            //            if (listSender.size() > 0 && totalPage == 0) {
            //                totalPage = 1;
            //            }
            //            int page = Integer.parseInt(requestBody.get("page")[0]);
            //            if (page > totalPage) {
            //                page = totalPage;
            //            }
            
            //            jsonObject.put("page", page);
            jsonObject.put("total", listSender.size());
            //            jsonObject.put("records", listSender.size());
            jsonObject.put("rows", senderJson);
            final JsonNode jsonNode = play.libs.Json.toJson(jsonObject);
            return ok(jsonNode);
        }
    }
    
    /**
     * @return {@link Result}
     */
    @AuthorizationAnnotation({"role_administrator", "role_compliance_officer" })
    @Transactional
    public static Result saveOrUpdateSender(){
        try{
            final JsonNode rootNode = request().body().asJson();
            if(rootNode != null){
                final Long senderId = rootNode.path(SENDER_ID).asLong();
                final String accountNo = rootNode.path("senderAccountNo").asText();
                final String companyName = rootNode.path("senderCompanyName").asText();
                final String identityNo = rootNode.path("senderIdentityNo").asText();
                final String fullName = rootNode.path("senderFullName").asText();
                final Date dateOfBirth = DateUtils.getDate(rootNode.path("senderDateOfBirth").asText());
                
                Sender sender = null;
                final String senderExist = senderExists(senderId, accountNo, companyName, identityNo, fullName, dateOfBirth);
                if(senderExist == StringUtils.EMPTY){
                    if(senderId == 0){ /* add sender */
                        sender = new Sender();
                    }
                    else{ /* edit sender */
                        sender = (Sender) Sender.findById(Sender.class, senderId);
                    }
                }
                else{
                    return ok(toJson("sender_exists" + LoginController.DELIMITER + senderExist));
                }
                
                final String type = rootNode.path("senderType").asText();
                final String email = rootNode.path("senderEmail").asText();
                final String address = rootNode.path("senderAddress").asText();
                final boolean isBlacklist = rootNode.path("senderBlacklist").asBoolean();
                //                final boolean isBlock = rootNode.path("senderBlock").asBoolean();
                final String reason = rootNode.path("senderReason").asText();
                final Date expireDate = DateUtils.getDate(rootNode.path("senderExpireDate").asText());
                
                sender.setType(type);
                sender.setAccountNo(accountNo);
                sender.setFullName(fullName);
                sender.setCompanyName(companyName);
                sender.setDateOfBirth(dateOfBirth);
                sender.setEmail(email);
                sender.setAddress(address);
                sender.setBlacklist(isBlacklist);
                //                sender.setBlock(isBlock);
                sender.setReason(reason);
                sender.setIdentityNumber(identityNo);
                sender.setExpiredDate(expireDate);
                sender = (Sender) Sender.saveOrUpdate(sender);
                return ok(toJson(sender.getId().toString()));
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
     * @param accountNo
     * @param companyName
     * @param identityNo
     * @return true if the sender exists in the database
     */
    @SuppressWarnings("unchecked")
    private static String senderExists(final Long editingSenderId, final String accountNo, final String companyName, final String identityNo, final String fullName, final Date dateOfBirth){
        final String queryByAccountNo = "select id from Sender where accountNo=:accountNo and id != :editingSenderId";
        Query query = JPA.em().createQuery(queryByAccountNo);
        query.setParameter(ACCOUNT_NO, accountNo);
        query.setParameter("editingSenderId", editingSenderId);
        query.setMaxResults(1);
        List<Long> senderIds = query.getResultList();
        if(senderIds.size() == 1 && StringUtils.isNotBlank(accountNo)){
            return "senderAccountNo";
        }
        else{
            final String queryByCompanyName = "select id from Sender where companyName=:companyName and id != :editingSenderId";
            query = JPA.em().createQuery(queryByCompanyName);
            query.setParameter("companyName", companyName);
            query.setParameter("editingSenderId", editingSenderId);
            query.setMaxResults(1);
            senderIds = query.getResultList();
            if(senderIds.size() == 1 && StringUtils.isNotBlank(companyName)){
                return "senderCompanyName";
            }
            else{
                final String queryByIdentityNo = "select id from Sender where identityNumber=:identityNo and id != :editingSenderId";
                query = JPA.em().createQuery(queryByIdentityNo);
                query.setParameter("identityNo", identityNo);
                query.setParameter("editingSenderId", editingSenderId);
                query.setMaxResults(1);
                senderIds = query.getResultList();
                if(senderIds.size() == 1 && StringUtils.isNotBlank(identityNo)){
                    return "senderIdentityNo";
                }
                else{
                    final String queryByFullNameAndDOB = "select id from Sender where fullName=:fullName and dateOfBirth=:dateOfBirth and id != :editingSenderId";
                    query = JPA.em().createQuery(queryByFullNameAndDOB);
                    query.setParameter("fullName", fullName);
                    query.setParameter("dateOfBirth", dateOfBirth);
                    query.setParameter("editingSenderId", editingSenderId);
                    query.setMaxResults(1);
                    senderIds = query.getResultList();
                    if(senderIds.size() == 1 && StringUtils.isNotBlank(fullName) && dateOfBirth != null){
                        return "senderFullName";
                    }
                    else{
                        return StringUtils.EMPTY;
                    }
                }
            }
        }
    }
    
    /**
     * @return {@link Result}
     */
    @AuthorizationAnnotation({"role_administrator", "role_compliance_officer" })
    @SuppressWarnings("unchecked")
    @Transactional(readOnly = true)
    public static Result filterSender(){
        final Map<String, String[]> parames = request().queryString();
        final JQueryDataTableParamModelDto jQueryDataTableParamModel = new JQueryDataTableParamModelDto(parames);
        try{
            if(parames != null && parames.get("searchType") != null){
                final String type = parames.get("searchType")[0];
                final String accountNo = parames.get("searchAccountNo")[0];
                final String fullName = parames.get("searchFullName")[0];
                final String companyName = parames.get("searchCompanyName")[0];
                final String email = parames.get("searchEmail")[0];
                boolean isBlacklist = false;
                if(parames.get("searchBlacklist") != null && ("on").equals(parames.get("searchBlacklist")[0])){
                    isBlacklist = true;
                }
                final String identityNo = parames.get("searchIdentityNo")[0];
                
                final StringBuilder queryString = new StringBuilder("FROM Sender WHERE ");
                queryString.append("blacklist = :blacklist ");
                //                queryString.append("AND block = :block ");
                
                if(StringUtils.isNotBlank(type)){
                    queryString.append("AND LOWER(type) like :type ");
                }
                if(StringUtils.isNotBlank(accountNo)){
                    queryString.append("AND LOWER(accountNo) like :accountNo ");
                }
                if(StringUtils.isNotBlank(fullName)){
                    queryString.append("AND LOWER(fullName) like :fullName ");
                }
                if(StringUtils.isNotBlank(companyName)){
                    queryString.append("AND LOWER(companyName) like :companyName ");
                }
                if(StringUtils.isNotBlank(email)){
                    queryString.append("AND LOWER(email) like :email ");
                }
                if(StringUtils.isNotBlank(identityNo)){
                    queryString.append("AND LOWER(identityNumber) like :identityNo");
                }
                queryString.append(buildOrderByClause(jQueryDataTableParamModel));
                final Query query = JPA.em().createQuery(queryString.toString());
                
                // query.setParameter("block", isBlock);
                query.setParameter("blacklist", isBlacklist);
                if(StringUtils.isNotBlank(type)){
                    query.setParameter("type", type.toLowerCase());
                }
                if(StringUtils.isNotBlank(accountNo)){
                    query.setParameter(ACCOUNT_NO, CABConstantKeys.PERCENT + accountNo.toLowerCase() + CABConstantKeys.PERCENT);
                }
                if(StringUtils.isNotBlank(fullName)){
                    query.setParameter("fullName", CABConstantKeys.PERCENT + fullName.toLowerCase() + CABConstantKeys.PERCENT);
                }
                if(StringUtils.isNotBlank(companyName)){
                    query.setParameter("companyName", CABConstantKeys.PERCENT + companyName.toLowerCase() + CABConstantKeys.PERCENT);
                }
                if(StringUtils.isNotBlank(email)){
                    query.setParameter("email", CABConstantKeys.PERCENT + email.toLowerCase() + CABConstantKeys.PERCENT);
                }
                if(StringUtils.isNotBlank(identityNo)){
                    query.setParameter("identityNo", CABConstantKeys.PERCENT + identityNo.toLowerCase() + CABConstantKeys.PERCENT);
                }
                jQueryDataTableParamModel.setiTotalRecords(query.getResultList().size());
                query.setFirstResult(Integer.parseInt(jQueryDataTableParamModel.getiDisplayStart()));
                query.setMaxResults(Integer.parseInt(jQueryDataTableParamModel.getiDisplayLength()));
                final List<Sender> senders = query.getResultList();
                final JsonNode jsonNode = buildSenderAsJsonNode(senders, jQueryDataTableParamModel);
                return ok(jsonNode);
            }
            else{
                final Query query = JPA.em().createQuery("FROM Sender");
                jQueryDataTableParamModel.setiTotalRecords(query.getResultList().size());
                query.setFirstResult(Integer.parseInt(jQueryDataTableParamModel.getiDisplayStart()));
                query.setMaxResults(Integer.parseInt(jQueryDataTableParamModel.getiDisplayLength()));
                final List<Sender> senders = query.getResultList();
                final JsonNode jsonNode = buildSenderAsJsonNode(senders, jQueryDataTableParamModel);
                return ok(jsonNode);
            }
        }
        catch(final Exception e){
            LOG.error(e.getMessage(), e);
            return null;
        }
    }
    
    private static String buildOrderByClause(final JQueryDataTableParamModelDto jQueryDataTableParam){
        final StringBuilder orderByClause = new StringBuilder();
        orderByClause.append(" ORDER BY ").append(getMapColumnSort(jQueryDataTableParam)).append(" ").append(jQueryDataTableParam.getSSortDir_0());
        return orderByClause.toString();
    }
    
    private static String getMapColumnSort(final JQueryDataTableParamModelDto jQueryDataTableParamModel){
        final Map<String, String> columnsName = new HashMap<String, String>();
        columnsName.put(StringUtil.ZERO, "fullName"); /* default column sort */
        columnsName.put("2", "type");
        columnsName.put("3", ACCOUNT_NO);
        columnsName.put("4", "fullName");
        columnsName.put("5", "companyName");
        columnsName.put("6", "address");
        columnsName.put("7", "dateOfBirth");
        columnsName.put("8", "identityNumber");
        columnsName.put("9", "expiredDate");
        columnsName.put("11", "blacklist");
        return columnsName.get(jQueryDataTableParamModel.getiSortCol_0());
    }
    
    @SuppressWarnings("unchecked")
    private static JsonNode buildSenderAsJsonNode(final List<Sender> senders, final JQueryDataTableParamModelDto jQueryDataTableParamModel){
        final JSONArray[] jsonData = new JSONArray[senders.size()];
        int i = 0;
        for(final Sender sender : senders){
            final JSONArray jsonArray = new JSONArray();
            jsonArray.add(i + 1);
            jsonArray.add(sender.getId());
            jsonArray.add(sender.getType());
            jsonArray.add(sender.getAccountNo());
            jsonArray.add(sender.getFullName());
            jsonArray.add(sender.getCompanyName());
            jsonArray.add(sender.getAddress());
            jsonArray.add(DateUtils.getDateLabel(sender.getDateOfBirth()));
            jsonArray.add(sender.getIdentityNumber());
            jsonArray.add(DateUtils.getDateLabel(sender.getExpiredDate()));
            jsonArray.add(sender.getEmail());
            jsonArray.add(sender.isBlacklist());
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
    
    /**
     * @param accountNo
     * @return {@link Result}
     */
    @AuthorizationAnnotation({"role_administrator", "role_compliance_officer" })
    @SuppressWarnings("unchecked")
    @Transactional(readOnly = true)
    public static Result checkAccount(){
        final Map<String, String[]> params = request().queryString();
        final String accountNo = params.get(ACCOUNT_NO)[0];
        final Query query = JPA.em().createQuery("SELECT id FROM Sender WHERE accountNo = :accountNo");
        query.setParameter(ACCOUNT_NO, accountNo);
        query.setMaxResults(1);
        final List<String> accountNumbers = query.getResultList();
        if(accountNumbers.size() == 1){
            return ok(toJson("1"));
        }
        return ok(toJson(StringUtil.ZERO));
    }
    
    /**
     * @param senderId
     * @return {@link Result}
     */
    @SuppressWarnings("unchecked")
    @Transactional(readOnly = true)
    public static Result isInTransaction(){
        final Map<String, String[]> params = request().queryString();
        final String senderId = params.get(SENDER_ID)[0];
        final Query query = JPA.em().createQuery("SELECT id FROM SenderReceiverTransaction srt WHERE srt.sender.id=:senderId");
        query.setParameter(SENDER_ID, Long.parseLong(senderId));
        query.setMaxResults(1);
        final List<String> SenderReceiverTransactionIDs = query.getResultList();
        if(SenderReceiverTransactionIDs.size() == 1){
            return ok(toJson("1"));
        }
        return ok(toJson(StringUtil.ZERO));
    }
}
