/*
 * Created on Oct 8, 2014
 */
package models.core;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;
import org.hibernate.annotations.OptimisticLockType;
import models.core.Entity;
import models.core.AbstractEntity;

/**
 * @author Vichrak
 * 
 */
@MappedSuperclass
@org.hibernate.annotations.Entity(optimisticLock = OptimisticLockType.VERSION)
public abstract class AbstractLongEntity extends AbstractEntity implements Entity<Long>{
    /**
     * Serial version id.
     */
    private static final long serialVersionUID = 1L;

    private int _entityVersion = 1;
    private Long _id;

    /**
     * Constructeur
     */
    public AbstractLongEntity() {
        super();
    }

    /**
     * {@inheritDoc}
     */
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="id_sequence")
    public Long getId() {
        return _id;
    }

    /**
     * {@inheritDoc}
     */
    public void setId(final Long id) {
        _id = id;
    }

    /**
     * Compare two enties by id and instance of runtime class.
     * if entity is null or entity.getId() is null, it will return false
     * @param entity
     * @return boolean
     */
    public boolean equals(final AbstractLongEntity entity) {
        if (entity == null || entity.getId() == null) {
            return false;
        }
        return entity.getId().equals(this.getId()) && getClass().equals(entity.getClass());
    }

    /**
     * @return the entity version
     */
    @Version
    @Column(name = "entity_version", columnDefinition = "int default 1")
    public int getEntityVersion() {
        return _entityVersion;
    }

    /**
     * @param entityVersion
     *            the entity version to set
     */
    public void setEntityVersion(final int entityVersion) {
        _entityVersion = entityVersion;
    }
}
