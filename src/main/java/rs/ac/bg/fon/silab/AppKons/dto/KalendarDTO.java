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
public class KalendarDTO {

    private BigDecimal idKalendara;
    private NastavnikDTO nastavnik;
    private SkolskaGodinaDTO idSkolskeGodine;
//    private Collection<DogadjajDTO> dogadjajCollection;

    public KalendarDTO() {
    }

    public KalendarDTO(BigDecimal idKalendara, NastavnikDTO nastavnik, SkolskaGodinaDTO idSkolskeGodine) {
        this.idKalendara = idKalendara;
        this.nastavnik = nastavnik;
        this.idSkolskeGodine = idSkolskeGodine;
    }

    public BigDecimal getIdKalendara() {
        return idKalendara;
    }

    public void setIdKalendara(BigDecimal idKalendara) {
        this.idKalendara = idKalendara;
    }

    public NastavnikDTO getNastavnik() {
        return nastavnik;
    }

    public void setNastavnik(NastavnikDTO nastavnik) {
        this.nastavnik = nastavnik;
    }

    public SkolskaGodinaDTO getIdSkolskeGodine() {
        return idSkolskeGodine;
    }

    public void setIdSkolskeGodine(SkolskaGodinaDTO idSkolskeGodine) {
        this.idSkolskeGodine = idSkolskeGodine;
    }

//    public Collection<DogadjajDTO> getDogadjajCollection() {
//        return dogadjajCollection;
//    }
//
//    public void setDogadjajCollection(Collection<DogadjajDTO> dogadjajCollection) {
//        this.dogadjajCollection = dogadjajCollection;
//    }
}
