/**
 * Created on 30 09 2014
 */
package models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Query;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.annotations.Index;
import org.hibernate.annotations.Proxy;

import play.db.jpa.JPA;

//import models.Role;

/**
 * @author Vichrak
 */
@Entity
@Proxy(lazy = false)
@Table(name = "ACCOUNT")
@SequenceGenerator(allocationSize = 1, name = "id_sequence", sequenceName = "account_id_sequence")
public class User extends Person {

    private static final long serialVersionUID = 1L;
    private boolean _active;
    private String _username;
    private String _password;
    private Role _role;
    private Branch _branch;

    /**
     * Constructor
     */
    public User() {
        super();
    }

    /**
     * @return the active
     */
    @Column(nullable = false)
    public boolean isActive() {
        return _active;
    }

    /**
     * @param active
     *          the active to set
     */
    public void setActive(final boolean active) {
        _active = active;
    }

    /**
     * @return the username
     */
    @Column(length = 50, nullable = false, unique = true)
    public String getUsername() {
        return _username;
    }

    /**
     * @param username
     *            the username to set
     */
    public void setUsername(final String username) {
        _username = username;
    }

    /**
     * @return the password
     */
    @Column(length = 30, nullable = false)
    public String getPassword() {
        return _password;
    }

    /**
     * @param password
     *            the password to set
     */
    public void setPassword(final String password) {
        _password = password;
    }

    /**
     * @return the role
     */
    @ManyToOne(fetch = FetchType.EAGER)
    @Index(columnNames = {
        "role_id"
    }, name = "IX_ROLE_ID")
    public Role getRole() {
        return _role;
    }

    /**
     * @param role
     * 			the role to set
     */
    public void setRole(final Role role) {
        _role = role;
    }

    /**
     * @return the branch
     */
    @ManyToOne(fetch = FetchType.EAGER)
    @Index(columnNames = {
        "branch_id"
    }, name = "IX_BRANCH_ID")
    public Branch getBranch() {
        return _branch;
    }

    /**
     * @param branch
     * 			the branch to set
     */
    public void setBranch(final Branch branch) {
        _branch = branch;
    }

    /**
     * Get user by login
     *
     * @param login
     * @return {@link User}
     */
    @SuppressWarnings("unchecked")
    public static User findByLogin(final String login) {
        if (login == null) {
            return null;
        }
        final Query query = JPA.em().createQuery("FROM User WHERE username=:login");
        query.setParameter("login", login);
        final List<User> users = query.getResultList();
        if (users.size() == 0) {
            return null;
        }
        return users.iterator().next();
    }

    /**
     * @param username
     * @param password
     * @return {@link User}
     */
    @SuppressWarnings("unchecked")
    public static User authenticate(final String username, final String password) {
        final boolean isInvalid = StringUtils.isBlank(username) || StringUtils.isBlank(password);
        if (isInvalid) {
            return null;
        }
        final Query query = JPA.em().createQuery("from User where username=:username and password=:password and active=:active");
        query.setParameter("username", username);
        query.setParameter("password", password);
        query.setParameter("active", true);
        final List<User> users = query.getResultList();
        if (users.size() == 0) {
            return null;
        }
        return users.iterator().next();
    }

    /**
     * @return {@link List<User>}
     */
    @SuppressWarnings("unchecked")
    public static List<User> findAll() {
        final Query query = JPA.em().createQuery("FROM User");
        return query.getResultList();
    }
}
