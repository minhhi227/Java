/*
 * Created on Oct 23, 2014
 */
package models.dto;

import java.io.Serializable;

/**
 * 
 * @author Chamnan
 *
 */
public class ReceiverDto implements Serializable {
    
	/**
	 * 
	 */
	private static final long serialVersionUID = 8701837670735735566L;
	
	// r.fullName, r.intermediaryBank, r.swiftCode, r.accountNo, r.bankAddress, r.address, concat(r.fullName, ' - ' , r.accountNo) as fullNameAccountNo
	private long _id;
	private String _fullName;
	private String _intermediaryBank;
	private String _swiftCode;
	private String _accountNo;
	private String _bankAddress;
	private String _address;
	private String _fullNameAccountNo;
	
	public ReceiverDto(long id, String fullName, String intermediaryBank, String swiftCode, String accountNo, String bankAddress, String address, String fullNameAccountNo) {
		super();
		this._id = id;
		this._fullName = fullName;
		this._intermediaryBank = intermediaryBank;
		this._swiftCode = swiftCode;
		this._accountNo = accountNo;
		this._bankAddress = bankAddress;
		this._address = address;
		this._fullNameAccountNo = fullNameAccountNo;
	}
	
	public long getId() {
		return _id;
	}
	public void setId(long id) {
		this._id = id;
	}
	public String getFullName() {
		return _fullName;
	}
	public void setFullName(String fullName) {
		this._fullName = fullName;
	}
	public String getIntermediaryBank() {
		return _intermediaryBank;
	}
	public void setIntermediaryBank(String intermediaryBank) {
		this._intermediaryBank = intermediaryBank;
	}
	public String getSwiftCode() {
		return _swiftCode;
	}
	public void setSwiftCode(String swiftCode) {
		this._swiftCode = swiftCode;
	}
	public String getAccountNo() {
		return _accountNo;
	}
	public void setAccountNo(String accountNo) {
		this._accountNo = accountNo;
	}
	public String getBankAddress() {
		return _bankAddress;
	}
	public void setBankAddress(String bankAddress) {
		this._bankAddress = bankAddress;
	}
	public String getAddress() {
		return _address;
	}
	public void setAddress(String address) {
		this._address = address;
	}
	public String getFullNameAccountNo() {
		return _fullNameAccountNo;
	}
	public void setFullNameAccountNo(String fullNameAccountNo) {
		this._fullNameAccountNo = fullNameAccountNo;
	}
    
}
