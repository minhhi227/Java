/*
 * Created on Nov 18, 2014
 */
package models.dto.datatable;

import java.util.Date;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import utils.DateUtils;

/**
 * @author Vichrak
 * 
 */
public class RemittanceReportDataTableParams extends AbstractDataTableParams{
    
    private static final String START_DATE = "searchFromDate";
    private static final String END_DATE = "searchToDate";
    private static final String SENDER_FULL_NAME = "advSenderFullName";
    private static final String SENDER_ACCOUNT_NO = "advSenderAccountNo";
    private static final String SENDER_IDENTITY_NO = "advSenderIdentityNo";
    private static final String INTERMEDIARY_BANK = "advIntermediaryBank";
    private static final String SWIFT_CODE = "advSwiftCode";
    private static final String RECEIVER_ACCOUNT_NO = "advReceiverAccountNo";
    private static final String RECEIVER_FULL_NAME = "advReceiverFullName";
    private static final String SHOW_SENDER_ADDRESS = "showSenderAddress";
    private static final String SHOW_SENDER_DOB = "showSenderDOB";
    private static final String SHOW_SENDER_IDENTITY_NO = "showSenderIdentityNo";
    private static final String SHOW_SENDER_EXPIRED_DATE = "showSenderExpiredDate";
    
    private Date _startDate;
    private Date _endDate;
    private String _senderFullName;
    private String _senderAccountNo;
    private String _senderIdentityNo;
    private String _intermediaryBank;
    private String _swiftCode;
    private String _receiverAccountNo;
    private String _receiverFullName;
    private boolean _showSenderAddress;
    private boolean _showSenderDOB;
    private boolean _showSenderIdentityNo;
    private boolean _showSenderExpiredDate;
    
    public RemittanceReportDataTableParams(Map<String, String[]> params){
        super(params);
        if(params.get(START_DATE) != null && StringUtils.isNotBlank(params.get(START_DATE)[0])){
            _startDate = DateUtils.getDate(params.get(START_DATE)[0]);
        }
        if(params.get(END_DATE) != null && StringUtils.isNotBlank(params.get(END_DATE)[0])){
            _endDate = DateUtils.getDate(params.get(END_DATE)[0]);
        }
        if(params.get(SENDER_FULL_NAME) != null && StringUtils.isNotBlank(params.get(SENDER_FULL_NAME)[0])){
            _senderFullName = params.get(SENDER_FULL_NAME)[0];
        }
        if(params.get(SENDER_ACCOUNT_NO) != null && StringUtils.isNotBlank(params.get(SENDER_ACCOUNT_NO)[0])){
            _senderAccountNo = params.get(SENDER_ACCOUNT_NO)[0];
        }
        if(params.get(SENDER_IDENTITY_NO) != null && StringUtils.isNotBlank(params.get(SENDER_IDENTITY_NO)[0])){
            _senderIdentityNo = params.get(SENDER_IDENTITY_NO)[0];
        }
        if(params.get(INTERMEDIARY_BANK) != null && StringUtils.isNotBlank(params.get(INTERMEDIARY_BANK)[0])){
            _intermediaryBank = params.get(INTERMEDIARY_BANK)[0];
        }
        if(params.get(SWIFT_CODE) != null && StringUtils.isNotBlank(params.get(SWIFT_CODE)[0])){
            _swiftCode = params.get(SWIFT_CODE)[0];
        }
        if(params.get(RECEIVER_ACCOUNT_NO) != null && StringUtils.isNotBlank(params.get(RECEIVER_ACCOUNT_NO)[0])){
            _receiverAccountNo = params.get(RECEIVER_ACCOUNT_NO)[0];
        }
        if(params.get(RECEIVER_FULL_NAME) != null && StringUtils.isNotBlank(params.get(RECEIVER_FULL_NAME)[0])){
            _receiverFullName = params.get(RECEIVER_FULL_NAME)[0];
        }
        
        if(params.get(SHOW_SENDER_ADDRESS) != null && StringUtils.isNotBlank(params.get(SHOW_SENDER_ADDRESS)[0])){
            _showSenderAddress = true;
        }
        if(params.get(SHOW_SENDER_DOB) != null && StringUtils.isNotBlank(params.get(SHOW_SENDER_DOB)[0])){
            _showSenderDOB = true;
        }
        if(params.get(SHOW_SENDER_IDENTITY_NO) != null && StringUtils.isNotBlank(params.get(SHOW_SENDER_IDENTITY_NO)[0])){
            _showSenderIdentityNo = true;
        }
        if(params.get(SHOW_SENDER_EXPIRED_DATE) != null && StringUtils.isNotBlank(params.get(SHOW_SENDER_EXPIRED_DATE)[0])){
            _showSenderExpiredDate = true;
        }
    }
    
    /**
     * @return the startDate
     */
    public Date getStartDate(){
        return _startDate;
    }
    
    /**
     * @param startDate 
     * 			the startDate to set
     */
    public void setStartDate(final Date startDate){
        _startDate = startDate;
    }
    
    /**
     * @return the endDate
     */
    public Date getEndDate(){
        return _endDate;
    }
    
    /**
     * @param endDate 
     * 			the endDate to set
     */
    public void setEndDate(final Date endDate){
        _endDate = endDate;
    }
    
    /**
     * @return the senderFullName
     */
    public String getSenderFullName(){
        return _senderFullName;
    }
    
    /**
     * @param senderFullName 
     * 			the senderFullName to set
     */
    public void setSenderFullName(final String senderFullName){
        _senderFullName = senderFullName;
    }
    
    /**
     * @return the senderAccountNo
     */
    public String getSenderAccountNo(){
        return _senderAccountNo;
    }
    
    /**
     * @param senderAccountNo 
     * 			the senderAccountNo to set
     */
    public void setSenderAccountNo(final String senderAccountNo){
        _senderAccountNo = senderAccountNo;
    }
    
    /**
     * @return the senderIdentityNo
     */
    public String getSenderIdentityNo(){
        return _senderIdentityNo;
    }
    
    /**
     * @param senderIdentityNo 
     * 			the senderIdentityNo to set
     */
    public void setSenderIdentityNo(final String senderIdentityNo){
        _senderIdentityNo = senderIdentityNo;
    }
    
    /**
     * @return the intermediaryBank
     */
    public String getIntermediaryBank(){
        return _intermediaryBank;
    }
    
    /**
     * @param intermediaryBank 
     * 			the intermediaryBank to set
     */
    public void setIntermediaryBank(final String intermediaryBank){
        _intermediaryBank = intermediaryBank;
    }
    
    /**
     * @return the swiftCode
     */
    public String getSwiftCode(){
        return _swiftCode;
    }
    
    /**
     * @param swiftCode 
     * 			the swiftCode to set
     */
    public void setSwiftCode(final String swiftCode){
        _swiftCode = swiftCode;
    }
    
    /**
     * @return the receiverAccountNo
     */
    public String getReceiverAccountNo(){
        return _receiverAccountNo;
    }
    
    /**
     * @param receiverAccountNo 
     * 			the receiverAccountNo to set
     */
    public void setReceiverAccountNo(final String receiverAccountNo){
        _receiverAccountNo = receiverAccountNo;
    }
    
    /**
     * @return the receiverFullName
     */
    public String getReceiverFullName(){
        return _receiverFullName;
    }
    
    /**
     * @param receiverFullName 
     * 			the receiverFullName to set
     */
    public void setReceiverFullName(final String receiverFullName){
        _receiverFullName = receiverFullName;
    }
    
    /**
     * @return the showSenderAddress
     */
    public boolean isShowSenderAddress(){
        return _showSenderAddress;
    }
    
    /**
     * @param showSenderAddress 
     * 			the showSenderAddress to set
     */
    public void setShowSenderAddress(final boolean showSenderAddress){
        _showSenderAddress = showSenderAddress;
    }
    
    /**
     * @return the showSenderDOB
     */
    public boolean isShowSenderDOB(){
        return _showSenderDOB;
    }
    
    /**
     * @param showSenderDOB 
     * 			the showSenderDOB to set
     */
    public void setShowSenderDOB(final boolean showSenderDOB){
        _showSenderDOB = showSenderDOB;
    }
    
    /**
     * @return the showSenderIdentityNo
     */
    public boolean isShowSenderIdentityNo(){
        return _showSenderIdentityNo;
    }
    
    /**
     * @param showSenderIdentityNo 
     * 			the showSenderIdentityNo to set
     */
    public void setShowSenderIdentityNo(final boolean showSenderIdentityNo){
        _showSenderIdentityNo = showSenderIdentityNo;
    }
    
    /**
     * @return the showSenderExpiredDate
     */
    public boolean isShowSenderExpiredDate(){
        return _showSenderExpiredDate;
    }
    
    /**
     * @param showSenderExpiredDate 
     * 			the showSenderExpiredDate to set
     */
    public void setShowSenderExpiredDate(final boolean showSenderExpiredDate){
        _showSenderExpiredDate = showSenderExpiredDate;
    }
}
