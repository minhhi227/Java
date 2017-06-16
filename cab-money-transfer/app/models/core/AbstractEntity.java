/*
 * Created on 30 09 2014
 */
package models.core;

import java.io.Serializable;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import play.db.jpa.JPA;

/**
 * 
 * @author Vichrak
 * 
 */
public abstract class AbstractEntity implements Serializable{
    
    private static final long serialVersionUID = 1L;
    public static final String NA = "N/A";
    
    /**
     * @param entity
     * @return true if the entity contains in the database
     */
    public static boolean contains(final Object entity){
        return JPA.em().contains(entity);
    }
    
    /**
     * @param clazz
     * @param entityId
     * @return {@link Entity}
     */
    public static Object findById(final Class< ?> clazz, final Long entityId){
        return JPA.em().find(clazz, entityId);
    }
    
    /**
     * @param entity
     * @return {@link Object}
     */
    public static Object saveOrUpdate(final Object entity){
        return JPA.em().merge(entity);
    }
    
    /**
     * @param entity
     */
    public static void delete(final Object entity){
        JPA.em().remove(entity);
    }
    
    /**
     * @param clazz
     * @param entityId
     * @throws Exception
     */
    public static void deleteById(final Class< ?> clazz, final Long entityId) throws Exception{
        Object entity = findById(clazz, entityId);
        if(entity == null){
            throw new Exception("Could not delete due to entity not found.");
        }
        delete(entity);
    }
    
    /**
     * @return {@link CriteriaBuilder}
     */
    public static CriteriaBuilder getCriteriaBuilder(){
        return JPA.em().getCriteriaBuilder();
    }
    
    public static EntityManager getEntityManager(){
        return JPA.em();
    }
    
}
