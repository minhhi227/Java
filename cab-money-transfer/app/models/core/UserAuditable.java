/*
 * Created on Oct 8, 2014
 */
package models.core;

import models.User;

/**
 * @author Vichrak
 *
 */
public interface UserAuditable {

    String CREATED_BY_PROPERTY_NAME = "createdBy";
    String MODIFIED_BY_PROPERTY_NAME = "modifiedBy";

    /**
     * @return {@link User}
     */
    String getCreatedBy();

    /**
     * @return {@link User}
     */
    String getModifiedBy();

    /**
     * @param actor : {@link User}
     */
    void setCreatedBy(String user);

    /**
     * @param actor : {@link User}
     */
    void setModifiedBy(String user);
}
