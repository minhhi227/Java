/*
 * Created on Oct 8, 2014
 */
package models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Query;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import models.core.AbstractAuditableEntity;
import play.db.jpa.JPA;

/**
 * @author Vichrak
 */
@Entity
@Table(name = "BRANCH")
@SequenceGenerator(allocationSize = 1, name = "id_sequence", sequenceName = "branch_id_sequence")
public class Branch extends AbstractAuditableEntity{
    
    private static final long serialVersionUID = 1L;
    private String _name;
    private String _phone;
    private String _address;
    private String _bankReference;
    private String _initBankCode;
    
    /**
     * Constructor
     */
    public Branch(){
        super();
    }
    
    public Branch(final String name, final String phone, final String address, final String bankReference){
        super();
        _name = name;
        _phone = phone;
        _address = address;
        _bankReference = bankReference;
    }
    
    /**
     * @return the name
     */
    @Column(nullable = false, length = 100)
    public String getName(){
        return _name;
    }
    
    /**
     * @param name
     * 			the name to set
     */
    public void setName(final String name){
        _name = name;
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
     * 			the phone to set
     */
    public void setPhone(final String phone){
        _phone = phone;
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
     * 			the address to set
     */
    public void setAddress(final String address){
        _address = address;
    }
    
    /**
     * @return the bankReference
     */
    @Column(name = "bank_ref", length = 50, nullable = false)
    public String getBankReference(){
        return _bankReference;
    }
    
    /**
     * @param bankReference
     *          the bankReference to set
     */
    public void setBankReference(final String bankReference){
        _bankReference = bankReference;
    }
    
    /**
     * @return the initBankCode
     */
    @Column(name = "init_bank_code", length = 50)
    public String getInitBankCode() {
        return _initBankCode;
    }

    
    /**
     * @param initBankCode the initBankCode to set
     */
    public void setInitBankCode(final String initBankCode) {
        _initBankCode = initBankCode;
    }
    
    /**
     * @return {@link List<Branch>}
     */
    @SuppressWarnings("unchecked")
    public static List<Branch> findAll(){
        final Query query = JPA.em().createQuery("FROM Branch");
        return query.getResultList();
    }
    
    /**
     * @return {@link List<Branch>}
     */
    @SuppressWarnings("unchecked")
    public static Branch findByName(final String name){
        if(name == null){
            return null;
        }
        final Query query = JPA.em().createQuery("FROM Branch WHERE name=:name");
        query.setParameter("name", name);
        final List<Branch> branches = query.getResultList();
        if(branches.size() == 0){
            return null;
        }
        return branches.iterator().next();
    }
    
    /**
     * @return {@link Branch}
     */
    @SuppressWarnings("unchecked")
    public static Branch getLast(){
        final Query query = JPA.em().createQuery("FROM Branch ORDER BY id DESC");
        query.setMaxResults(1);
        final List<Branch> branches = query.getResultList();
        if(branches.size() == 0){
            return null;
        }
        return branches.iterator().next();
    }
    
    public static String genereateBankReference(){
        //                Branch lastBranch = Branch.getLast();
        //                if(lastBranch == null){
        //                    String shortCurrentYear = DateUtils.getShortCurrentYear();
        //                    branch.setBankReference(branchName + shortCurrentYear + HYPHEN + START_CODE);
        //                }
        //                else{
        //                    // set next bank ref.
        //                    String lastBankRef = lastBranch.getBankReference();
        //                    String[] ref = lastBankRef.split(HYPHEN);
        //                    String leftPart = ref[0];
        //                    String shortYear = leftPart.substring(Math.max(leftPart.length() - 2, 0));
        //                    int lastCode = Integer.parseInt(ref[1]);
        //                    if(shortYear.equals(DateUtils.getShortCurrentYear())){
        //                        branch.setBankReference(branchName + shortYear + HYPHEN + StringUtils.leftPad((lastCode + 1) + "", 5, '0'));
        //                    }
        //                    else{
        //                        // reset code to 00100
        //                        branch.setBankReference(branchName + DateUtils.getShortCurrentYear() + HYPHEN + START_CODE);
        //                    }
        //                }
        return null;
    }
    
}
