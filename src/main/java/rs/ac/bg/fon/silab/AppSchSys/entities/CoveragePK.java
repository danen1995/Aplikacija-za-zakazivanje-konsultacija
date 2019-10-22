/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.AppSchSys.entities;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Dane
 */
@Embeddable
public class CoveragePK implements Serializable {

    @Basic(optional = false)
    @Column(name = "TEACHER_ID")
    private String teacherId;
    @Basic(optional = false)
    @Column(name = "SUBJECT_ID")
    private BigInteger subjectId;

    public CoveragePK() {
    }

    public CoveragePK(String jmbgNastavnika, BigInteger idPredmeta) {
        this.teacherId = jmbgNastavnika;
        this.subjectId = idPredmeta;
    }

    public String getJmbgNastavnika() {
        return teacherId;
    }

    public void setJmbgNastavnika(String jmbgNastavnika) {
        this.teacherId = jmbgNastavnika;
    }

    public BigInteger getIdPredmeta() {
        return subjectId;
    }

    public void setIdPredmeta(BigInteger subjectId) {
        this.subjectId = subjectId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (teacherId != null ? teacherId.hashCode() : 0);
        hash += (subjectId != null ? subjectId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final CoveragePK other = (CoveragePK) obj;
        if (!Objects.equals(this.teacherId, other.teacherId)) {
            return false;
        }
        if (!Objects.equals(this.subjectId, other.subjectId)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.diplomski.classes.CoveragePK[ jmbgNastavnika=" + teacherId + ", idPredmeta=" + subjectId + " ]";
    }

}
