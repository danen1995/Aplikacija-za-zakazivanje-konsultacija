/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.AppKons.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
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
@Table(name = "PRILOG")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Prilog.findAll", query = "SELECT p FROM Prilog p"),
    @NamedQuery(name = "Prilog.findByIdPriloga", query = "SELECT p FROM Prilog p WHERE p.idPriloga = :idPriloga"),
    @NamedQuery(name = "Prilog.findByNaziv", query = "SELECT p FROM Prilog p WHERE p.naziv = :naziv"),
    @NamedQuery(name = "Prilog.findByLokacija", query = "SELECT p FROM Prilog p WHERE p.lokacija = :lokacija")})
public class Prilog implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID_PRILOGA")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private BigDecimal idPriloga;
    @Column(name = "NAZIV")
    private String naziv;
    @Column(name = "LOKACIJA")
    private byte[] lokacija;
    @JoinColumns({
        @JoinColumn(name = "ID_KALENDARA", referencedColumnName = "ID_KALENDARA"),
        @JoinColumn(name = "ID_DOGADJAJA", referencedColumnName = "ID_DOGADJAJA"),
        @JoinColumn(name = "BROJ_INDEKSA_STUDENTA", referencedColumnName = "BROJ_INDEKSA_STUDENTA")})
    @ManyToOne
    private StudentKonsultacije studentKonsultacije;

    public Prilog() {
    }

    public Prilog(BigDecimal idPriloga) {
        this.idPriloga = idPriloga;
    }

    public Prilog(String naziv, byte[] lokacija, StudentKonsultacije studentKonsultacije) {
        this.naziv = naziv;
        this.lokacija = lokacija;
        this.studentKonsultacije = studentKonsultacije;
    }

    public BigDecimal getIdPriloga() {
        return idPriloga;
    }

    public void setIdPriloga(BigDecimal idPriloga) {
        this.idPriloga = idPriloga;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public byte[] getLokacija() {
        return lokacija;
    }

    public void setLokacija(byte[] lokacija) {
        this.lokacija = lokacija;
    }

    public StudentKonsultacije getStudentKonsultacije() {
        return studentKonsultacije;
    }

    public void setStudentKonsultacije(StudentKonsultacije studentKonsultacije) {
        this.studentKonsultacije = studentKonsultacije;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPriloga != null ? idPriloga.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Prilog)) {
            return false;
        }
        Prilog other = (Prilog) object;
        if ((this.idPriloga == null && other.idPriloga != null) || (this.idPriloga != null && !this.idPriloga.equals(other.idPriloga))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.diplomski.classes.Prilog[ idPriloga=" + idPriloga + " ]";
    }

}
