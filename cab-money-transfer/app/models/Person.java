/*
 * Created on Oct 8, 2014
 */

package models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.Type;

import models.core.AbstractAuditableEntity;

/**
 * @author Vichrak
 */
@MappedSuperclass
public class Person extends AbstractAuditableEntity{
    
    private static final long serialVersionUID = 1L;
    
    private String _fullName;
    private Date _dateOfBirth;
    private String _identityNumber;
    private String _phone;
    private String _email;
    private String _address;
    
    /**
     * Constructor
     */
    public Person(){
        super();
    }
    
    /**
     * @return the fullName
     */
    @Column(name = "full_name", length = 50)
    public String getFullName(){
        return _fullName;
    }
    
    /**
     * @param fullName 
     * 			the fullName to set
     */
    public void setFullName(final String fullName){
        _fullName = fullName;
    }
    
    /**
     * @return the dateOfBirth
     */
    @Column(name = "date_of_birth")
    @Type(type = "date")
    public Date getDateOfBirth(){
        return _dateOfBirth;
    }
    
    /**
     * @param dateOfBirth 
     *              the dateOfBirth to set
     */
    public void setDateOfBirth(final Date dateOfBirth){
        _dateOfBirth = dateOfBirth;
    }
    
    /**
     * @return the identityNumber
     */
    @Column(name = "identity_number", length = 50)
    public String getIdentityNumber(){
        return _identityNumber;
    }
    
    /**
     * @param identityNumber 
     *              the identityNumber to set
     */
    public void setIdentityNumber(final String identityNumber){
        _identityNumber = identityNumber;
    }
    
    /**
     * @return the phone
     */
    @Column(length = 50)
    public String getPhone(){
        return _phone;
    }
    
    /**
     * @param phone 
     *          the phone to set
     */
    public void setPhone(final String phone){
        _phone = phone;
    }
    
    /**
     * @return the email
     */
    @Column(length = 50)
    public String getEmail(){
        return _email;
    }
    
    /**
     * @param email 
     *          the email to set
     */
    public void setEmail(final String email){
        _email = email;
    }
    
    /**
     * @return the address
     */
    @Column(length = 255)
    public String getAddress(){
        return _address;
    }
    
    /**
     * @param address 
     *          the address to set
     */
    public void setAddress(final String address){
        _address = address;
    }
    
}
