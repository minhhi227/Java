package models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Query;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import models.core.AbstractDateAuditableEntity;
import play.db.jpa.JPA;

/**
 *
 * @author Chamnan
 *
 */

@Entity
@Table(name = "rule_fill_amount_management")
@SequenceGenerator(allocationSize = 1, name = "id_sequence", sequenceName = "rule_fill_amount_id_sequence")
public class RuleFillAmountManagement extends AbstractDateAuditableEntity {

    private static final long serialVersionUID = 1L;

    private String _senderType;
    private double _usdAmount;
    private double _percentFee;
    private double _cable;
    private String _ruleType;

    /**
     * @return the senderType
     */
    @Column(name = "sender_type")
    public String getSenderType() {
        return _senderType;
    }

    /**
     * @param senderType the senderType to set
     */
    public void setSenderType(final String senderType) {
        _senderType = senderType;
    }

    /**
     * @return the usdAmount
     */
    @Column(name = "usd_amount")
    public double getUsdAmount() {
        return _usdAmount;
    }

    /**
     * @param usdAmount the usdAmount to set
     */
    public void setUsdAmount(final double usdAmount) {
        _usdAmount = usdAmount;
    }

    /**
     * @return the percentFee
     */
    @Column(name = "percent_fee")
    public double getPercentFee() {
        return _percentFee;
    }

    /**
     * @param percentFee the percentFee to set
     */
    public void setPercentFee(final double percentFee) {
        _percentFee = percentFee;
    }

    /**
     * @return the cable
     */
    @Column(name = "cable")
    public double getCable() {
        return _cable;
    }

    /**
     * @param cable the cable to set
     */
    public void setCable(final double cable) {
        _cable = cable;
    }

    /**
     * @return the ruleType
     */
    @Column(name = "rule_type", length = 10)
    public String getRuleType() {
        return _ruleType;
    }

    /**
     * @param ruleType the ruleType to set
     */
    public void setRuleType(final String ruleType) {
        _ruleType = ruleType;
    }

    /**
     *
     * @return
     */
    @SuppressWarnings("unchecked")
    public static List<RuleFillAmountManagement> getAll() {
        final Query query = JPA.em().createQuery("From RuleFillAmountManagement ORDER BY id");
        return query.getResultList();
    }
    
    /**
     * 
     * @param usdAmount
     * @param senderType
     */
    public static void updateBySenderType(final double usdAmount,final String senderType) {
        Query query = JPA.em().createQuery("UPDATE RuleFillAmountManagement SET usdAmount =:usdAmount WHERE senderType = :senderType");
        query.setParameter("usdAmount", usdAmount);
        query.setParameter("senderType", senderType);
        query.executeUpdate();
    }

}
