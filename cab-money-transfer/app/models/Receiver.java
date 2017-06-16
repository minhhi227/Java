/*
 * Created on Oct 9, 2014
 */
package models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Query;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import models.core.AbstractAuditableEntity;
import models.dto.ReceiverDto;
import play.db.jpa.JPA;

/**
 * @author Vichrak
 *
 */
@Entity
@Table(name = "RECEIVER")
@SequenceGenerator(allocationSize = 1, name = "id_sequence", sequenceName = "receiver_id_sequence")
public class Receiver extends AbstractAuditableEntity {

    private static final long serialVersionUID = 1L;

    private String _fullName;
    private String _intermediaryBank;
    private String _swiftCode;
    private String _accountNo;
    private String _bankAddress;
    private String _address;
    private boolean _blacklist;
    private boolean _block;
    private int _nbSenderRestriction = 2;

    /**
     * Constructor
     */
    public Receiver() {
        super();
    }

    public Receiver(final String _fullName, final String _intermediaryBank, final String _swiftCode, final String _accountNo, final String _bankAddress, final String _purposeTransfer, final String _address, final boolean _blacklist, final boolean _block) {
        super();
        this._fullName = _fullName;
        this._intermediaryBank = _intermediaryBank;
        this._swiftCode = _swiftCode;
        this._accountNo = _accountNo;
        this._bankAddress = _bankAddress;
        this._address = _address;
        this._blacklist = _blacklist;
        this._block = _block;
    }

    /**
     * @return the fullName
     */
    @Column(name = "full_name", nullable = false, length = 50)
    public String getFullName() {
        return _fullName;
    }

    /**
     * @param fullName
     * 			the fullName to set
     */
    public void setFullName(final String fullName) {
        _fullName = fullName;
    }

    /**
     * @return the intermediaryBank
     */
    @Column(name = "intermediary_bank", length = 50)
    public String getIntermediaryBank() {
        return _intermediaryBank;
    }

    /**
     * @param intermediaryBank
     * 			the intermediaryBank to set
     */
    public void setIntermediaryBank(final String intermediaryBank) {
        _intermediaryBank = intermediaryBank;
    }

    /**
     * @return the swiftCode
     */
    @Column(name = "swift_code", length = 50)
    public String getSwiftCode() {
        return _swiftCode;
    }

    /**
     * @param swiftCode
     * 			the swiftCode to set
     */
    public void setSwiftCode(final String swiftCode) {
        _swiftCode = swiftCode;
    }

    /**
     * @return the accountNo
     */
    @Column(name = "account_no", length = 50)
    public String getAccountNo() {
        return _accountNo;
    }

    /**
     * @param accountNo
     * 			the accountNo to set
     */
    public void setAccountNo(final String accountNo) {
        _accountNo = accountNo;
    }

    /**
     * @return the bankAddress
     */
    @Column(name = "bank_address", length = 255)
    public String getBankAddress() {
        return _bankAddress;
    }

    /**
     * @param bankAddress
     * 			the bankAddress to set
     */
    public void setBankAddress(final String bankAddress) {
        _bankAddress = bankAddress;
    }

    /**
     * @return the address
     */
    @Column(length = 255)
    public String getAddress() {
        return _address;
    }

    /**
     * @param address
     *          the address to set
     */
    public void setAddress(final String address) {
        _address = address;
    }

    /**
     * @return the blacklist
     */
    @Column(nullable = false)
    public boolean isBlacklist() {
        return _blacklist;
    }

    /**
     * @param blacklist
     *          the blacklist to set
     */
    public void setBlacklist(final boolean blacklist) {
        _blacklist = blacklist;
    }

    /**
     * @return the block
     */
    @Column(nullable = false)
    public boolean isBlock() {
        return _block;
    }

    /**
     * @param block
     *          the block to set
     */
    public void setBlock(final boolean block) {
        _block = block;
    }

    /**
     * @return the nbSenderRestriction
     */
    @Column(name="number_sender_restriction", nullable = false, columnDefinition="integer NOT NULL DEFAULT 2")
    public int getNbSenderRestriction() {
        return _nbSenderRestriction;
    }


    /**
     * @param nbSenderRestriction the nbSenderRestriction to set
     */
    public void setNbSenderRestriction(final int nbSenderRestriction) {
        _nbSenderRestriction = nbSenderRestriction;
    }
    
    /**
     * @return {@link List<Receiver>}
     */
    @SuppressWarnings("unchecked")
    public static List<Receiver> findAll() {
        final Query query = JPA.em().createQuery("FROM Receiver");
        return query.getResultList();
    }

    /**
     *
     * @param fullName
     * @return
     */
    @SuppressWarnings("unchecked")
    public static List<ReceiverDto> filterByFullNameOrAccountNo(final String fullName) {
        final StringBuilder strBuilder = new StringBuilder();
        strBuilder.append("Select new models.dto.ReceiverDto(r.id, r.fullName, r.intermediaryBank, r.swiftCode, r.accountNo, r.bankAddress, r.address, concat(r.fullName, ' - ' , r.accountNo) as fullNameAccountNo) ");
        strBuilder.append(" FROM Receiver r ");
        strBuilder.append(" WHERE ");
        strBuilder.append(" lower(r.fullName) like lower('%" + fullName + "%')");
        strBuilder.append(" OR lower(r.accountNo) like lower('%" + fullName + "%')");
        final Query query = JPA.em().createQuery(strBuilder.toString());
        return query.getResultList();
    }

    /**
     *
     * @param accountNo
     * @param IdentityCard
     * @return
     */
    public static Receiver getByAccountNoAndFullName(final String accountNo, final String IdentityCard) {
        final StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append("From Receiver WHERE lower(accountNo) = lower(:accountNo) AND lower(fullName) = lower(:fullName) ");
        final Query query = JPA.em().createQuery(queryBuilder.toString());
        query.setParameter("accountNo", accountNo);
        query.setParameter("fullName", IdentityCard);
        return (query.getResultList().size() > 0) ? (Receiver) query.getSingleResult() : null;
    }

   /**
    * 
    * @param accountNo
    * @return
    */
   @SuppressWarnings("unchecked")
   public static Receiver getByAccountNo(final String accountNo) {
       final StringBuilder queryBuilder = new StringBuilder();
       queryBuilder.append("From Receiver WHERE lower(accountNo) = lower(:accountNo) ");
       final Query query = JPA.em().createQuery(queryBuilder.toString());
       query.setParameter("accountNo", accountNo);
       List<Receiver> listReceivers = query.getResultList();
       if(listReceivers.size() > 0) {
           return listReceivers.iterator().next();
       }
       return null;
   }

}
