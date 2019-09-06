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
public class NastavnikDTO extends UserDTO{

    private String jmbg;
    private String ime;
    private String prezime;
    private String email;
    private String brojTelefona;
    private String kabinet;
    private String slika;
//    private Collection<PokrivenostNastaveDTO> pokrivenostNastaveCollection;
//    private Collection<KalendarDTO> kalendarCollection;
//    private Collection<KorisnickiNalogDTO> korisnickiNalogCollection;

    public NastavnikDTO() {
    }

    public NastavnikDTO(String jmbg, String ime, String prezime, String email, String brojTelefona, String kabinet, String slika) {
        this.jmbg = jmbg;
        this.ime = ime;
        this.prezime = prezime;
        this.email = email;
        this.brojTelefona = brojTelefona;
        this.kabinet = kabinet;
        this.slika = slika;
    }

    public String getSlika() {
        return slika;
    }

    public void setSlika(String slika) {
        this.slika = slika;
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

    public void setKabinet(String kabinet) {
        this.kabinet = kabinet;
    }

//    public Collection<PokrivenostNastaveDTO> getPokrivenostNastaveCollection() {
//        return pokrivenostNastaveCollection;
//    }
//
//    public void setPokrivenostNastaveCollection(Collection<PokrivenostNastaveDTO> pokrivenostNastaveCollection) {
//        this.pokrivenostNastaveCollection = pokrivenostNastaveCollection;
//    }
//
//    public Collection<KalendarDTO> getKalendarCollection() {
//        return kalendarCollection;
//    }
//
//    public void setKalendarCollection(Collection<KalendarDTO> kalendarCollection) {
//        this.kalendarCollection = kalendarCollection;
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
