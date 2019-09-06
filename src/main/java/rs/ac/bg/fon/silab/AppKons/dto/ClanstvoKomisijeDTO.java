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
public class ClanstvoKomisijeDTO extends DogadjajDTO {

    private String nivo;
    private String uloga;
    private String kandidat;
    private String tema;

    public ClanstvoKomisijeDTO() {
    }

    public ClanstvoKomisijeDTO(String nivo, String uloga, String kandidat, String tema, DogadjajPKDTO dogadjajPK, Date datumIVremePocetka, Date datumIVremeZavrsetka, String mestoOdrzavanja, KalendarDTO kalendar, TipDogadjajaDTO idTipaDogadjaja) {
        super(dogadjajPK, datumIVremePocetka, datumIVremeZavrsetka, mestoOdrzavanja, kalendar, idTipaDogadjaja);
        this.nivo = nivo;
        this.uloga = uloga;
        this.kandidat = kandidat;
        this.tema = tema;
    }

    public String getNivo() {
        return nivo;
    }

    public void setNivo(String nivo) {
        this.nivo = nivo;
    }

    public String getUloga() {
        return uloga;
    }

    public void setUloga(String uloga) {
        this.uloga = uloga;
    }

    public String getKandidat() {
        return kandidat;
    }

    public void setKandidat(String kandidat) {
        this.kandidat = kandidat;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }
}
