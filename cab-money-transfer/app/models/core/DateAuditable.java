/*
 * Created on Oct 8, 2014
 */
package models.core;
import java.util.Date;

/**
 * @author Vichrak
 * 
 */
public interface DateAuditable{
    
    String DATE_CREATION_PROPERTY_NAME = "dateCreation";
    String DATE_MODIFICATION_PROPERTY_NAME = "dateModification";
    
    /**
     * @return {@link Date}
     */
    Date getDateCreation();

    /**
     * @return {@link Date}
     */
    Date getDateModification();

    /**
     * @param date
     */
    void setDateCreation(Date date);

    /**
     * @param date
     */
    void setDateModification(Date date);
}
