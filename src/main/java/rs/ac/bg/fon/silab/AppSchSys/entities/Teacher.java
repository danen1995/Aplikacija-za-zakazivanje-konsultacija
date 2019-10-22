/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.AppSchSys.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Dane
 */
@Entity
@Table(name = "TEACHER")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Teacher.findAll", query = "SELECT n FROM Teacher n")
    ,
    @NamedQuery(name = "Teacher.findByTeacherId", query = "SELECT n FROM Teacher n WHERE n.teacherId = :teacherId")
    ,
    @NamedQuery(name = "Teacher.findByFirstName", query = "SELECT n FROM Teacher n WHERE n.firstName = :firstName")
    ,
    @NamedQuery(name = "Teacher.findByLastName", query = "SELECT n FROM Teacher n WHERE n.lastName = :lastName")
    ,
    @NamedQuery(name = "Teacher.findByEmail", query = "SELECT n FROM Teacher n WHERE n.email = :email")
    ,
    @NamedQuery(name = "Teacher.findByTelephone", query = "SELECT n FROM Teacher n WHERE n.telephone = :telephone")
    ,
    @NamedQuery(name = "Teacher.findByCabinet", query = "SELECT n FROM Teacher n WHERE n.cabinet = :cabinet")
    ,
    @NamedQuery(name = "Teacher.findByImage", query = "SELECT n FROM Teacher n WHERE n.image = :image")})
public class Teacher implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "TEACHER_ID")
    private String teacherId;
    @Column(name = "FIRST_NAME")
    private String firstName;
    @Column(name = "LAST_NAME")
    private String lastName;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "TELEPHONE")
    private String telephone;
    @Column(name = "CABINET")
    private String cabinet;
    @Column(name = "IMAGE")
    private String image;
    @JsonBackReference(value = "coverageCollection")
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "teacher")
    private Collection<Coverage> coverageCollection;
    @OneToMany(mappedBy = "teacher")
    @JsonBackReference(value = "calendarCollection")
    private Collection<Calendar> calendarCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "teacher")
    @JsonBackReference(value = "UserAccountCollection")
    private Collection<UserAccount> userAccountCollection;

    public Teacher() {
    }

    public Teacher(String teacherId) {
        this.teacherId = teacherId;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getCabinet() {
        return cabinet;
    }

    public String getImage() {
        return image;
    }
    public Collection<Coverage> getCoverageCollection() {
        return coverageCollection;
    }

    public Collection<Calendar> getCalendarCollection() {
        return calendarCollection;
    }

    public Collection<UserAccount> getUserAccountCollection() {
        return userAccountCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (teacherId != null ? teacherId.hashCode() : 0);
        return hash;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public void setCabinet(String cabinet) {
        this.cabinet = cabinet;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setCoverageCollection(Collection<Coverage> coverageCollection) {
        this.coverageCollection = coverageCollection;
    }

    public void setCalendarCollection(Collection<Calendar> calendarCollection) {
        this.calendarCollection = calendarCollection;
    }

    public void setUserAccountCollection(Collection<UserAccount> userAccountCollection) {
        this.userAccountCollection = userAccountCollection;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Teacher)) {
            return false;
        }
        Teacher other = (Teacher) object;
        if ((this.teacherId == null && other.teacherId != null) || (this.teacherId != null && !this.teacherId.equals(other.teacherId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.diplomski.classes.teacher[ teacherId=" + teacherId + " ]";
    }

}
