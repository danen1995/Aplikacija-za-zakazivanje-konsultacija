/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.AppSchSys.entities;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Dane
 */
@Entity
@Table(name = "COVERAGE")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Coverage.findAll", query = "SELECT p FROM Coverage p")
    ,
    @NamedQuery(name = "Coverage.findByTeacherId", query = "SELECT p FROM Coverage p WHERE p.coveragePK.teacherId = ?")
    ,
    @NamedQuery(name = "Coverage.findBySubjectId", query = "SELECT p FROM Coverage p WHERE p.coveragePK.subjectId = :subjectId")
    ,
    @NamedQuery(name = "Coverage.findByFunction", query = "SELECT p FROM Coverage p WHERE p.function = :function")})
public class Coverage implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected CoveragePK coveragePK;
    @Column(name = "FUNCTION")
    private String function;
    @JoinColumn(name = "TEACHER_ID", referencedColumnName = "TEACHER_ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Teacher teacher;
    @JoinColumn(name = "SUBJECT_ID", referencedColumnName = "SUBJECT_ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Subject subject;
    @JoinColumn(name = "SCHOOL_YEAR_ID", referencedColumnName = "SCHOOL_YEAR_ID")
    @ManyToOne
    private SchoolYear schoolYearId;

    public Coverage() {
    }

    public Coverage(CoveragePK coveragePK) {
        this.coveragePK = coveragePK;
    }

    public Coverage(String teacherId, BigInteger subjectId) {
        this.coveragePK = new CoveragePK(teacherId, subjectId);
    }

    public CoveragePK getCoveragePK() {
        return coveragePK;
    }

    public String getFunction() {
        return function;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public Subject getSubject() {
        return subject;
    }

    public SchoolYear getSchoolYearId() {
        return schoolYearId;
    }

    public void setCoveragePK(CoveragePK coveragePK) {
        this.coveragePK = coveragePK;
    }

    public void setFunction(String function) {
        this.function = function;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public void setSchoolYearId(SchoolYear schoolYearId) {
        this.schoolYearId = schoolYearId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (coveragePK != null ? coveragePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Coverage)) {
            return false;
        }
        Coverage other = (Coverage) object;
        if ((this.coveragePK == null && other.coveragePK != null) || (this.coveragePK != null && !this.coveragePK.equals(other.coveragePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.diplomski.classes.Coverage[ coveragePK=" + coveragePK + " ]";
    }

}
