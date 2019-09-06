/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.AppKons.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;
import java.util.Collection;
import rs.ac.bg.fon.silab.AppKons.entities.Rola;

/**
 *
 * @author Dane
 */
public class KorisnickiNalogDTO {

    @JsonProperty(value = "idKorisnickogNaloga", access = JsonProperty.Access.WRITE_ONLY)
    private BigDecimal idKorisnickogNaloga;
    private String korisnickoIme;
    @JsonProperty(value = "lozinka", access = JsonProperty.Access.WRITE_ONLY)
    private String lozinka;
    private NastavnikDTO nastavnik;
    private StudentDTO student;
    private Collection<Rola> rolaCollection;

    public KorisnickiNalogDTO() {
    }

    public KorisnickiNalogDTO(BigDecimal idKorisnickogNaloga, String korisnickoIme, String lozinka, NastavnikDTO nastavnik, StudentDTO student, Collection<Rola> rolaCollection) {
        this.idKorisnickogNaloga = idKorisnickogNaloga;
        this.korisnickoIme = korisnickoIme;
        this.lozinka = lozinka;
        this.nastavnik = nastavnik;
        this.student = student;
        this.rolaCollection = rolaCollection;
    }

    public BigDecimal getIdKorisnickogNaloga() {
        return idKorisnickogNaloga;
    }

    public void setIdKorisnickogNaloga(BigDecimal idKorisnickogNaloga) {
        this.idKorisnickogNaloga = idKorisnickogNaloga;
    }

    public String getKorisnickoIme() {
        return korisnickoIme;
    }

    public void setKorisnickoIme(String korisnickoIme) {
        this.korisnickoIme = korisnickoIme;
    }

    public String getLozinka() {
        return lozinka;
    }

    public void setLozinka(String lozinka) {
        this.lozinka = lozinka;
    }

    public NastavnikDTO getNastavnik() {
        return nastavnik;
    }

    public void setNastavnik(NastavnikDTO nastavnik) {
        this.nastavnik = nastavnik;
    }

    public StudentDTO getStudent() {
        return student;
    }

    public void setStudent(StudentDTO student) {
        this.student = student;
    }
    
    public Collection<Rola> getRolaCollection() {
        return rolaCollection;
    }

    public void setRolaCollection(Collection<Rola> rolaCollection) {
        this.rolaCollection = rolaCollection;
    }


}
