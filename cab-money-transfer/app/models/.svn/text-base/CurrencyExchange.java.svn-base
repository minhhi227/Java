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

import models.core.AbstractDateAuditableEntity;
import play.db.jpa.JPA;

/**
 * @author Vichrak
 *
 */
@Entity
@Table(name = "CURRENCY")
@SequenceGenerator(allocationSize = 1, name = "id_sequence", sequenceName = "currency_id_sequence")
public class CurrencyExchange extends AbstractDateAuditableEntity{
    
    private static final long serialVersionUID = 1L;
    
    private String _name;
    private String _description;
    
    /**
     * Constructor
     */
    public CurrencyExchange(){
        super();
    }
    
    public CurrencyExchange(final String name, final String description){
        super();
        _name = name;
        _description = description;
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
    public void setName(final String name) {
        _name = name;
    }

    /**
     * @return the description
     */
    @Column
    public String getDescription() {
        return _description;
    }

    /**
     * @param description
     * 			the description to set
     */
    public void setDescription(final String description) {
        _description = description;
    }

    /**
     *
     * @return
     */
    @SuppressWarnings("unchecked")
    public static List<CurrencyExchange> getAll() {
        final Query query = JPA.em().createQuery("FROM CurrencyExchange ORDER BY name DESC ");
        return query.getResultList();
    }

}
