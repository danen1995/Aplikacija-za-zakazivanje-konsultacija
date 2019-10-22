/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.AppSchSys.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import rs.ac.bg.fon.silab.AppSchSys.entities.audit.UserDateAudit;

/**
 *
 * @author Dane
 */
@Entity
@Table(name = "USER_ACCOUNT", uniqueConstraints = {
    @UniqueConstraint(columnNames = {
        "USER_ACCOUNT_ID"
    })
    ,
        @UniqueConstraint(columnNames = {
        "USER_NAME"
    })
})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UserAccount.findAll", query = "SELECT k FROM UserAccount k")
    ,
    @NamedQuery(name = "UserAccount.findByUserAccountId", query = "SELECT k FROM UserAccount k WHERE k.userAccountId = ?1")
    ,
    @NamedQuery(name = "UserAccount.findByUserName", query = "SELECT k FROM UserAccount k WHERE k.userName = ?1")
    ,
    @NamedQuery(name = "UserAccount.findByPassword", query = "SELECT k FROM UserAccount k WHERE k.password = :password")})
public class UserAccount extends UserDateAudit implements Serializable {

    @JoinTable(name = "USER_ACCOUNT_ROLE", joinColumns = {
        @JoinColumn(name = "USER_ACCOUNT_ID", referencedColumnName = "USER_ACCOUNT_ID")}, inverseJoinColumns = {
        @JoinColumn(name = "ROLE_ID", referencedColumnName = "ROLE_ID")})
    @ManyToMany
    @JsonBackReference(value = "rolеCollection")
    private Collection<Role> rolеCollection;

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "USER_ACCOUNT_ID")
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigDecimal userAccountId;
    @Column(name = "USER_NAME")
    private String userName;
    @Column(name = "PASSWORD")
    private String password;
    @JoinColumn(name = "TEACHER_ID", referencedColumnName = "TEACHER_ID")
    @ManyToOne(optional = false)
    private Teacher teacher;
    @JoinColumn(name = "INDEX_NUMBER", referencedColumnName = "INDEX_NUMBER")
    @ManyToOne
    private Student student;
//    @ElementCollection(fetch = FetchType.EAGER, targetClass = UserRoleEnum.class)
//    @Enumerated(EnumType.STRING)
//    private Set<UserRoleEnum> roles;

    public UserAccount() {
    }

    public UserAccount(BigDecimal userAccountId) {
        this.userAccountId = userAccountId;
    }

    public Collection<Role> getRolеCollection() {
        return rolеCollection;
    }

    public BigDecimal getUserAccountId() {
        return userAccountId;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public Student getStudent() {
        return student;
    }

    public void setRolеCollection(Collection<Role> rolеCollection) {
        this.rolеCollection = rolеCollection;
    }

    public void setUserAccountId(BigDecimal userAccountId) {
        this.userAccountId = userAccountId;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userAccountId != null ? userAccountId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UserAccount)) {
            return false;
        }
        UserAccount other = (UserAccount) object;
        if ((this.userAccountId == null && other.userAccountId != null) || (this.userAccountId != null && !this.userAccountId.equals(other.userAccountId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.diplomski.classes.UserAccount[ userAccountId=" + userAccountId + " ]";
    }

}
