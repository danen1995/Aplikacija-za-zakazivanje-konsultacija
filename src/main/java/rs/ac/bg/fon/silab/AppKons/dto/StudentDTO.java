/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.AppKons.dto;

/**
 *
 * @author Dane
 */
public class StudentDTO extends UserDTO {

    private String brojIndeksa;
    private String ime;
    private String prezime;
    private Short godinaUpisa;
    private String smer;
    private String brojTelefona;
    private String email;
//    private Collection<StudentKonsultacijeDTO> studentKonsultacijeCollection;
//    private Collection<KorisnickiNalogDTO> korisnickiNalogCollection;

    public StudentDTO() {
    }

    public StudentDTO(String brojIndeksa, String ime, String prezime, Short godinaUpisa, String smer, String brojTelefona, String email) {
        this.brojIndeksa = brojIndeksa;
        this.ime = ime;
        this.prezime = prezime;
        this.godinaUpisa = godinaUpisa;
        this.smer = smer;
        this.brojTelefona = brojTelefona;
        this.email = email;
    }

    public String getBrojIndeksa() {
        return brojIndeksa;
    }

    public void setBrojIndeksa(String brojIndeksa) {
        this.brojIndeksa = brojIndeksa;
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

    public Short getGodinaUpisa() {
        return godinaUpisa;
    }

    public void setGodinaUpisa(Short godinaUpisa) {
        this.godinaUpisa = godinaUpisa;
    }

    public String getSmer() {
        return smer;
    }

    public void setSmer(String smer) {
        this.smer = smer;
    }

    public String getBrojTelefona() {
        return brojTelefona;
    }

    public void setBrojTelefona(String brojTelefona) {
        this.brojTelefona = brojTelefona;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
//
//    public Collection<StudentKonsultacijeDTO> getStudentKonsultacijeCollection() {
//        return studentKonsultacijeCollection;
//    }
//
//    public void setStudentKonsultacijeCollection(Collection<StudentKonsultacijeDTO> studentKonsultacijeCollection) {
//        this.studentKonsultacijeCollection = studentKonsultacijeCollection;
//    }
//
//    public Collection<KorisnickiNalogDTO> getKorisnickiNalogCollection() {
//        return korisnickiNalogCollection;
//    }
//
//    public void setKorisnickiNalogCollection(Collection<KorisnickiNalogDTO> korisnickiNalogCollection) {
//        this.korisnickiNalogCollection = korisnickiNalogCollection;
//    }

}
