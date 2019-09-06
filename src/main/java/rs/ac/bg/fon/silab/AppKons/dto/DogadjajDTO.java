/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.AppKons.dto;

import java.util.Date;

/**
 *
 * @author Dane
 */
public class DogadjajDTO {

    private DogadjajPKDTO dogadjajPK;
    private Date datumIVremePocetka;
    private Date datumIVremeZavrsetka;
    private String mestoOdrzavanja;
    private KalendarDTO kalendar;
    private TipDogadjajaDTO idTipaDogadjaja;

    public DogadjajDTO() {
    }

    public DogadjajDTO(DogadjajPKDTO dogadjajPK, Date datumIVremePocetka, Date datumIVremeZavrsetka, String mestoOdrzavanja, KalendarDTO kalendar, TipDogadjajaDTO idTipaDogadjaja) {
        this.dogadjajPK = dogadjajPK;
        this.datumIVremePocetka = datumIVremePocetka;
        this.datumIVremeZavrsetka = datumIVremeZavrsetka;
        this.mestoOdrzavanja = mestoOdrzavanja;
        this.kalendar = kalendar;
        this.idTipaDogadjaja = idTipaDogadjaja;
    }

    public DogadjajPKDTO getDogadjajPK() {
        return dogadjajPK;
    }

    public void setDogadjajPK(DogadjajPKDTO dogadjajPK) {
        this.dogadjajPK = dogadjajPK;
    }

    public Date getDatumIVremePocetka() {
        return datumIVremePocetka;
    }

    public void setDatumIVremePocetka(Date datumVremePocetka) {
        this.datumIVremePocetka = datumVremePocetka;
    }

    public Date getDatumIVremeZavrsetka() {
        return datumIVremeZavrsetka;
    }

    public void setDatumIVremeZavrsetka(Date datumIVremeZavrsetka) {
        this.datumIVremeZavrsetka = datumIVremeZavrsetka;
    }

    public String getMestoOdrzavanja() {
        return mestoOdrzavanja;
    }

    public void setMestoOdrzavanja(String mestoOdrzavanja) {
        this.mestoOdrzavanja = mestoOdrzavanja;
    }

    public KalendarDTO getKalendar() {
        return kalendar;
    }

    public void setKalendar(KalendarDTO kalendar) {
        this.kalendar = kalendar;
    }

    public TipDogadjajaDTO getIdTipaDogadjaja() {
        return idTipaDogadjaja;
    }

    public void setIdTipaDogadjaja(TipDogadjajaDTO idTipaDogadjaja) {
        this.idTipaDogadjaja = idTipaDogadjaja;
    }

}
