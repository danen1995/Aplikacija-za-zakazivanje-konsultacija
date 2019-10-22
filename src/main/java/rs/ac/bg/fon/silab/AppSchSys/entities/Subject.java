/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.AppSchSys.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Collection;
import java.util.List;
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
@Table(name = "SUBJECT")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Subject.findAll", query = "SELECT p FROM Subject p")
    ,
    @NamedQuery(name = "Subject.findBysubjectId", query = "SELECT p FROM Subject p WHERE p.subjectId = :subjectId")
    ,
    @NamedQuery(name = "Subject.findByName", query = "SELECT p FROM Subject p WHERE p.name = :name")
    ,
    @NamedQuery(name = "Subject.findByEspb", query = "SELECT p FROM Subject p WHERE p.espb = :espb")
    ,
    @NamedQuery(name = "Subject.findByYearOfStudies", query = "SELECT p FROM Subject p WHERE p.yearOfStudies = :yearOfStudies")})
public class Subject implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "SUBJECT_ID")
    private BigDecimal subjectId;
    @Column(name = "NAME")
    private String name;
    @Column(name = "ESPB")
    private BigInteger espb;
    @Column(name = "YEAR_OF_STUDIES")
    private String yearOfStudies;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "subject")
    @JsonBackReference(value = "coverageCollection")
    private List<Coverage> coverageCollection;
    @OneToMany(mappedBy = "subjectId")
    @JsonBackReference(value = "nastavaCollection")
    private Collection<Course> nastavaCollection;

    public Subject() {
    }

    public Subject(BigDecimal subjectId) {
        this.subjectId = subjectId;
    }

    public void setSubjectId(BigDecimal subjectId) {
        this.subjectId = subjectId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEspb(BigInteger espb) {
        this.espb = espb;
    }

    public void setYearOfStudies(String yearOfStudies) {
        this.yearOfStudies = yearOfStudies;
    }

    public void setCoverageCollection(List<Coverage> coverageCollection) {
        this.coverageCollection = coverageCollection;
    }

    public void setNastavaCollection(Collection<Course> nastavaCollection) {
        this.nastavaCollection = nastavaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (subjectId != null ? subjectId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Subject)) {
            return false;
        }
        Subject other = (Subject) object;
        if ((this.subjectId == null && other.subjectId != null) || (this.subjectId != null && !this.subjectId.equals(other.subjectId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.diplomski.classes.SUBJECT[ subjectId=" + subjectId + " ]";
    }

}
