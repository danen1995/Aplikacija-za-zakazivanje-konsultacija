/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.AppKons.dto;

import java.math.BigDecimal;

/**
 *
 * @author Dane
 */
public class TipDogadjajaDTO {

    private BigDecimal idTipaDogadjaja;
    private String nazivTipaDogadjaja;

//    private Collection<DogadjajDTO> dogadjajCollection;
    public TipDogadjajaDTO() {
    }

    public TipDogadjajaDTO(BigDecimal idTipaDogadjaja, String nazivTipaDogadjaja) {
        this.idTipaDogadjaja = idTipaDogadjaja;
        this.nazivTipaDogadjaja = nazivTipaDogadjaja;
    }

    public BigDecimal getIdTipaDogadjaja() {
        return idTipaDogadjaja;
    }

    public void setIdTipaDogadjaja(BigDecimal idTipaDogadjaja) {
        this.idTipaDogadjaja = idTipaDogadjaja;
    }

    public String getNazivTipaDogadjaja() {
        return nazivTipaDogadjaja;
    }

    public void setNazivTipaDogadjaja(String nazivTipaDogadjaja) {
        this.nazivTipaDogadjaja = nazivTipaDogadjaja;
    }

//    public Collection<DogadjajDTO> getDogadjajCollection() {
//        return dogadjajCollection;
//    }
//
//    public void setDogadjajCollection(Collection<DogadjajDTO> dogadjajCollection) {
//        this.dogadjajCollection = dogadjajCollection;
//    }
}
