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
public class PokrivenostNastavePKDTO {

    private String jmbgNastavnika;
    private BigInteger idPredmeta;

    public PokrivenostNastavePKDTO() {
    }

    public PokrivenostNastavePKDTO(String jmbgNastavnika, BigInteger idPredmeta) {
        this.jmbgNastavnika = jmbgNastavnika;
        this.idPredmeta = idPredmeta;
    }

    public BigInteger getIdPredmeta() {
        return idPredmeta;
    }

    public String getJmbgNastavnika() {
        return jmbgNastavnika;
    }

    public void setIdPredmeta(BigInteger idPredmeta) {
        this.idPredmeta = idPredmeta;
    }

    public void setJmbgNastavnika(String jmbgNastavnika) {
        this.jmbgNastavnika = jmbgNastavnika;
    }

}
