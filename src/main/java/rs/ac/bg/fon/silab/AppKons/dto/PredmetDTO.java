/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.AppKons.dto;

import java.math.BigInteger;

/**
 *
 * @author Dane
 */
public class PredmetDTO {

    private String naziv;
    private BigInteger espbBodovi;
    private String godinaStudija;
//    private List<PokrivenostNastaveDTO> pokrivenostNastaveCollection;
//    private Collection<NastavaDTO> nastavaCollection;

    public PredmetDTO() {
    }

    public PredmetDTO(String naziv, BigInteger espbBodovi, String godinaStudija) {
        this.naziv = naziv;
        this.espbBodovi = espbBodovi;
        this.godinaStudija = godinaStudija;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public BigInteger getEspbBodovi() {
        return espbBodovi;
    }

    public void setEspbBodovi(BigInteger espbBodovi) {
        this.espbBodovi = espbBodovi;
    }

    public String getGodinaStudija() {
        return godinaStudija;
    }

    public void setGodinaStudija(String godinaStudija) {
        this.godinaStudija = godinaStudija;
    }

//    public Collection<PokrivenostNastaveDTO> getPokrivenostNastaveCollection() {
//        return pokrivenostNastaveCollection;
//    }
//
//    public void setPokrivenostNastaveCollection(List<PokrivenostNastaveDTO> pokrivenostNastaveCollection) {
//        this.pokrivenostNastaveCollection = pokrivenostNastaveCollection;
//    }
//
//    public Collection<NastavaDTO> getDogadjajCollection() {
//        return nastavaCollection;
//    }
//
//    public void setDogadjajCollection(Collection<NastavaDTO> dogadjajCollection) {
//        this.nastavaCollection = dogadjajCollection;
//    }
}
