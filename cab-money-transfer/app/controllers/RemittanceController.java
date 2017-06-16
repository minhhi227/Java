/**
 * Created on: 5/10/2014
 */
package controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import models.CurrencyExchange;
import models.Receiver;
import models.RuleFillAmountManagement;
import models.Sender;
import models.SenderReceiverTransaction;
import models.TempCodeGeneration;
import models.User;
import models.dto.datatable.RemittanceReportDataTableParams;
import models.enums.TransactionStatus;
import models.enums.TypeCodeGeneration;

import org.apache.commons.lang3.StringUtils;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import play.Logger;
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
 * @author vichrak
 *
 */
@Security.Authenticated(Secured.class)
@AuthorizationAnnotation({"role_administrator", "role_teller", "role_compliance_officer", "role_reporter" })
public class RemittanceController extends AbstractController{
    
    private static final String TRANSACTION_ID = "transactionId";
    private static User _user;
    
    @SuppressWarnings("unchecked")
    @Transactional(readOnly = true)
    public static Result index(){
        requestUri = request().uri();
        _user = User.findByLogin(request().username());
        final List<CurrencyExchange> currencies = (List<CurrencyExchange>) Cache.get(CABConstantKeys.CURRENCY);
        final String strTypeSender = StringUtils.join((List<String>) Cache.get(CABConstantKeys.SENDER_TYPE), ";");
        final Long branchId = (Long) Cache.get(getUsername() + CABConstantKeys.BRANCH_SUFFIX);
        final List<SenderReceiverTransaction> blockedRemittanceTransactions = SenderReceiverTransaction.getBlockingRemittanceTransaction(branchId, getUsername());
        final List<SenderReceiverTransaction> rejectedAndApprovedTxs = SenderReceiverTransaction.getRejectedAndApprovedTransactions(branchId, getUsername());
        final String notificationInterval = ConfigFactory.load().getString("NOTIFICATION_INTERVAL");
        
        String roleCode = (String) Cache.get(getUsername() + CABConstantKeys.ROLE_CODE_SUFFIX);
        if(roleCode.equals("role_teller")){
            return ok(views.html.teller.remittance.render(_user, currencies, strTypeSender, "remittance", blockedRemittanceTransactions, rejectedAndApprovedTxs, null, notificationInterval));
        }
        else{
            return ok(views.html.teller.remittance_readonly.render(_user, currencies, strTypeSender, "remittance", blockedRemittanceTransactions, rejectedAndApprovedTxs, null, notificationInterval));
        }
        
    }
    
    @Transactional(readOnly = true)
    public static Result getRuleFillAmount(){
        List<RuleFillAmountManagement> rulesAmountManagements = RuleFillAmountManagement.getAll();
        final JSONObject jsonObject = buildJsonRuleManagement(rulesAmountManagements);
        final JsonNode senderReceiverTransactionJson = Json.toJson(jsonObject);
        return ok(senderReceiverTransactionJson);
    }
    
    @SuppressWarnings("unchecked")
    private static JSONObject buildJsonRuleManagement(final List<RuleFillAmountManagement> rulesAmountManagements){
        final JSONObject jsonObject = new JSONObject();
        Map<String, List<RuleFillAmountManagement>> map = new HashMap<String, List<RuleFillAmountManagement>>();
        for(RuleFillAmountManagement rule : rulesAmountManagements){
            String key = rule.getSenderType();
            if(map.containsKey(key)){
                map.get(key).add(rule);
            }
            else{
                List<RuleFillAmountManagement> tempRule = new ArrayList<RuleFillAmountManagement>();
                tempRule.add(rule);
                map.put(key, tempRule);
            }
        }
        
        for(Map.Entry<String, List<RuleFillAmountManagement>> entry : map.entrySet()){
            jsonObject.put(entry.getKey(), entry.getValue());
        }
        
        return jsonObject;
    }
    
    @SuppressWarnings("unchecked")
    @Transactional(readOnly = true)
    public static Result getById(){
        final Map<String, String[]> params = request().queryString();
        final Long transactionId = Long.parseLong(params.get(TRANSACTION_ID)[0]);
        final SenderReceiverTransaction senderReceiverTransaction = (SenderReceiverTransaction) SenderReceiverTransaction.findById(SenderReceiverTransaction.class, transactionId);
        
        if(StringUtils.isNotBlank(senderReceiverTransaction.getSender().getCompanyName())){
            senderReceiverTransaction.getSender().setFullName(senderReceiverTransaction.getSender().getCompanyName());
        }
        Cache.set(getUsername() + CABConstantKeys.RECORD_TRANSACTION, senderReceiverTransaction);
        final JSONObject jsonObject = new JSONObject();
        jsonObject.put("result", senderReceiverTransaction);
        jsonObject.put("dateTransaction", DateUtils.getDateTimeLabel(senderReceiverTransaction.getDateTransaction()));
        final int tempTotal = (int) Math.floor(senderReceiverTransaction.getTotalAmount());
        jsonObject.put("totalInWords", StringUtil.convertNumberToWords(tempTotal));
        jsonObject.put("user", getUsername());
        final JsonNode senderReceiverTransactionJson = Json.toJson(jsonObject);
        return ok(senderReceiverTransactionJson);
    }
    
    /**
     *
     * @return
     */
    @SuppressWarnings("unchecked")
    @Transactional
    public static Result getBankReference(){
        final User user = (User) Cache.get(request().username() + CABConstantKeys.USER_SUFIX);
        final String code = TempCodeGeneration.genereateBankReference(user.getBranch(), user.getBranch().getBankReference(), TypeCodeGeneration.CODE_GENERATION_BANK_REF.getCode());
        final JSONObject jsonObject = new JSONObject();
        jsonObject.put("bankRef", code);
        jsonObject.put("dateTransaction", DateUtils.getDateCurrenceLabel());
        final JsonNode senderJson = Json.toJson(jsonObject);
        return ok(senderJson);
    }
    
    @SuppressWarnings("unchecked")
    @Transactional
    public static Result previewRemittanceTransaction(){
        try{
            final JsonNode rootNode = request().body().asJson();
            if(rootNode != null){
                final Long remittanceId = rootNode.path("hidRemittanceId").asLong();
                final Long senderId = rootNode.path("hidSenderId").asLong();
                final Sender sender = (Sender) Sender.findById(Sender.class, senderId);
                
                final Long recieverId = rootNode.path("hidRecieverId").asLong();
                final String txtInterBank = rootNode.path("txtInterBank").asText();
                final String txtSwiftCode = rootNode.path("txtSwiftCode").asText();
                final String txtBankAddress = rootNode.path("txtBankAddress").asText();
                final String txtRcAccNumber = rootNode.path("txtRcAccNumber").asText();
                final String txtRcFullName = rootNode.path("hidRcFullName").asText();
                Receiver receiverDb = null;
                if(recieverId == 0){
                    receiverDb = Receiver.getByAccountNo(txtRcAccNumber);
                }
                else{
                    receiverDb = (Receiver) Receiver.findById(Receiver.class, recieverId);
                }
                if(receiverDb == null){
                    receiverDb = new Receiver();
                }
                
                receiverDb.setFullName(txtRcFullName);
                receiverDb.setIntermediaryBank(txtInterBank);
                receiverDb.setSwiftCode(txtSwiftCode);
                receiverDb.setBankAddress(txtBankAddress);
                receiverDb.setAccountNo(txtRcAccNumber);
                receiverDb = (Receiver) Receiver.saveOrUpdate(receiverDb);
                
                final String txtRcPurpose = rootNode.path("txtRcPurpose").asText();
                final double txtAmount = rootNode.path("txtAmount").asDouble();
                final CurrencyExchange selCurrency = (CurrencyExchange) CurrencyExchange.findById(CurrencyExchange.class, rootNode.path("selCurrency").asLong());
                final double txtExchangeRate = rootNode.path("txtExchangeRate").asDouble();
                final double txtUsdEquivalent = rootNode.path("txtUsdEquivalent").asDouble();
                final double txtFee = rootNode.path("txtFee").asDouble();
                final double txtCable = rootNode.path("txtCable").asDouble();
                final double txtOther = rootNode.path("txtOther").asDouble();
                final String txtCharge = rootNode.path("txtCharge").asText();
                
                final User user = (User) Cache.get(request().username() + CABConstantKeys.USER_SUFIX);
                final String codeBankRef = TempCodeGeneration.genereateBankReference(user.getBranch(), user.getBranch().getBankReference(), TypeCodeGeneration.CODE_GENERATION_BANK_REF.getCode());
                final String txtBankRef = codeBankRef;//rootNode.path("txtBankRef").asText();
                final String txtDateTransaction = DateUtils.getDateCurrenceLabel();//rootNode.path("txtDateTransaction").asText();
                final Date dateTransaction = DateUtils.getDateTime(txtDateTransaction, DateUtils.FORMDATE_TIME);
                final double txtPostage = rootNode.path("txtPostage").asDouble();
                final double totalAmount = txtUsdEquivalent + txtFee + txtCable;
                final long processId = rootNode.path("hidProcess").asLong();
                
                SenderReceiverTransaction senderReceiverTransaction = null;
                if(processId == 2){
                    senderReceiverTransaction = (SenderReceiverTransaction) SenderReceiverTransaction.findById(SenderReceiverTransaction.class, remittanceId);
                }
                
                if(senderReceiverTransaction == null){
                    senderReceiverTransaction = new SenderReceiverTransaction();
                }
                
                senderReceiverTransaction.setAmount(txtAmount);
                senderReceiverTransaction.setCurrency(selCurrency);
                senderReceiverTransaction.setExchangeAmount(txtExchangeRate);
                senderReceiverTransaction.setUsdEquivalent(txtUsdEquivalent);
                senderReceiverTransaction.setFee(txtFee);
                senderReceiverTransaction.setCable(txtCable);
                senderReceiverTransaction.setOther(txtOther);
                senderReceiverTransaction.setCharge(txtCharge);
                senderReceiverTransaction.setPurpose(txtRcPurpose);
                senderReceiverTransaction.setTotalAmount(totalAmount);
                senderReceiverTransaction.setBankRef(txtBankRef);
                senderReceiverTransaction.setDateTransaction(dateTransaction);
                senderReceiverTransaction.setPostage(txtPostage);
                
                //final User user = (User) Cache.get(request().username() + CABConstantKeys.USER_SUFIX);
                //final User user = User.findByLogin(request().username());
                senderReceiverTransaction.setBranch(user.getBranch());
                senderReceiverTransaction.setSender(sender);
                senderReceiverTransaction.setReceiver(receiverDb);
                if(senderReceiverTransaction.getId() == null || senderReceiverTransaction.getId() == 0){
                    senderReceiverTransaction.setCreatedBy(_user.getUsername());
                }
                senderReceiverTransaction.setModifiedBy(_user.getUsername());
                
                if(sender.isBlacklist()){
                    // can't sent
                    senderReceiverTransaction.setReason(CABConstantKeys.REASON_TRANSACTION_BLACKlIST);
                    senderReceiverTransaction = SenderReceiverTransaction.saveUpdateByJsonNodeAndSatus(senderReceiverTransaction, TransactionStatus.TRANSACTION_REJECTED.getCode());
                    
                    final JSONObject jsonObject = new JSONObject();
                    jsonObject.put("result", CABConstantKeys.BLOCK);
                    jsonObject.put(CABConstantKeys.MESSAGE, CABConstantKeys.MESAGE_TRANSACTION_BLACKlIST);
                    final JsonNode jsonNode = Json.toJson(jsonObject);
                    return ok(jsonNode);
                }
                // 2)   Sender send to receiver more than two
                final List<Long> listRecieverId = SenderReceiverTransaction.getRecieverIdBySenderId(sender.getId());
                if(listRecieverId.size() > sender.getNbRecieverRestriction()){
                    // send transaction to blocklist
                    sender.setBlock(true);
                    Sender.saveOrUpdate(sender);
                    String reason = CABConstantKeys.REASON_TRANSACTION_SENDER_BLOCK;
                    reason = reason.replace("[TELLER]", user.getFullName());
                    reason = reason.replace("[SENDER]", StringUtils.isNotBlank(senderReceiverTransaction.getSender().getFullName()) ? senderReceiverTransaction.getSender().getFullName() : senderReceiverTransaction.getSender().getCompanyName());
                    senderReceiverTransaction.setReason(reason);
                    // send notificatoin to compliant officer
                    senderReceiverTransaction.setTransactionStatus(TransactionStatus.TRANSACTION_BLOCKING.getCode());
                    Cache.set(getUsername() + CABConstantKeys.RECORD_TRANSACTION, senderReceiverTransaction);
                    final JSONObject jsonObject = new JSONObject();
                    jsonObject.put("result", CABConstantKeys.WARNING);
                    jsonObject.put(CABConstantKeys.MESSAGE, CABConstantKeys.MESSAGE_TRANSACTION_SENDER_BLOCK);
                    final JsonNode jsonNode = Json.toJson(jsonObject);
                    return ok(jsonNode);
                }
                else if(listRecieverId.size() == sender.getNbRecieverRestriction() && !listRecieverId.contains(receiverDb.getId())){
                    // send transaction to blocklist
                    sender.setBlock(true);
                    Sender.saveOrUpdate(sender);
                    String reason = CABConstantKeys.REASON_TRANSACTION_SENDER_BLOCK;
                    reason = reason.replace("[TELLER]", user.getFullName());
                    reason = reason.replace("[SENDER]", StringUtils.isNotBlank(senderReceiverTransaction.getSender().getFullName()) ? senderReceiverTransaction.getSender().getFullName() : senderReceiverTransaction.getSender().getCompanyName());
                    senderReceiverTransaction.setReason(reason);
                    senderReceiverTransaction.setTransactionStatus(TransactionStatus.TRANSACTION_BLOCKING.getCode());
                    Cache.set(getUsername() + CABConstantKeys.RECORD_TRANSACTION, senderReceiverTransaction);
                    final JSONObject jsonObject = new JSONObject();
                    jsonObject.put("result", CABConstantKeys.WARNING);
                    jsonObject.put(CABConstantKeys.MESSAGE, CABConstantKeys.MESSAGE_TRANSACTION_SENDER_BLOCK);
                    final JsonNode jsonNode = Json.toJson(jsonObject);
                    return ok(jsonNode);
                }
                // 3)   Receiver is being received money from sender more than two
                final List<Long> listSenderId = SenderReceiverTransaction.getSenderIdByRecieverId(receiverDb.getId());
                if(listSenderId.size() > receiverDb.getNbSenderRestriction()){
                    // send transaction to blocklist
                    receiverDb.setBlock(true);
                    Receiver.saveOrUpdate(receiverDb);
                    String reason = CABConstantKeys.REASON_TRANSACTION_RECEIVER_BLOCK;
                    reason = reason.replace("[TELLER]", user.getFullName());
                    reason = reason.replace("[SENDER]", StringUtils.isNotBlank(senderReceiverTransaction.getSender().getFullName()) ? senderReceiverTransaction.getSender().getFullName() : senderReceiverTransaction.getSender().getCompanyName());
                    reason = reason.replace("[RECEIVER]", senderReceiverTransaction.getReceiver().getFullName());
                    senderReceiverTransaction.setReason(reason);
                    senderReceiverTransaction.setTransactionStatus(TransactionStatus.TRANSACTION_BLOCKING.getCode());
                    Cache.set(getUsername() + CABConstantKeys.RECORD_TRANSACTION, senderReceiverTransaction);
                    final JSONObject jsonObject = new JSONObject();
                    jsonObject.put("result", CABConstantKeys.WARNING);
                    jsonObject.put(CABConstantKeys.MESSAGE, CABConstantKeys.MESSAGE_TRANSACTION_RECIEVER_BLOCK);
                    final JsonNode jsonNode = Json.toJson(jsonObject);
                    return ok(jsonNode);
                }
                else if(listSenderId.size() == receiverDb.getNbSenderRestriction() && !listSenderId.contains(sender.getId())){
                    // send transaction to blocklist
                    receiverDb.setBlock(true);
                    Receiver.saveOrUpdate(receiverDb);
                    String reason = CABConstantKeys.REASON_TRANSACTION_RECEIVER_BLOCK;
                    reason = reason.replace("[TELLER]", user.getFullName());
                    reason = reason.replace("[SENDER]", StringUtils.isNotBlank(senderReceiverTransaction.getSender().getFullName()) ? senderReceiverTransaction.getSender().getFullName() : senderReceiverTransaction.getSender().getCompanyName());
                    reason = reason.replace("[RECEIVER]", senderReceiverTransaction.getReceiver().getFullName());
                    senderReceiverTransaction.setReason(reason);
                    senderReceiverTransaction.setTransactionStatus(TransactionStatus.TRANSACTION_BLOCKING.getCode());
                    Cache.set(getUsername() + CABConstantKeys.RECORD_TRANSACTION, senderReceiverTransaction);
                    final JSONObject jsonObject = new JSONObject();
                    jsonObject.put("result", CABConstantKeys.WARNING);
                    jsonObject.put(CABConstantKeys.MESSAGE, CABConstantKeys.MESSAGE_TRANSACTION_RECIEVER_BLOCK);
                    final JsonNode jsonNode = Json.toJson(jsonObject);
                    return ok(jsonNode);
                }
                
                senderReceiverTransaction.setTransactionStatus(TransactionStatus.TRANSACTION_DONE.getCode());
                Cache.set(getUsername() + CABConstantKeys.RECORD_TRANSACTION, senderReceiverTransaction);
                final JSONObject jsonObject = new JSONObject();
                jsonObject.put("result", senderReceiverTransaction);
                jsonObject.put("dateTransaction", DateUtils.getDateTimeLabel(senderReceiverTransaction.getDateTransaction()));
                final int tempTotal = (int) Math.floor(senderReceiverTransaction.getTotalAmount());
                jsonObject.put("totalInWords", StringUtil.convertNumberToWords(tempTotal));
                jsonObject.put("user", getUsername());
                final JsonNode senderReceiverTransactionJson = Json.toJson(jsonObject);
                return ok(senderReceiverTransactionJson);
            }
        }
        catch(final Exception e){
            Logger.error(e.getMessage(), e);
        }
        return ok(Json.toJson(CABConstantKeys.FAILED));
    }
    
    @SuppressWarnings("unchecked")
    @Transactional(readOnly = true)
    public static Result getRecieverBySenderId(){
        final Map<String, String[]> params = request().queryString();
        final Long senderId = Long.parseLong(params.get("senderId")[0]);
        final List<Receiver> listReciever = SenderReceiverTransaction.getRecieverBySenderId(senderId);
        final JsonNode senderJson = Json.toJson(listReciever);
        final JSONObject jsonObject = new JSONObject();
        jsonObject.put("total", listReciever.size());
        jsonObject.put("rows", senderJson);
        final JsonNode jsonNode = Json.toJson(jsonObject);
        return ok(jsonNode);
    }
    
    @SuppressWarnings("unchecked")
    @Transactional(readOnly = true)
    public static Result getSenderByRecieverId(){
        final Map<String, String[]> params = request().queryString();
        final Long receiverId = Long.parseLong(params.get("receiverId")[0]);
        final List<Sender> listReciever = SenderReceiverTransaction.getSenderByRecieverId(receiverId);
        final JsonNode senderJson = Json.toJson(listReciever);
        final JSONObject jsonObject = new JSONObject();
        jsonObject.put("total", listReciever.size());
        jsonObject.put("rows", senderJson);
        final JsonNode jsonNode = Json.toJson(jsonObject);
        return ok(jsonNode);
    }
    
    @Transactional
    public static Result saveOrUpdateRemittanceTransaction(){
        try{
            SenderReceiverTransaction senderReceiverTransaction = (SenderReceiverTransaction) Cache.get(getUsername() + CABConstantKeys.RECORD_TRANSACTION);
            Cache.set(getUsername() + CABConstantKeys.RECORD_TRANSACTION, null);
            
            final JsonNode rootNode = request().body().asJson();
            if(rootNode != null){
                final String dateTransaction = rootNode.path("dateTransaction").asText();
                final String bankRef = rootNode.path("bankRef").asText();
                if(StringUtils.isNotBlank(dateTransaction)){
                    senderReceiverTransaction.setDateTransaction(DateUtils.getDate(dateTransaction, DateUtils.FORMDATE_TIME));
                }
                senderReceiverTransaction.setBankRef(bankRef);
            }
            
            senderReceiverTransaction = (SenderReceiverTransaction) SenderReceiverTransaction.saveOrUpdate(senderReceiverTransaction);
            
            return ok(Json.toJson(CABConstantKeys.SUCCESS));
        }
        catch(final Exception e){
            Logger.error(e.getMessage());
        }
        return ok(Json.toJson(CABConstantKeys.FAILED));
    }
    
    @SuppressWarnings("unchecked")
    @Transactional(readOnly = true)
    public static Result getRemittanceList(){
        final Map<String, String[]> parames = request().queryString();
        final RemittanceReportDataTableParams remittanceReportDataTableParams = new RemittanceReportDataTableParams(parames);
        remittanceReportDataTableParams.setUsername(getUsername());
        final List<SenderReceiverTransaction> listSenderReceiverTransactions = SenderReceiverTransaction.getRemittanceList(remittanceReportDataTableParams);
        final JSONObject jsonObject = new JSONObject();
        final JSONArray[] jsonData = new JSONArray[listSenderReceiverTransactions.size()];
        
        remittanceReportDataTableParams.setiTotalRecords(SenderReceiverTransaction.countRemittanceListByJQueryDataTableParam(remittanceReportDataTableParams));
        int i = 0;
        for(final SenderReceiverTransaction senderReceiverTransaction : listSenderReceiverTransactions){
            final Sender sender = senderReceiverTransaction.getSender();
            final Receiver receiver = senderReceiverTransaction.getReceiver();
            final String senderFullName = (StringUtils.isNotBlank(sender.getFullName()) ? sender.getFullName() : sender.getCompanyName()) + (StringUtils.isNotBlank(sender.getAccountNo()) ? " [" + sender.getAccountNo() + "]" : "");
            final String recieverFullName = receiver.getFullName() + " [" + receiver.getAccountNo() + "]";
            final String dateSend = DateUtils.getDateLabel(senderReceiverTransaction.getDateTransaction());
            final String bankSwitCode = receiver.getSwiftCode();
            final Double totalAmount = senderReceiverTransaction.getAmount();
            
            final JSONArray jsonArray = new JSONArray();
            jsonArray.add(i + 1);
            jsonArray.add(senderReceiverTransaction.getId());
            jsonArray.add(senderFullName);
            jsonArray.add(recieverFullName);
            jsonArray.add(dateSend);
            jsonArray.add(bankSwitCode);
            jsonArray.add(totalAmount);
            jsonArray.add(senderReceiverTransaction.getCurrency().getName());
            jsonArray.add(senderReceiverTransaction.getExchangeAmount());
            jsonArray.add(senderReceiverTransaction.getUsdEquivalent());
            jsonArray.add(senderReceiverTransaction.getFee());
            jsonArray.add(senderReceiverTransaction.getCable());
            jsonData[i] = jsonArray;
            i++;
        }
        
        jsonObject.put(CABConstantKeys.SECHO, remittanceReportDataTableParams.getsEcho());
        jsonObject.put(CABConstantKeys.ITOTALRECORDS, remittanceReportDataTableParams.getiTotalRecords());
        jsonObject.put(CABConstantKeys.ITOTALDISPLAYRECORDS, remittanceReportDataTableParams.getiTotalRecords());
        jsonObject.put(CABConstantKeys.AADATA, jsonData);
        final JsonNode jsonNode = Json.toJson(jsonObject);
        return ok(jsonNode);
    }
    
    @SuppressWarnings("unchecked")
    @Transactional
    public static Result updateTransactionStatus(){
        Result result = null;
        try{
            final Map<String, String[]> params = request().queryString();
            final String transactionId = params.get(TRANSACTION_ID)[0];
            final String status = params.get("status")[0];
            result = JPA.withTransaction(new play.libs.F.Function0<Result>(){
                
                @Override
                public Result apply() throws Throwable{
                    final JSONObject jsonObject = new JSONObject();
                    Result result = null;
                    final SenderReceiverTransaction remittanceTx = (SenderReceiverTransaction) SenderReceiverTransaction.findById(SenderReceiverTransaction.class, Long.parseLong(transactionId));
                    remittanceTx.setTransactionStatus(status);
                    if(status.equals(TransactionStatus.TRANSACTION_REVIEWED.getCode())){
                        remittanceTx.setReviewedBy(getUsername());
                        jsonObject.put("response", "review");
                        jsonObject.put("result", remittanceTx);
                        jsonObject.put("dateTransaction", DateUtils.getDateTimeLabel(remittanceTx.getDateTransaction()));
                        final JsonNode senderReceiverTransactionJson = Json.toJson(jsonObject);
                        result = ok(senderReceiverTransactionJson);
                    }
                    else if(status.equals(TransactionStatus.TRANSACTION_CANCELED.getCode())){
                        String reason = remittanceTx.getReason();
                        reason += CABConstantKeys.MESSAGE_TRANSACTION_CANCELED;
                        remittanceTx.setReason(reason);
                        remittanceTx.setModifiedBy(getUsername());
                        result = ok(Json.toJson(CABConstantKeys.SUCCESS));
                    }
                    else{
                        if(status.equals(TransactionStatus.TRANSACTION_APPROVED.getCode())){
                            final Sender sender = remittanceTx.getSender();
                            if(sender.isBlock()){
                                sender.setNbRecieverRestriction(sender.getNbRecieverRestriction() + 1);
                                sender.setBlock(false);
                                Sender.saveOrUpdate(sender);
                            }
                            final Receiver receiver = remittanceTx.getReceiver();
                            if(receiver.isBlock()){
                                receiver.setNbSenderRestriction(receiver.getNbSenderRestriction() + 1);
                                receiver.setBlock(false);
                                Receiver.saveOrUpdate(receiver);
                            }
                        }
                        jsonObject.put("response", "non-review");
                        final JsonNode responseJson = Json.toJson(jsonObject);
                        result = ok(responseJson);
                    }
                    SenderReceiverTransaction.saveOrUpdate(remittanceTx);
                    return result;
                }
                
            });
        }
        catch(final Throwable ex){
            Logger.error(ex.getMessage(), ex);
        }
        return result;
    }
    
    @SuppressWarnings("unchecked")
    @Transactional(readOnly = true)
    public static Result continueTransaction(){
        final Map<String, String[]> params = request().queryString();
        final String continuingTransactionId = params.get("continuingTransactionId")[0];
        final List<CurrencyExchange> currencies = (List<CurrencyExchange>) Cache.get(CABConstantKeys.CURRENCY);
        final String strTypeSender = StringUtils.join((List<String>) Cache.get(CABConstantKeys.SENDER_TYPE), ";");
        final Long branchId = (Long) Cache.get(getUsername() + CABConstantKeys.BRANCH_SUFFIX);
        final List<SenderReceiverTransaction> blockedRemittanceTransactions = SenderReceiverTransaction.getBlockingRemittanceTransaction(branchId, getUsername());
        final List<SenderReceiverTransaction> rejectedAndApprovedTxs = SenderReceiverTransaction.getRejectedAndApprovedTransactions(branchId, getUsername());
        final String notificationInterval = ConfigFactory.load().getString("NOTIFICATION_INTERVAL");
        return ok(views.html.teller.remittance.render(_user, currencies, strTypeSender, "remittance", blockedRemittanceTransactions, rejectedAndApprovedTxs, continuingTransactionId, notificationInterval));
        
    }
    
    @SuppressWarnings("unchecked")
    @Transactional(readOnly = true)
    public static Result getNotificationsForCO(){
        Result result = null;
        try{
            result = JPA.withTransaction(new play.libs.F.Function0<Result>(){
                
                @Override
                public Result apply() throws Throwable{
                    final Long branchId = (Long) Cache.get(getUsername() + CABConstantKeys.BRANCH_SUFFIX);
                    final List<SenderReceiverTransaction> blockingRemittanceTransactions = SenderReceiverTransaction.getBlockingRemittanceTransaction(branchId, getUsername());
                    final JSONObject jsonObject = new JSONObject();
                    jsonObject.put("result", blockingRemittanceTransactions);
                    final JsonNode blockingRemittanceTransactionJson = Json.toJson(jsonObject);
                    return ok(blockingRemittanceTransactionJson);
                }
                
            });
        }
        catch(final Throwable ex){
            Logger.error(ex.getMessage(), ex);
        }
        
        return result;
    }
    
    @SuppressWarnings("unchecked")
    @Transactional(readOnly = true)
    public static Result getNotificationsForTeller(){
        Result result = null;
        try{
            result = JPA.withTransaction(new play.libs.F.Function0<Result>(){
                
                @Override
                public Result apply() throws Throwable{
                    final Long branchId = (Long) Cache.get(getUsername() + CABConstantKeys.BRANCH_SUFFIX);
                    final List<SenderReceiverTransaction> rejectedAndApprovedTxs = SenderReceiverTransaction.getRejectedAndApprovedTransactions(branchId, getUsername());
                    final JSONObject jsonObject = new JSONObject();
                    jsonObject.put("result", rejectedAndApprovedTxs);
                    final JsonNode rejectedAndApprovedTxsJson = Json.toJson(jsonObject);
                    return ok(rejectedAndApprovedTxsJson);
                }
                
            });
        }
        catch(final Throwable ex){
            Logger.error(ex.getMessage(), ex);
        }
        return result;
    }
}
