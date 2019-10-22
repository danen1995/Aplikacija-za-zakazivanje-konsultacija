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
@Table(name = "STUDENT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Student.findAll", query = "SELECT s FROM Student s")
    ,
    @NamedQuery(name = "Student.findByIndexNumber", query = "SELECT s FROM Student s WHERE s.indexNumber = :indexNumber")
    ,
    @NamedQuery(name = "Student.findByFirstName", query = "SELECT s FROM Student s WHERE s.firstName = :firstName")
    ,
    @NamedQuery(name = "Student.findByLastName", query = "SELECT s FROM Student s WHERE s.lastName = :lastName")
    ,
    @NamedQuery(name = "Student.findByYearOfEntry", query = "SELECT s FROM Student s WHERE s.yearOfEntry = :yearOfEntry")
    ,
    @NamedQuery(name = "Student.findByDepartment", query = "SELECT s FROM Student s WHERE s.department = :department")
    ,
    @NamedQuery(name = "Student.findByTelephone", query = "SELECT s FROM Student s WHERE s.telephone = :telephone")
    ,
    @NamedQuery(name = "Student.findByEmail", query = "SELECT s FROM Student s WHERE s.email = :email")})
public class Student implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "INDEX_NUMBER")
    private String indexNumber;
    @Column(name = "FIRST_NAME")
    private String firstName;
    @Column(name = "LAST_NAME")
    private String lastName;
    @Column(name = "YEAR_OF_ENTRY")
    private Short yearOfEntry;
    @Column(name = "DEPARTMENT")
    private String department;
    @Column(name = "TELEPHONE")
    private String telephone;
    @Column(name = "EMAIL")
    private String email;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "student")
    @JsonBackReference(value = "studentConsultationCollection")
    private Collection<ScheduledConsultation> studentConsultationCollection;
    @OneToMany(mappedBy = "student")
    @JsonBackReference(value = "UserAccountCollection")
    private Collection<UserAccount> UserAccountCollection;

    public Student() {
    }

    public Student(String indexNumber) {
        this.indexNumber = indexNumber;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getIndexNumber() {
        return indexNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Short getYearOfEntry() {
        return yearOfEntry;
    }

    public String getDepartment() {
        return department;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getEmail() {
        return email;
    }

    public Collection<ScheduledConsultation> getStudentConsultationCollection() {
        return studentConsultationCollection;
    }

    public Collection<UserAccount> getUserAccountCollection() {
        return UserAccountCollection;
    }

    public void setIndexNumber(String indexNumber) {
        this.indexNumber = indexNumber;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setYearOfEntry(Short yearOfEntry) {
        this.yearOfEntry = yearOfEntry;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setStudentConsultationCollection(Collection<ScheduledConsultation> studentConsultationCollection) {
        this.studentConsultationCollection = studentConsultationCollection;
    }

    public void setUserAccountCollection(Collection<UserAccount> UserAccountCollection) {
        this.UserAccountCollection = UserAccountCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (indexNumber != null ? indexNumber.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Student)) {
            return false;
        }
        Student other = (Student) object;
        if ((this.indexNumber == null && other.indexNumber != null) || (this.indexNumber != null && !this.indexNumber.equals(other.indexNumber))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.diplomski.classes.Student[ indexNumber=" + indexNumber + " ]";
    }

}
