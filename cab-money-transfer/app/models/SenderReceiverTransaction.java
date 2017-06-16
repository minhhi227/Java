/*
 * Created on Oct 9, 2014
 */
package models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Query;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import models.core.AbstractAuditableEntity;
import models.dto.datatable.RemittanceReportDataTableParams;
import models.enums.TransactionStatus;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.annotations.Index;

import play.cache.Cache;
import play.db.jpa.JPA;
import utils.CABConstantKeys;
import utils.DateUtils;
import utils.StringUtil;

/**
 * @author Vichrak
 *
 */
@Entity
@Table(name = "SENDER_RECEIVER_TRANSACTION")
@SequenceGenerator(allocationSize = 1, name = "id_sequence", sequenceName = "sender_receiver_id_sequence")
public class SenderReceiverTransaction extends AbstractAuditableEntity{
    
    private static final long serialVersionUID = 1L;
    public static final String BRANCH_ID = "branchId";
    public static final String START_DATE = "startDate";
    public static final String END_DATE = "endDate";
    
    /* for advanced search remittance */
    private static final String SENDER_FULL_NAME = "senderFullName";
    private static final String SENDER_ACCOUNT_NO = "senderAccountNo";
    private static final String SENDER_IDENTITY_NUMBER = "senderIdentityNo";
    private static final String INTERMEDIARY_BANK = "intermediaryBank";
    private static final String SWIFT_CODE = "swiftCode";
    private static final String RECEIVER_ACCOUNT_NO = "receiverAccountNo";
    private static final String RECEIVER_FULL_NAME = "receiverFullName";
    
    private Sender _sender;
    private Receiver _receiver;
    private double _amount;
    private CurrencyExchange _currency;
    private double _exchangeAmount;
    private double _usdEquivalent;
    private double _fee;
    private double _cable;
    private double _postage;
    private double _other;
    private double _totalAmount;
    private ModePayment _modePayment;
    private Branch _branch;
    private String _transactionStatus;
    private String _charge;
    private String _purpose;
    private String _reason;
    private String _bankRef;
    private Date _dateTransaction;
    private String _reviewedBy;
    
    /**
     * Constructor
     */
    public SenderReceiverTransaction(){
        super();
    }
    
    /**
     * @return the sender
     */
    @OneToOne(cascade = CascadeType.ALL)
    @Index(columnNames = {"sender_id" }, name = "IX_SENDER_RECEIVER_TRANSACTION_SENDER_ID")
    public Sender getSender(){
        return _sender;
    }
    
    /**
     * @param sender
     * 			the sender to set
     */
    public void setSender(final Sender sender){
        _sender = sender;
    }
    
    /**
     * @return the receiver
     */
    @OneToOne(cascade = CascadeType.ALL)
    @Index(columnNames = {"receiver_id" }, name = "IX_SENDER_RECEIVER_TRANSACTION_RECEIVER_ID")
    public Receiver getReceiver(){
        return _receiver;
    }
    
    /**
     * @param receiver
     * 			the receiver to set
     */
    public void setReceiver(final Receiver receiver){
        _receiver = receiver;
    }
    
    /**
     * @return the amount
     */
    @Column
    public double getAmount(){
        return _amount;
    }
    
    /**
     * @param amount
     * 			the amount to set
     */
    public void setAmount(final double amount){
        _amount = amount;
    }
    
    /**
     * @return the currency
     */
    @OneToOne(cascade = CascadeType.ALL)
    @Index(columnNames = {"currency_id" }, name = "IX_SENDER_RECEIVER_TRANSACTION_CURRENCY_ID")
    public CurrencyExchange getCurrency(){
        return _currency;
    }
    
    /**
     * @param currency
     * 			the currency to set
     */
    public void setCurrency(final CurrencyExchange currency){
        _currency = currency;
    }
    
    /**
     * @return the exchangeAmount
     */
    @Column(name = "exchange_amount")
    public double getExchangeAmount(){
        return _exchangeAmount;
    }
    
    /**
     * @param exchangeAmount
     * 			the exchangeAmount to set
     */
    public void setExchangeAmount(final double exchangeAmount){
        _exchangeAmount = exchangeAmount;
    }
    
    /**
     * @return the usdEquivalent
     */
    @Column(name = "usd_equivalent")
    public double getUsdEquivalent(){
        return _usdEquivalent;
    }
    
    /**
     * @param usdEquivalent
     * 			the usdEquivalent to set
     */
    public void setUsdEquivalent(final double usdEquivalent){
        _usdEquivalent = usdEquivalent;
    }
    
    /**
     * @return the fee
     */
    @Column
    public double getFee(){
        return _fee;
    }
    
    /**
     * @param fee
     * 			the fee to set
     */
    public void setFee(final double fee){
        _fee = fee;
    }
    
    /**
     * @return the cable
     */
    @Column
    public double getCable(){
        return _cable;
    }
    
    /**
     * @param cable
     * 			the cable to set
     */
    public void setCable(final double cable){
        _cable = cable;
    }
    
    /**
     * @return the postage
     */
    @Column
    public double getPostage(){
        return _postage;
    }
    
    /**
     * @param postage
     * 			the postage to set
     */
    public void setPostage(final double postage){
        _postage = postage;
    }
    
    /**
     * @return the other
     */
    @Column
    public double getOther(){
        return _other;
    }
    
    /**
     * @param other
     * 			the other to set
     */
    public void setOther(final double other){
        _other = other;
    }
    
    /**
     * @return the totalAmount
     */
    @Column(name = "total_amount")
    public double getTotalAmount(){
        return _totalAmount;
    }
    
    /**
     * @param totalAmount
     * 			the totalAmount to set
     */
    public void setTotalAmount(final double totalAmount){
        _totalAmount = totalAmount;
    }
    
    /**
     * @return the modePayment
     */
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "mode_payment_id")
    @Index(columnNames = {"mode_payment_id" }, name = "IX_SENDER_RECEIVER_TRANSACTION_MONEY_PAYMENT_ID")
    public ModePayment getModePayment(){
        return _modePayment;
    }
    
    /**
     * @param modePayment
     * 			the modePayment to set
     */
    public void setModePayment(final ModePayment modePayment){
        _modePayment = modePayment;
    }
    
    /**
     *
     * @return
     */
    @OneToOne(cascade = CascadeType.REFRESH)
    @Index(columnNames = {"branch_id" }, name = "IX_SENDER_RECEIVER_TRANSACTION_BRANCH_ID")
    public Branch getBranch(){
        return _branch;
    }
    
    /**
     *
     * @param branch
     */
    public void setBranch(final Branch branch){
        _branch = branch;
    }
    
    /**
     * @return the transactionStatus
     */
    @Column(name = "status")
    public String getTransactionStatus(){
        return _transactionStatus;
    }
    
    /**
     * @param transactionStatus the transactionStatus to set
     */
    public void setTransactionStatus(final String transactionStatus){
        _transactionStatus = transactionStatus;
    }
    
    /**
     * @return the charge
     */
    @Column(name = "charge")
    public String getCharge(){
        return _charge;
    }
    
    /**
     * @param charge the charge to set
     */
    public void setCharge(final String charge){
        _charge = charge;
    }
    
    /**
     * @return the purpose
     */
    @Column(name = "purpose")
    public String getPurpose(){
        return _purpose;
    }
    
    /**
     * @param purpose the purpose to set
     */
    public void setPurpose(final String purpose){
        _purpose = purpose;
    }
    
    /**
     * @return the reason
     */
    @Column(name = "reason")
    public String getReason(){
        return _reason;
    }
    
    /**
     * @param reason the reason to set
     */
    public void setReason(final String reason){
        _reason = reason;
    }
    
    /**
     * @return the bankRef
     */
    @Column(name = "bank_reference")
    public String getBankRef(){
        return _bankRef;
    }
    
    /**
     * @param bankRef the bankRef to set
     */
    public void setBankRef(final String bankRef){
        _bankRef = bankRef;
    }
    
    /**
     * @return the dateTransaction
     */
    @Column(name = "date_transactoin")
    public Date getDateTransaction(){
        return _dateTransaction;
    }
    
    /**
     * @param dateTransaction the dateTransaction to set
     */
    public void setDateTransaction(final Date dateTransaction){
        _dateTransaction = dateTransaction;
    }
    
    /**
     * @return the reviewedBy
     */
    @Column(name = "reviewed_by", length = 50)
    public String getReviewedBy(){
        return _reviewedBy;
    }
    
    /**
     * @param reviewedBy
     * 			the reviewedBy to set
     */
    public void setReviewedBy(final String reviewedBy){
        _reviewedBy = reviewedBy;
    }
    
    /**
     * get all Remittance
     * @return
     */
    @SuppressWarnings("unchecked")
    public static List<SenderReceiverTransaction> getRemittanceList(){
        final String strQuery = "FROM SenderReceiverTransaction ORDER BY id";
        final Query query = JPA.em().createQuery(strQuery);
        return query.getResultList();
    }
    
    /**
     * @return {@link List<SenderReceiverTransaction>}
     */
    @SuppressWarnings("unchecked")
    public static List<SenderReceiverTransaction> getBlockingRemittanceTransaction(final Long branchId, final String reviewer){
        final String strQuery = "FROM SenderReceiverTransaction WHERE transactionStatus=:statusBlocking OR (transactionStatus=:statusReviewed AND reviewedBy=:reviewer) AND branch.id=:branchId";
        final Query query = JPA.em().createQuery(strQuery);
        query.setParameter("statusBlocking", TransactionStatus.TRANSACTION_BLOCKING.getCode());
        query.setParameter("statusReviewed", TransactionStatus.TRANSACTION_REVIEWED.getCode());
        query.setParameter("reviewer", reviewer);
        query.setParameter("branchId", branchId);
        return query.getResultList();
    }
    
    /**
     * @return {@link List<SenderReceiverTransaction>}
     */
    @SuppressWarnings("unchecked")
    public static List<SenderReceiverTransaction> getRejectedAndApprovedTransactions(final Long branchId, final String teller){
        final String strQuery = "FROM SenderReceiverTransaction WHERE (transactionStatus=:statusRejected OR transactionStatus=:statusApproved) AND createdBy=:teller AND branch.id=:branchId";
        final Query query = JPA.em().createQuery(strQuery);
        query.setParameter("statusRejected", TransactionStatus.TRANSACTION_REJECTED.getCode());
        query.setParameter("statusApproved", TransactionStatus.TRANSACTION_APPROVED.getCode());
        query.setParameter("teller", teller);
        query.setParameter("branchId", branchId);
        return query.getResultList();
    }
    
    @SuppressWarnings("unchecked")
    public static List<SenderReceiverTransaction> getRemittanceList(final RemittanceReportDataTableParams remittanceReportDataTableParams){
        String strQuery = buildQueryRemittanceByJQueryDataTableParam(remittanceReportDataTableParams);
        strQuery += buildOrderByJQueryDataTableParam(remittanceReportDataTableParams);
        final Query query = JPA.em().createQuery(strQuery);
        setParameterBuildWhereClauseByJQueryDataTableParam(query, remittanceReportDataTableParams);
        query.setFirstResult(Integer.parseInt(remittanceReportDataTableParams.getiDisplayStart()));
        query.setMaxResults(Integer.parseInt(remittanceReportDataTableParams.getiDisplayLength()));
        return query.getResultList();
    }
    
    private static String buildOrderByJQueryDataTableParam(final RemittanceReportDataTableParams remittanceReportDataTableParams){
        final StringBuilder orderBy = new StringBuilder();
        orderBy.append(" ORDER BY ").append(getMapColumnSort(remittanceReportDataTableParams)).append(" ").append(remittanceReportDataTableParams.getSSortDir_0());
        return orderBy.toString();
    }
    
    private static String buildQueryRemittanceByJQueryDataTableParam(final RemittanceReportDataTableParams remittanceReportDataTableParams){
        final StringBuilder strQuery = new StringBuilder();
        strQuery.append("SELECT srt FROM SenderReceiverTransaction srt ");
        strQuery.append(" INNER JOIN srt.sender s ");
        strQuery.append(" INNER JOIN srt.receiver r ");
        strQuery.append(" INNER JOIN srt.currency c ");
        strQuery.append(" WHERE srt.branch.id=:branchId AND srt.transactionStatus = '" + TransactionStatus.TRANSACTION_DONE.getCode() + "'");
        strQuery.append(buildWhereClauseByJQueryDataTableParam(remittanceReportDataTableParams));
        return strQuery.toString();
    }
    
    public static long countRemittanceListByJQueryDataTableParam(final RemittanceReportDataTableParams remittanceReportDataTableParams){
        final StringBuilder strQuery = new StringBuilder();
        strQuery.append("SELECT COUNT(srt.id) FROM SenderReceiverTransaction srt ");
        strQuery.append(" INNER JOIN srt.sender s ");
        strQuery.append(" INNER JOIN srt.receiver r ");
        strQuery.append(" INNER JOIN srt.currency c ");
        strQuery.append(" WHERE srt.branch.id=:branchId AND srt.transactionStatus = '" + TransactionStatus.TRANSACTION_DONE.getCode() + "'");
        strQuery.append(buildWhereClauseByJQueryDataTableParam(remittanceReportDataTableParams));
        
        final Query query = JPA.em().createQuery(strQuery.toString());
        setParameterBuildWhereClauseByJQueryDataTableParam(query, remittanceReportDataTableParams);
        return (Long) query.getSingleResult();
    }
    
    private static String getMapColumnSort(final RemittanceReportDataTableParams remittanceReportDataTableParams){
        final Map<String, String> columnsName = new HashMap<String, String>();
        columnsName.put(StringUtil.ZERO, "srt.id");
        columnsName.put("2", "s.fullName");
        columnsName.put("3", "r.fullName");
        columnsName.put("4", "srt.dateTransaction");
        columnsName.put("5", "r.swiftCode");
        columnsName.put("6", "srt.amount");
        columnsName.put("7", "c.name");
        columnsName.put("8", "srt.exchangeAmount");
        columnsName.put("9", "srt.usdEquivalent");
        columnsName.put("10", "srt.fee");
        columnsName.put("11", "srt.cable");
        return columnsName.get(remittanceReportDataTableParams.getiSortCol_0());
    }
    
    public static String buildWhereClauseByJQueryDataTableParam(final RemittanceReportDataTableParams jQueryDataTableParam){
        final boolean isStartDate = jQueryDataTableParam.getStartDate() != null;
        final boolean isEndDate = jQueryDataTableParam.getEndDate() != null;
        final boolean isSenderFullName = StringUtils.isNotBlank(jQueryDataTableParam.getSenderFullName());
        final boolean isSenderAccountNo = StringUtils.isNotBlank(jQueryDataTableParam.getSenderAccountNo());
        final boolean isSenderIdentityNo = StringUtils.isNotBlank(jQueryDataTableParam.getSenderIdentityNo());
        final boolean isIntermediaryBank = StringUtils.isNotBlank(jQueryDataTableParam.getIntermediaryBank());
        final boolean isSwiftCode = StringUtils.isNotBlank(jQueryDataTableParam.getSwiftCode());
        final boolean isReceiverAccountNo = StringUtils.isNotBlank(jQueryDataTableParam.getReceiverAccountNo());
        final boolean isReceiverFullName = StringUtils.isNotBlank(jQueryDataTableParam.getReceiverFullName());
        
        final StringBuilder whereClause = new StringBuilder();
        if(isStartDate){
            whereClause.append(" AND srt.dateTransaction >=:startDate");
        }
        if(isEndDate){
            whereClause.append(" AND srt.dateTransaction <=:endDate");
        }
        if(isSenderFullName){
            whereClause.append(" AND LOWER(s.fullName) LIKE :senderFullName");
        }
        if(isSenderAccountNo){
            whereClause.append(" AND LOWER(s.accountNo) LIKE :senderAccountNo");
        }
        if(isSenderIdentityNo){
            whereClause.append(" AND LOWER(s.identityNumber) LIKE :senderIdentityNo");
        }
        
        if(isIntermediaryBank){
            whereClause.append(" AND LOWER(r.intermediaryBank) LIKE :intermediaryBank");
        }
        if(isSwiftCode){
            whereClause.append(" AND LOWER(r.swiftCode) LIKE :swiftCode");
        }
        if(isReceiverAccountNo){
            whereClause.append(" AND LOWER(r.accountNo) LIKE :receiverAccountNo");
        }
        if(isReceiverFullName){
            whereClause.append(" AND LOWER(r.fullName) LIKE :receiverFullName");
        }
        return whereClause.toString();
    }
    
    public static void setParameterBuildWhereClauseByJQueryDataTableParam(final Query query, final RemittanceReportDataTableParams remittanceReportDataTableParams){
        final long brandId = (Long) Cache.get(remittanceReportDataTableParams.getUsername() + CABConstantKeys.BRANCH_SUFFIX);
        query.setParameter(SenderReceiverTransaction.BRANCH_ID, brandId);
        if(remittanceReportDataTableParams.getStartDate() != null){
            query.setParameter(SenderReceiverTransaction.START_DATE, DateUtils.getDateAtBeginningOfDay(remittanceReportDataTableParams.getStartDate()));
        }
        if(remittanceReportDataTableParams.getEndDate() != null){
            query.setParameter(SenderReceiverTransaction.END_DATE, DateUtils.getDateAtEndOfDay(remittanceReportDataTableParams.getEndDate()));
        }
        if(StringUtils.isNotBlank(remittanceReportDataTableParams.getSenderFullName())){
            query.setParameter(SENDER_FULL_NAME, CABConstantKeys.PERCENT + remittanceReportDataTableParams.getSenderFullName().toLowerCase() + CABConstantKeys.PERCENT);
        }
        if(StringUtils.isNotBlank(remittanceReportDataTableParams.getSenderAccountNo())){
            query.setParameter(SENDER_ACCOUNT_NO, CABConstantKeys.PERCENT + remittanceReportDataTableParams.getSenderAccountNo().toLowerCase() + CABConstantKeys.PERCENT);
        }
        if(StringUtils.isNotBlank(remittanceReportDataTableParams.getSenderIdentityNo())){
            query.setParameter(SENDER_IDENTITY_NUMBER, CABConstantKeys.PERCENT + remittanceReportDataTableParams.getSenderIdentityNo().toLowerCase() + CABConstantKeys.PERCENT);
        }
        if(StringUtils.isNotBlank(remittanceReportDataTableParams.getIntermediaryBank())){
            query.setParameter(INTERMEDIARY_BANK, CABConstantKeys.PERCENT + remittanceReportDataTableParams.getIntermediaryBank().toLowerCase() + CABConstantKeys.PERCENT);
        }
        if(StringUtils.isNotBlank(remittanceReportDataTableParams.getSwiftCode())){
            query.setParameter(SWIFT_CODE, CABConstantKeys.PERCENT + remittanceReportDataTableParams.getSwiftCode().toLowerCase() + CABConstantKeys.PERCENT);
        }
        if(StringUtils.isNotBlank(remittanceReportDataTableParams.getReceiverAccountNo())){
            query.setParameter(RECEIVER_ACCOUNT_NO, CABConstantKeys.PERCENT + remittanceReportDataTableParams.getReceiverAccountNo().toLowerCase() + CABConstantKeys.PERCENT);
        }
        if(StringUtils.isNotBlank(remittanceReportDataTableParams.getReceiverFullName())){
            query.setParameter(RECEIVER_FULL_NAME, CABConstantKeys.PERCENT + remittanceReportDataTableParams.getReceiverFullName().toLowerCase() + CABConstantKeys.PERCENT);
        }
    }
    
    /**
     *
     * @param senderId
     * @return
     */
    @SuppressWarnings("unchecked")
    public static List<Long> getRecieverIdBySenderId(final long senderId){
        final StringBuilder quBuilder = new StringBuilder();
        quBuilder.append(" Select distinct r.id ");
        quBuilder.append(" From SenderReceiverTransaction sr join sr.receiver r ");
        quBuilder.append(" join sr.sender s ");
        quBuilder.append(" Where s.id = :senderId AND s.blacklist = false AND r.block = false AND sr.transactionStatus IN (:transactionStatus)");
        final Query query = JPA.em().createQuery(quBuilder.toString());
        query.setParameter("senderId", senderId);
        final List<String> transactionList = new ArrayList<String>(Arrays.asList(CABConstantKeys.COUNTABLE_TRANSACTION_STATUS));
        query.setParameter("transactionStatus", transactionList);
        return query.getResultList();
    }
    
    @SuppressWarnings("unchecked")
    public static List<Receiver> getRecieverBySenderId(final long senderId){
        final StringBuilder quBuilder = new StringBuilder();
        quBuilder.append(" Select distinct r ");
        quBuilder.append(" From SenderReceiverTransaction sr join sr.receiver r ");
        quBuilder.append(" join sr.sender s ");
        quBuilder.append(" Where s.id = :senderId AND s.blacklist = false AND r.block = false AND sr.transactionStatus IN (:transactionStatus)");
        final Query query = JPA.em().createQuery(quBuilder.toString());
        query.setParameter("senderId", senderId);
        final List<String> transactionList = new ArrayList<String>(Arrays.asList(CABConstantKeys.COUNTABLE_TRANSACTION_STATUS));
        query.setParameter("transactionStatus", transactionList);
        return query.getResultList();
    }
    
    @SuppressWarnings("unchecked")
    public static List<Long> getSenderIdByRecieverId(final long recieverId){
        final StringBuilder quBuilder = new StringBuilder();
        quBuilder.append(" Select distinct s.id ");
        quBuilder.append(" From SenderReceiverTransaction sr join sr.receiver r ");
        quBuilder.append(" join sr.sender s ");
        quBuilder.append(" Where r.id =:recieverId AND s.blacklist = false AND s.block = false AND sr.transactionStatus IN (:transactionStatus)");
        final Query query = JPA.em().createQuery(quBuilder.toString());
        query.setParameter("recieverId", recieverId);
        final List<String> transactionList = new ArrayList<String>(Arrays.asList(CABConstantKeys.COUNTABLE_TRANSACTION_STATUS));
        query.setParameter("transactionStatus", transactionList);
        return query.getResultList();
    }
    
    @SuppressWarnings("unchecked")
    public static List<Sender> getSenderByRecieverId(final long recieverId){
        final StringBuilder quBuilder = new StringBuilder();
        quBuilder.append(" Select distinct s ");
        quBuilder.append(" From SenderReceiverTransaction sr join sr.receiver r ");
        quBuilder.append(" join sr.sender s ");
        quBuilder.append(" Where r.id =:recieverId AND s.blacklist = false AND s.block = false AND sr.transactionStatus IN (:transactionStatus)");
        final Query query = JPA.em().createQuery(quBuilder.toString());
        query.setParameter("recieverId", recieverId);
        final List<String> transactionList = new ArrayList<String>(Arrays.asList(CABConstantKeys.COUNTABLE_TRANSACTION_STATUS));
        query.setParameter("transactionStatus", transactionList);
        return query.getResultList();
    }
    
    public static SenderReceiverTransaction saveUpdateByJsonNodeAndSatus(SenderReceiverTransaction senderReceiverTransaction, final String status){
        senderReceiverTransaction.setTransactionStatus(status);
        senderReceiverTransaction = (SenderReceiverTransaction) saveOrUpdate(senderReceiverTransaction);
        return senderReceiverTransaction;
    }
    
}
