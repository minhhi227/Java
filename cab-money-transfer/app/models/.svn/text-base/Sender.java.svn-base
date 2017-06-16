/*
 * Created on Oct 8, 2014
 */
package models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Query;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import models.dto.SenderDto;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.annotations.Type;

import play.db.jpa.JPA;

/**
 * @author Vichrak
 *
 */
@Entity
@Table(name = "SENDER")
@SequenceGenerator(allocationSize = 1, name = "id_sequence", sequenceName = "sender_id_sequence")
public class Sender extends Person {

    private static final long serialVersionUID = 1L;

    private String _accountNo;
    private String _companyName;
    private Date _expiredDate;
    private String _type;
    private boolean _blacklist;
    private boolean _block;
    private String _reason;
    private int _nbRecieverRestriction = 2;
    
    /**
     * Constructor
     */
    public Sender() {
        super();
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
     * @return the companyName
     */
    @Column(name = "company_name", length = 100)
    public String getCompanyName() {
        return _companyName;
    }

    /**
     * @param companyName
     * 			the companyName to set
     */
    public void setCompanyName(final String companyName) {
        _companyName = companyName;
    }

    /**
     * @return the expiredDate
     */
    @Column(name = "expired_date")
    @Type(type = "date")
    public Date getExpiredDate() {
        return _expiredDate;
    }

    /**
     * @param expiredDate
     * 			the expiredDate to set
     */
    public void setExpiredDate(final Date expiredDate) {
        _expiredDate = expiredDate;
    }

    /**
     * @return the type
     */
    @Column(length = 50, nullable = false)
    public String getType() {
        return _type;
    }

    /**
     * @param type
     * 			the type to set
     */
    public void setType(final String type) {
        _type = type;
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
     * 			the blacklist to set
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
     * 			the block to set
     */
    public void setBlock(final boolean block) {
        _block = block;
    }

    /**
     * @return the reason
     */
    public String getReason() {
        return _reason;
    }

    /**
     * @param reason
     *          the reason to set
     */
    public void setReason(final String reason) {
        _reason = reason;
    }
    
    /**
     * @return the nbRecieverRestriction
     */
    @Column(name = "number_reciever_restriction", nullable=false, columnDefinition="integer NOT NULL DEFAULT 2")
    public int getNbRecieverRestriction() {
        return _nbRecieverRestriction;
    }

    
    /**
     * @param nbRecieverRestriction the nbRecieverRestriction to set
     */
    public void setNbRecieverRestriction(final int nbRecieverRestriction) {
        _nbRecieverRestriction = nbRecieverRestriction;
    }

    /**
     * @return {@link List<Sender>}
     */
    @SuppressWarnings("unchecked")
    public static List<Sender> findAll() {
        final Query query = JPA.em().createQuery("FROM Sender");
        return query.getResultList();
    }

    /**
     *
     * @param searchFilter
     * @return
     */
    @SuppressWarnings("unchecked")
    public static List<SenderDto> filterByFullName(final String searchFilter) {
        final StringBuilder queryBuilder = new StringBuilder();
        queryBuilder.append(" Select new models.dto.SenderDto(sender.id, sender.fullName, sender.companyName,sender.identityNumber, sender.accountNo, concat(sender.fullName, ' - ' , sender.identityNumber) as fullNameIdentitiCard, sender.dateOfBirth, sender.expiredDate, sender.address, sender.type) FROM Sender as sender ");
        queryBuilder.append(" WHERE ");
        queryBuilder.append(" lower(sender.companyName) like lower('%" + searchFilter + "%')");
        queryBuilder.append(" OR lower(sender.fullName) like lower('%" + searchFilter + "%')");
        queryBuilder.append(" OR lower(sender.accountNo) like lower('%" + searchFilter + "%')");
        final Query query = JPA.em().createQuery(queryBuilder.toString());
        final List<SenderDto> senderDtos = query.getResultList();
        for (final SenderDto senderDto : senderDtos) {
            if (StringUtils.isBlank(senderDto.getFullName())) {
                senderDto.setFullName(senderDto.getCompanyName());
            }
        }
        return senderDtos;
    }

}
