/*
 * Created on Oct 8, 2014
 */
package models.core;

import java.io.Serializable;

/**
 * @author Vichrak
 * 
 */
public interface Entity<IdentifierType extends Serializable> extends Serializable{
    
    /**
     * @return {@link IdentifierType}
     */
    IdentifierType getId();

    /**
     * @return entity version
     */
    int getEntityVersion();
    
}
