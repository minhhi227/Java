/*
 * Created on 30 09 2014
 */
package models.core;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.PreUpdate;
import models.core.DateAuditable;
import models.core.AbstractLongEntity;

/**
 * 
 * @author Vichrak
 * 
 */
@MappedSuperclass
public abstract class AbstractDateAuditableEntity extends AbstractLongEntity implements DateAuditable{
    
    private static final long serialVersionUID = 1L;
    private Date _dateCreation;
    private Date _dateModification;
    
    public AbstractDateAuditableEntity(){
        super();
    }
    
    /**
     * @return the dateCreation
     */
    @Override
    @Column(name = "date_creation", updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    public Date getDateCreation(){
        return _dateCreation;
    }
    
    /**
     * @param dateCreation
     *            the dateCreation to set
     */
    @Override
    public void setDateCreation(final Date dateCreation){
        _dateCreation = dateCreation;
    }
    
    /**
     * @param dateModification
     * 				the dateModification to set
     */
    @Override
    public void setDateModification(final Date dateModification){
        _dateModification = dateModification;
    }
    
    /**
     * @return the dateModification
     */
    @Override
    @Column(name = "date_modification")
    @Temporal(TemporalType.TIMESTAMP)
    public Date getDateModification(){
        return _dateModification;
    }
    
    @PrePersist
    void onPrePersist(){
        this.setDateCreation(new Date());
        this.setDateModification(new Date());
    }
    
    /**
     * on update, set dateModification
     */
    @PreUpdate
    void onPreUpdate(){
        this.setDateModification(new Date());
    }
    
}
