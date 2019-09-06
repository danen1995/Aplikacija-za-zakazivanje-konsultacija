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
public class PokrivenostNastaveDTO {

    private PokrivenostNastavePKDTO pokrivenostNastavePK;

    private PokrivenostNastavePKDTO pokrivenostNastavePKDTO;
    private String uloga;
    private NastavnikDTO nastavnik;
    private PredmetDTO predmet;
    private SkolskaGodinaDTO idSkolskeGodine;

    public PokrivenostNastaveDTO() {
    }

    public PokrivenostNastaveDTO(PokrivenostNastavePKDTO pokrivenostNastavePK, PokrivenostNastavePKDTO pokrivenostNastavePKDTO, String uloga, NastavnikDTO nastavnik, PredmetDTO predmet, SkolskaGodinaDTO idSkolskeGodine) {
        this.pokrivenostNastavePK = pokrivenostNastavePK;
        this.pokrivenostNastavePKDTO = pokrivenostNastavePKDTO;
        this.uloga = uloga;
        this.nastavnik = nastavnik;
        this.predmet = predmet;
        this.idSkolskeGodine = idSkolskeGodine;
    }

    public String getUloga() {
        return uloga;
    }

    public void setUloga(String uloga) {
        this.uloga = uloga;
    }

    public NastavnikDTO getNastavnik() {
        return nastavnik;
    }

    public void setNastavnik(NastavnikDTO nastavnik) {
        this.nastavnik = nastavnik;
    }

    public PredmetDTO getPredmet() {
        return predmet;
    }

    public void setPredmet(PredmetDTO predmet) {
        this.predmet = predmet;
    }

    public SkolskaGodinaDTO getIdSkolskeGodine() {
        return idSkolskeGodine;
    }

    public void setIdSkolskeGodine(SkolskaGodinaDTO idSkolskeGodine) {
        this.idSkolskeGodine = idSkolskeGodine;
    }

    public PokrivenostNastavePKDTO getPokrivenostNastavePKDTO() {
        return pokrivenostNastavePKDTO;
    }

    public void setPokrivenostNastavePK(PokrivenostNastavePKDTO pokrivenostNastavePK) {
        this.pokrivenostNastavePK = pokrivenostNastavePK;
    }

}
