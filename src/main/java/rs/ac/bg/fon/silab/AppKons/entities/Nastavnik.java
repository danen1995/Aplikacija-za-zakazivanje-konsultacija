/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.AppKons.entities;

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
@Table(name = "NASTAVNIK")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Nastavnik.findAll", query = "SELECT n FROM Nastavnik n"),
    @NamedQuery(name = "Nastavnik.findByJmbg", query = "SELECT n FROM Nastavnik n WHERE n.jmbg = :jmbg"),
    @NamedQuery(name = "Nastavnik.findByIme", query = "SELECT n FROM Nastavnik n WHERE n.ime = :ime"),
    @NamedQuery(name = "Nastavnik.findByPrezime", query = "SELECT n FROM Nastavnik n WHERE n.prezime = :prezime"),
    @NamedQuery(name = "Nastavnik.findByEmail", query = "SELECT n FROM Nastavnik n WHERE n.email = :email"),
    @NamedQuery(name = "Nastavnik.findByBrojTelefona", query = "SELECT n FROM Nastavnik n WHERE n.brojTelefona = :brojTelefona"),
    @NamedQuery(name = "Nastavnik.findByKabinet", query = "SELECT n FROM Nastavnik n WHERE n.kabinet = :kabinet"),
    @NamedQuery(name = "Nastavnik.findBySlika", query = "SELECT n FROM Nastavnik n WHERE n.slika = :slika")})
public class Nastavnik implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "JMBG")
    private String jmbg;
    @Column(name = "IME")
    private String ime;
    @Column(name = "PREZIME")
    private String prezime;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "BROJ_TELEFONA")
    private String brojTelefona;
    @Column(name = "KABINET")
    private String kabinet;
    @Column(name = "SLIKA")
    private String slika;
    @JsonBackReference(value = "pokrivenostNastaveCollection")
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nastavnik")
    private Collection<PokrivenostNastave> pokrivenostNastaveCollection;
    @OneToMany(mappedBy = "nastavnik")
    @JsonBackReference(value = "kalendarCollection")
    private Collection<Kalendar> kalendarCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "nastavnik")
    @JsonBackReference(value = "korisnickiNalogCollection")
    private Collection<KorisnickiNalog> korisnickiNalogCollection;

    public Nastavnik() {
    }

    public Nastavnik(String jmbg) {
        this.jmbg = jmbg;
    }

    public String getJmbg() {
        return jmbg;
    }

    public void setJmbg(String jmbg) {
        this.jmbg = jmbg;
    }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBrojTelefona() {
        return brojTelefona;
    }

    public void setBrojTelefona(String brojTelefona) {
        this.brojTelefona = brojTelefona;
    }

    public String getKabinet() {
        return kabinet;
    }

    public void setSlika(String slika) {
        this.slika = slika;
    }

    public String getSlika() {
        return slika;
    }

    public void setKabinet(String kabinet) {
        this.kabinet = kabinet;
    }

    @XmlTransient
    public Collection<PokrivenostNastave> getPokrivenostNastaveCollection() {
        return pokrivenostNastaveCollection;
    }

    public void setPokrivenostNastaveCollection(Collection<PokrivenostNastave> pokrivenostNastaveCollection) {
        this.pokrivenostNastaveCollection = pokrivenostNastaveCollection;
    }

    @XmlTransient
    public Collection<Kalendar> getKalendarCollection() {
        return kalendarCollection;
    }

    public void setKalendarCollection(Collection<Kalendar> kalendarCollection) {
        this.kalendarCollection = kalendarCollection;
    }

    @XmlTransient
    public Collection<KorisnickiNalog> getKorisnickiNalogCollection() {
        return korisnickiNalogCollection;
    }

    public void setKorisnickiNalogCollection(Collection<KorisnickiNalog> korisnickiNalogCollection) {
        this.korisnickiNalogCollection = korisnickiNalogCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (jmbg != null ? jmbg.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Nastavnik)) {
            return false;
        }
        Nastavnik other = (Nastavnik) object;
        if ((this.jmbg == null && other.jmbg != null) || (this.jmbg != null && !this.jmbg.equals(other.jmbg))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.diplomski.classes.Nastavnik[ jmbg=" + jmbg + " ]";
    }

}
