/**
 * Created on: 5/10/2014
 */
package controllers;

import static play.libs.Json.toJson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Query;

import models.CurrencyExchange;
import models.Receiver;
import models.SenderReceiverTransaction;
import models.User;
import models.dto.JQueryDataTableParamModelDto;
import models.dto.ReceiverDto;
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
import utils.StringUtil;
import annotation.AuthorizationAnnotation;

import com.fasterxml.jackson.databind.JsonNode;
import com.typesafe.config.ConfigFactory;

import controllers.core.AbstractController;
import controllers.core.Secured;

/**
 * @author vichrak
 *
 */
@Security.Authenticated(Secured.class)
@AuthorizationAnnotation({"role_administrator", "role_teller" })
public class ReceiverController extends AbstractController{
    
    private static final Log LOG = LogFactory.getLog(ReceiverController.class);
    private static User _user;
    
    @SuppressWarnings("unchecked")
    @Transactional(readOnly = true)
    public static Result index(){
        requestUri = request().uri();
        _user = User.findByLogin(request().username());
        final Long branchId = (Long) Cache.get(getUsername() + CABConstantKeys.BRANCH_SUFFIX);
        final List<CurrencyExchange> currencies = (List<CurrencyExchange>) Cache.get(CABConstantKeys.CURRENCY);
        final List<SenderReceiverTransaction> rejectedAndApprovedTxs = SenderReceiverTransaction.getRejectedAndApprovedTransactions(branchId, getUsername());
        final String notificationInterval = ConfigFactory.load().getString("NOTIFICATION_INTERVAL");
        return ok(views.html.teller.receiver.render(_user, "receiver", rejectedAndApprovedTxs, notificationInterval, currencies));
    }
    
    @SuppressWarnings("unchecked")
    @Transactional(readOnly = true)
    public static Result filterByFullNameANDAccountNo(){
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
                final JsonNode listRecieverJson = Json.toJson(new ArrayList<ReceiverDto>());
                final JSONObject jsonObject = new JSONObject();
                jsonObject.put("total", 0);
                jsonObject.put("rows", listRecieverJson);
                final JsonNode jsonNode = play.libs.Json.toJson(jsonObject);
                return ok(jsonNode);
            }
            //        final String accountNo = (requestBody.get("accountNo") != null) ? requestBody.get("accountNo")[0] : "";
            final List<ReceiverDto> listReciever = Receiver.filterByFullNameOrAccountNo(fullName);
            final JsonNode listRecieverJson = Json.toJson(listReciever);
            final JSONObject jsonObject = new JSONObject();
            
            //            final int limit = Integer.parseInt(requestString.get("rows")[0]);
            //            int totalPage = listReciever.size() / limit;
            //            if (listReciever.size() > 0 && totalPage == 0) {
            //                totalPage = 1;
            //            }
            //            int page = Integer.parseInt(requestString.get("page")[0]);
            //            if (page > totalPage) {
            //                page = totalPage;
            //            }
            
            //            jsonObject.put("page", page);
            jsonObject.put("total", listReciever.size());
            //            jsonObject.put("records", listReciever.size());
            jsonObject.put("rows", listRecieverJson);
            final JsonNode jsonNode = play.libs.Json.toJson(jsonObject);
            return ok(jsonNode);
        }
    }
    
    /**
     * @return {@link Result}
     */
    @Transactional
    public static Result saveOrUpdateReceiver(){
        try{
            final JsonNode rootNode = request().body().asJson();
            if(rootNode != null){
                final Long receiverId = rootNode.path("receiverId").asLong();
                final String accountNo = rootNode.path("receiverAccountNo").asText();
                
                Receiver receiver = null;
                if(isReceiverExists(receiverId, accountNo) == false){
                    if(receiverId == 0){ /* add receiver */
                        receiver = new Receiver();
                    }
                    else{ /* edit receiver */
                        receiver = (Receiver) Receiver.findById(Receiver.class, receiverId);
                    }
                }
                else{
                    return ok(toJson("receiver_exists"));
                }
                
                final String intermediaryBank = rootNode.path("receiverIntermediaryBank").asText();
                final String swiftCode = rootNode.path("receiverSwiftCode").asText();
                final String fullName = rootNode.path("receiverFullName").asText();
                final String bankAddress = rootNode.path("receiverBankAddress").asText();
                //                final String purpose = rootNode.path("receiverPurpose").asText();
                final boolean isBlacklist = rootNode.path("receiverBlacklist").asBoolean();
                final boolean isBlock = rootNode.path("receiverBlock").asBoolean();
                
                receiver.setIntermediaryBank(intermediaryBank);
                receiver.setSwiftCode(swiftCode);
                receiver.setAccountNo(accountNo);
                receiver.setFullName(fullName);
                receiver.setBankAddress(bankAddress);
                receiver.setBlacklist(isBlacklist);
                receiver.setBlock(isBlock);
                
                receiver = (Receiver) Receiver.saveOrUpdate(receiver);
                
                return ok(toJson(receiver.getId().toString()));
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
    
    @SuppressWarnings("unchecked")
    @Transactional(readOnly = true)
    public static Result filterReceiver(){
        final Map<String, String[]> parames = request().queryString();
        final JQueryDataTableParamModelDto jQueryDataTableParamModel = new JQueryDataTableParamModelDto(parames);
        
        try{
            if(parames != null && (parames.get("searchIntermidiary") != null)){
                final String searchIntermidiary = parames.get("searchIntermidiary")[0];
                final String searchSwiftCode = parames.get("searchSwiftCode")[0];
                final String searchAccountNumber = parames.get("searchAccountNumber")[0];
                final String searchFullName = parames.get("searchFullName")[0];
                
                final StringBuilder queryString = new StringBuilder("FROM Receiver");
                
                final StringBuilder whereClause = new StringBuilder();
                if(StringUtils.isNotBlank(searchIntermidiary)){
                    whereClause.append("LOWER(intermediaryBank) like :searchIntermidiary ");
                }
                if(StringUtils.isNotBlank(searchSwiftCode)){
                    if(StringUtils.isBlank(whereClause)){
                        whereClause.append("LOWER(swiftCode) like :searchSwiftCode ");
                    }
                    else{
                        whereClause.append("AND LOWER(swiftCode) like :searchSwiftCode ");
                    }
                }
                if(StringUtils.isNotBlank(searchAccountNumber)){
                    if(StringUtils.isBlank(whereClause)){
                        whereClause.append("LOWER(accountNo) like :searchAccountNumber ");
                    }
                    else{
                        whereClause.append("AND LOWER(accountNo) like :searchAccountNumber ");
                    }
                }
                if(StringUtils.isNotBlank(searchFullName)){
                    if(StringUtils.isBlank(whereClause)){
                        whereClause.append("LOWER(fullName) like :searchFullName ");
                    }
                    else{
                        whereClause.append("AND LOWER(fullName) like :searchFullName ");
                    }
                }
                if(StringUtils.isNotBlank(whereClause)){
                    queryString.append(" WHERE " + whereClause);
                }
                
                queryString.append(buildOrderByClause(jQueryDataTableParamModel));
                
                final Query query = JPA.em().createQuery(queryString.toString());
                
                if(StringUtils.isNotBlank(searchIntermidiary)){
                    query.setParameter("searchIntermidiary", CABConstantKeys.PERCENT + searchIntermidiary.toLowerCase() + CABConstantKeys.PERCENT);
                }
                if(StringUtils.isNotBlank(searchSwiftCode)){
                    query.setParameter("searchSwiftCode", CABConstantKeys.PERCENT + searchSwiftCode.toLowerCase() + CABConstantKeys.PERCENT);
                }
                if(StringUtils.isNotBlank(searchFullName)){
                    query.setParameter("searchFullName", CABConstantKeys.PERCENT + searchFullName.toLowerCase() + CABConstantKeys.PERCENT);
                }
                if(StringUtils.isNotBlank(searchAccountNumber)){
                    query.setParameter("searchAccountNumber", CABConstantKeys.PERCENT + searchAccountNumber.toLowerCase() + CABConstantKeys.PERCENT);
                }
                jQueryDataTableParamModel.setiTotalRecords(query.getResultList().size());
                query.setFirstResult(Integer.parseInt(jQueryDataTableParamModel.getiDisplayStart()));
                query.setMaxResults(Integer.parseInt(jQueryDataTableParamModel.getiDisplayLength()));
                
                final List<Receiver> recievers = query.getResultList();
                final JsonNode jsonNode = buildRecieverAsJsonNode(recievers, jQueryDataTableParamModel);
                return ok(jsonNode);
            }
            else{
                final Query query = JPA.em().createQuery("FROM Receiver");
                jQueryDataTableParamModel.setiTotalRecords(query.getResultList().size());
                query.setFirstResult(Integer.parseInt(jQueryDataTableParamModel.getiDisplayStart()));
                query.setMaxResults(Integer.parseInt(jQueryDataTableParamModel.getiDisplayLength()));
                
                final List<Receiver> recievers = query.getResultList();
                final JsonNode jsonNode = buildRecieverAsJsonNode(recievers, jQueryDataTableParamModel);
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
        columnsName.put(StringUtil.ZERO, "fullName");
        columnsName.put("2", "fullName");
        columnsName.put("3", "accountNo");
        columnsName.put("4", "intermediaryBank");
        columnsName.put("5", "swiftCode");
        columnsName.put("6", "bankAddress");
        return columnsName.get(jQueryDataTableParamModel.getiSortCol_0());
    }
    
    @SuppressWarnings("unchecked")
    private static JsonNode buildRecieverAsJsonNode(final List<Receiver> receivers, final JQueryDataTableParamModelDto jQueryDataTableParamModel){
        final JSONArray[] jsonData = new JSONArray[receivers.size()];
        int i = 0;
        for(final Receiver receiver : receivers){
            
            final JSONArray jsonArray = new JSONArray();
            jsonArray.add(i + 1);
            jsonArray.add(receiver.getId());
            jsonArray.add(receiver.getFullName());
            jsonArray.add(receiver.getAccountNo());
            jsonArray.add(receiver.getIntermediaryBank());
            jsonArray.add(receiver.getSwiftCode());
            jsonArray.add(receiver.getBankAddress());
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
     * @return true if the receiver exists in the database
     */
    @SuppressWarnings("unchecked")
    private static boolean isReceiverExists(final Long edittingReceiverId, final String accountNo){
        final StringBuilder queryString = new StringBuilder("select id from Receiver where ");
        queryString.append("accountNo=:accountNo and id <> :edittingReceiverId");
        
        final Query query = JPA.em().createQuery(queryString.toString());
        query.setParameter("accountNo", accountNo);
        query.setParameter("edittingReceiverId", edittingReceiverId);
        query.setMaxResults(1);
        
        final List<Long> receiverIds = query.getResultList();
        if(receiverIds.size() == 0){
            return false;
        }
        return true;
    }
    
}
