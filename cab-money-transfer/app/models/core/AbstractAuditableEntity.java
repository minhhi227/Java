/*
 * Created on Oct 8, 2014
 */
package models.core;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

/**
 * @author Vichrak
 *
 */
@MappedSuperclass
public abstract class AbstractAuditableEntity extends AbstractDateAuditableEntity implements Auditable{
    
    private static final long serialVersionUID = 5509809200434934431L;
    
    private String _createdBy;
    private String _modifiedBy;
    
    public AbstractAuditableEntity(){
        super();
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    @Column(name = "created_by", length = 50, updatable = false)
    public String getCreatedBy(){
        return _createdBy;
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public void setCreatedBy(final String createdBy){
        _createdBy = createdBy;
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    @Column(name = "modified_by", length = 50)
    public String getModifiedBy(){
        return _modifiedBy;
    }
    
    /**
     * {@inheritDoc}
     */
    @Override
    public void setModifiedBy(final String modifiedBy){
        _modifiedBy = modifiedBy;
    }
}
