/*
 * Created on Oct 27, 2014
 */
package models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Query;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import models.core.AbstractDateAuditableEntity;

import org.apache.commons.lang3.StringUtils;

import play.db.jpa.JPA;
import utils.CABConstantKeys;
import utils.DateUtils;

/**
 *
 * @author Chamnan
 *
 */
@Entity
@Table(name = "TEMP_CODE_GENERATION")
@SequenceGenerator(allocationSize = 1, name = "id_sequence", sequenceName = "temp_code_generation_id_sequence")
public class TempCodeGeneration extends AbstractDateAuditableEntity {

    private static final long serialVersionUID = 1L;
    private String _type;
    private long _branchId;
    private String _code;

    /**
     * Constructor
     */
    public TempCodeGeneration() {
        super();
    }

    /**
     * @return the type
     */
    @Column(name = "type")
    public String getType() {
        return _type;
    }

    /**
     * @param type the type to set
     */
    public void setType(final String type) {
        _type = type;
    }

    /**
     * @return the branchId
     */
    @Column(name = "branch_id")
    public long getBranchId() {
        return _branchId;
    }

    /**
     * @param branchId the branchId to set
     */
    public void setBranchId(final long branchId) {
        _branchId = branchId;
    }

    /**
     * @return the code
     */
    @Column(name = "code", nullable = false, unique = true)
    public String getCode() {
        return _code;
    }

    /**
     * @param code the code to set
     */
    public void setCode(final String code) {
        _code = code;
    }

    /**
     * @return {@link TempCodeGeneration}
     */
    @SuppressWarnings("unchecked")
    public static TempCodeGeneration getLast(final long branchId, final String type) {
        final Query query = JPA.em().createQuery("FROM TempCodeGeneration WHERE branchId = :branchId AND type = :type ORDER BY id DESC ");
        query.setParameter("branchId", branchId);
        query.setParameter("type", type);
        query.setMaxResults(1);
        final List<TempCodeGeneration> tempCodeGenerations = query.getResultList();
        if (tempCodeGenerations.size() == 0) {
            return null;
        }
        return tempCodeGenerations.iterator().next();
    }

    private static TempCodeGeneration build(final long branchId, final String type, final String bankRef, final String code) {
        final TempCodeGeneration branchCodeGeneration = new TempCodeGeneration();
        final String shortCurrentYear = DateUtils.getShortCurrentYear();
        branchCodeGeneration.setBranchId(branchId);
        branchCodeGeneration.setType(type);
        branchCodeGeneration.setCode(bankRef + shortCurrentYear + CABConstantKeys.HYPHEN + code);
        return branchCodeGeneration;
    }

    public static String genereateBankReference(final Branch branch, final String bankRef, final String type) {
        TempCodeGeneration branchCodeGeneration = null;
        long branchId = branch.getId();
        String initBankCode = branch.getInitBankCode();
        final TempCodeGeneration lastBranchCodeGeneration = TempCodeGeneration.getLast(branchId, type);
        if (lastBranchCodeGeneration == null) {
            branchCodeGeneration = build(branchId, type, bankRef, initBankCode);
        }
        else {
            // set next bank ref.
            final String lastBankRef = lastBranchCodeGeneration.getCode();
            final String[] ref = lastBankRef.split(CABConstantKeys.HYPHEN);
            final String shortYear = StringUtils.right(ref[ref.length - 2], 2);
            final long lastCode = Long.parseLong(ref[ref.length - 1]);
            if (shortYear.equals(DateUtils.getShortCurrentYear())) {
                branchCodeGeneration = build(branchId, type, bankRef, "" + (lastCode + 1));
            }
            else {
                branchCodeGeneration = build(branchId, type, bankRef, initBankCode);
            }
        }
        branchCodeGeneration = (TempCodeGeneration) saveOrUpdate(branchCodeGeneration);
        return branchCodeGeneration.getCode();
    }

}
