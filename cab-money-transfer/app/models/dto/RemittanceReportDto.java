/*
 * Created on Oct 23, 2014
 */
package models.dto;

import java.io.Serializable;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;

/**
 * @author Vichrak
 * 
 */
public class RemittanceReportDto implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    private Date _madeDate;
    private String _formattedMadeDate;
    private String _bankRef;
    private String _senderFullName;
    private String _companyName;
    private String _CBRef;
    
    private String _senderAddress;
    private Date _senderDateOfBirth;
    private String _formattedSenderDateOfBirth;
    private String _senderIdentityNo;
    private Date _senderExpiredDate;
    private String _formattedSenderExpiredDate;
    
    private double _amountOutward;
    private String _currencyName;
    private double _exchangeRate;
    
    private double _fee;
    private double _cable;
    private double _other;
    
    private String _receiverAccountNo;
    private String _receiverFullName;
    private String _purpose;
    
    public RemittanceReportDto(){
        super();
    }
    
    public RemittanceReportDto(final Date madeDate, final String bankRef, final String senderFullName, final String companyName, final String CBRef, final String senderAddress, final Date senderDateOfBirth, final String senderIdentityNo, final Date senderExpiredDate, final double amountOutward, final String currencyName, final double exchangeRate, final double fee, final double cable, final double other, final String receiverAccountNo, final String receiverFullName, final String purpose){
        super();
        _madeDate = madeDate;
        _bankRef = bankRef;
        _senderFullName = StringUtils.isNotBlank(senderFullName) ? senderFullName : companyName;
        _companyName = companyName;
        _CBRef = CBRef;
        _senderAddress = senderAddress;
        _senderDateOfBirth = senderDateOfBirth;
        _senderIdentityNo = senderIdentityNo;
        _senderExpiredDate = senderExpiredDate;
        _amountOutward = amountOutward;
        _currencyName = currencyName;
        _exchangeRate = exchangeRate;
        _fee = fee;
        _cable = cable;
        _other = other;
        _receiverAccountNo = receiverAccountNo;
        _receiverFullName = receiverFullName;
        _purpose = purpose;
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
     * @return the companyName
     */
    public String getCompanyName(){
        return _companyName;
    }
    
    /**
     * @param companyName 
     * 			the companyName to set
     */
    public void setCompanyName(final String companyName){
        _companyName = companyName;
    }
    
    /**
     * @return the senderDateOfBirth
     */
    public Date getSenderDateOfBirth(){
        return _senderDateOfBirth;
    }
    
    /**
     * @param senderDateOfBirth 
     * 			the senderDateOfBirth to set
     */
    public void setSenderDateOfBirth(final Date senderDateOfBirth){
        _senderDateOfBirth = senderDateOfBirth;
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
     * @return the senderExpiredDate
     */
    public Date getSenderExpiredDate(){
        return _senderExpiredDate;
    }
    
    /**
     * @param senderExpiredDate 
     * 			the senderExpiredDate to set
     */
    public void setSenderExpiredDate(final Date senderExpiredDate){
        _senderExpiredDate = senderExpiredDate;
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
     * @return the currencyName
     */
    public String getCurrencyName(){
        return _currencyName;
    }
    
    /**
     * @param currencyName 
     * 			the currencyName to set
     */
    public void setCurrencyName(final String currencyName){
        _currencyName = currencyName;
    }
    
    /**
     * @return the exchangeRate
     */
    public double getExchangeRate(){
        return _exchangeRate;
    }
    
    /**
     * @param exchangeRate 
     * 			the exchangeRate to set
     */
    public void setExchangeRate(final double exchangeRate){
        _exchangeRate = exchangeRate;
    }
    
    /**
     * @return the fee
     */
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
     * @return the madeDate
     */
    public Date getMadeDate(){
        return _madeDate;
    }
    
    /**
     * @param madeDate 
     * 			the madeDate to set
     */
    public void setMadeDate(final Date madeDate){
        _madeDate = madeDate;
    }
    
    /**
     * @return the formattedSenderDateOfBirth
     */
    public String getFormattedSenderDateOfBirth(){
        return _formattedSenderDateOfBirth;
    }
    
    /**
     * @param formattedSenderDateOfBirth 
     * 			the formattedSenderDateOfBirth to set
     */
    public void setFormattedSenderDateOfBirth(final String formattedSenderDateOfBirth){
        _formattedSenderDateOfBirth = formattedSenderDateOfBirth;
    }
    
    /**
     * @return the formattedSenderExpiredDate
     */
    public String getFormattedSenderExpiredDate(){
        return _formattedSenderExpiredDate;
    }
    
    /**
     * @param formattedSenderExpiredDate 
     * 			the formattedSenderExpiredDate to set
     */
    public void setFormattedSenderExpiredDate(final String formattedSenderExpiredDate){
        _formattedSenderExpiredDate = formattedSenderExpiredDate;
    }
    
    /**
     * @return the formattedMadeDate
     */
    public String getFormattedMadeDate(){
        return _formattedMadeDate;
    }
    
    /**
     * @param formattedMadeDate 
     * 			the formattedMadeDate to set
     */
    public void setFormattedMadeDate(final String formattedMadeDate){
        _formattedMadeDate = formattedMadeDate;
    }
    
    /**
     * @return the bankRef
     */
    public String getBankRef(){
        return _bankRef;
    }
    
    /**
     * @param bankRef 
     * 			the bankRef to set
     */
    public void setBankRef(final String bankRef){
        _bankRef = bankRef;
    }
    
    /**
     * @return the cBRef
     */
    public String getCBRef(){
        return _CBRef;
    }
    
    /**
     * @param cBRef 
     * 			the cBRef to set
     */
    public void setCBRef(final String cBRef){
        _CBRef = cBRef;
    }
    
    /**
     * @return the senderAddress
     */
    public String getSenderAddress(){
        return _senderAddress;
    }
    
    /**
     * @param senderAddress 
     * 			the senderAddress to set
     */
    public void setSenderAddress(final String senderAddress){
        _senderAddress = senderAddress;
    }
    
    /**
     * @return the amountOutward
     */
    public double getAmountOutward(){
        return _amountOutward;
    }
    
    /**
     * @param amountOutward 
     * 			the amountOutward to set
     */
    public void setAmountOutward(final double amountOutward){
        _amountOutward = amountOutward;
    }
    
    /**
     * @return the other
     */
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
     * @return the purpose
     */
    public String getPurpose(){
        return _purpose;
    }
    
    /**
     * @param purpose 
     * 			the purpose to set
     */
    public void setPurpose(final String purpose){
        _purpose = purpose;
    }
    
}
