/**
 * Created on 30 09 2014
 */
package models;

import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Query;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import play.db.jpa.JPA;
import models.core.AbstractDateAuditableEntity;

/**
 * @author Vichrak
 *
 */
@Entity
@Table(name = "ROLE")
@SequenceGenerator(allocationSize=1, name="id_sequence", sequenceName="role_id_sequence")
public class Role extends AbstractDateAuditableEntity{
    
    private static final long serialVersionUID = 1L;
    private String _code;
    private String _label;
    private Set<User> _users;
    
    public Role(){
        super();
    }
    
    public Role(final String code, final String label){
        super();
        _code = code;
        _label = label;
    }
    
    /**
     * @return the code
     */
    @Column(nullable = false, length = 50)
    public String getCode(){
        return _code;
    }
    
    /**
     * @param code
     *            the code to set
     */
    public void setCode(final String code){
        _code = code;
    }
    
    /**
     * @return the label
     */
    @Column(nullable = false, length = 50)
    public String getLabel(){
        return _label;
    }
    
    /**
     * @param label 
     * 			the label to set
     */
    public void setLabel(final String label){
        _label = label;
    }
    
    /**
     * @return the users
     */
    @OneToMany(mappedBy = "role", cascade = CascadeType.ALL)
    public Set<User> getUsers(){
        return _users;
    }
    
    /**
     * @param users
     *            the users to set
     */
    public void setUsers(final Set<User> users){
        _users = users;
    }
    
    /**
     * @return {@link List<User>}
     */
    @SuppressWarnings("unchecked")
    public static List<Role> findAll(){
        Query query = JPA.em().createQuery("FROM Role");
        return query.getResultList();
    }
}
