/*
 * Created on Oct 9, 2014
 */
package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import models.core.AbstractDateAuditableEntity;

/**
 * @author Vichrak
 * 
 */
@Entity
@Table(name = "MODE_PAYMENT")
@SequenceGenerator(allocationSize=1, name="id_sequence", sequenceName="mode_payment_id_sequence")
public class ModePayment extends AbstractDateAuditableEntity{
    
    private static final long serialVersionUID = 1L;
    
    private String _name;
    private String _description;
    
    /**
     * Constructor
     */
    public ModePayment(){
        super();
    }
    
    /**
     * @return the name
     */
    @Column(nullable = false, length = 10)
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
     * @return the description
     */
    @Column
    public String getDescription(){
        return _description;
    }
    
    /**
     * @param description 
     * 			the description to set
     */
    public void setDescription(final String description){
        _description = description;
    }
    
}
