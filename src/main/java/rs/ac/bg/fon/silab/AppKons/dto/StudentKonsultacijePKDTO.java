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
public class StudentKonsultacijePKDTO {

    private BigInteger idKalendara;
    private BigInteger idDogadjaja;
    private String brojIndeksaStudenta;

    public String getBrojIndeksaStudenta() {
        return brojIndeksaStudenta;
    }

    public void setBrojIndeksaStudenta(String brojIndeksaStudenta) {
        this.brojIndeksaStudenta = brojIndeksaStudenta;
    }

    public void setIdKalendara(BigInteger idKalendara) {
        this.idKalendara = idKalendara;
    }

    public void setIdDogadjaja(BigInteger idDogadjaja) {
        this.idDogadjaja = idDogadjaja;
    }

    public BigInteger getIdKalendara() {
        return idKalendara;
    }

    public BigInteger getIdDogadjaja() {
        return idDogadjaja;
    }

    public StudentKonsultacijePKDTO(BigInteger idKalendara, BigInteger idDogadjaja, String brojIndeksaStudenta) {
        this.idKalendara = idKalendara;
        this.idDogadjaja = idDogadjaja;
        this.brojIndeksaStudenta = brojIndeksaStudenta;
    }

    public StudentKonsultacijePKDTO() {
    }

}
