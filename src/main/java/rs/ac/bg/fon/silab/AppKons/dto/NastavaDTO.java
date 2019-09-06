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
public class NastavaDTO extends DogadjajDTO {

    private String ulogaNastave;
    private PredmetDTO idPredmeta;
    public NastavaDTO() {
    }

    public NastavaDTO(String ulogaNastave, PredmetDTO idPredmeta, DogadjajPKDTO dogadjajPK, Date datumIVremePocetka, Date datumIVremeZavrsetka, String mestoOdrzavanja, KalendarDTO kalendar, TipDogadjajaDTO idTipaDogadjaja) {
        super(dogadjajPK, datumIVremePocetka, datumIVremeZavrsetka, mestoOdrzavanja, kalendar, idTipaDogadjaja);
        this.ulogaNastave = ulogaNastave;
        this.idPredmeta = idPredmeta;
    }

    public String getUlogaNastave() {
        return ulogaNastave;
    }

    public void setUlogaNastave(String ulogaNastave) {
        this.ulogaNastave = ulogaNastave;
    }

    public PredmetDTO getIdPredmeta() {
        return idPredmeta;
    }

    public void setIdPredmeta(PredmetDTO idPredmeta) {
        this.idPredmeta = idPredmeta;
    }
}
