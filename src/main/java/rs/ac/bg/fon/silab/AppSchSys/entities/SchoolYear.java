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
@Table(name = "SCHOOL_YEAR")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SchoolYear.findAll", query = "SELECT s FROM SchoolYear s")
    ,
    @NamedQuery(name = "SchoolYear.findByschoolYearId", query = "SELECT s FROM SchoolYear s WHERE s.schoolYearId = :schoolYearId")
    ,
    @NamedQuery(name = "SchoolYear.findBySkolskaGodina", query = "SELECT s FROM SchoolYear s WHERE s.schoolYear = :schoolYear")
    ,
    @NamedQuery(name = "SchoolYear.findBysemester", query = "SELECT s FROM SchoolYear s WHERE s.semester = :semester")})
public class SchoolYear implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "SCHOOL_YEAR_ID")
    private BigDecimal schoolYearId;
    @Column(name = "SCHOOL_YEAR")
    private String schoolYear;
    @Column(name = "SEMESTER")
    private String semester;
    @OneToMany(mappedBy = "schoolYearId")
    @JsonBackReference(value = "coverageCollection")
    private Collection<Coverage> coverageCollection;
    @OneToMany(mappedBy = "schoolYearId")
    @JsonBackReference(value = "calendarCollection2")
    private Collection<Calendar> calendarCollection;

    public SchoolYear() {
    }

    public SchoolYear(BigDecimal schoolYearId) {
        this.schoolYearId = schoolYearId;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public BigDecimal getSchoolYearId() {
        return schoolYearId;
    }

    public String getSchoolYear() {
        return schoolYear;
    }

    public String getSemester() {
        return semester;
    }

    public Collection<Coverage> getCoverageCollection() {
        return coverageCollection;
    }

    public Collection<Calendar> getCalendarCollection() {
        return calendarCollection;
    }

    public void setSchoolYearId(BigDecimal schoolYearId) {
        this.schoolYearId = schoolYearId;
    }

    public void setSchoolYear(String schoolYear) {
        this.schoolYear = schoolYear;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public void setCoverageCollection(Collection<Coverage> coverageCollection) {
        this.coverageCollection = coverageCollection;
    }

    public void setCalendarCollection(Collection<Calendar> calendarCollection) {
        this.calendarCollection = calendarCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (schoolYearId != null ? schoolYearId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SchoolYear)) {
            return false;
        }
        SchoolYear other = (SchoolYear) object;
        if ((this.schoolYearId == null && other.schoolYearId != null) || (this.schoolYearId != null && !this.schoolYearId.equals(other.schoolYearId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.diplomski.classes.SchoolYear[ schoolYearId=" + schoolYearId + " ]";
    }

}
