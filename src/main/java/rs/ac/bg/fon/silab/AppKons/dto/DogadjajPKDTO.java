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
public class DogadjajPKDTO {

    private BigInteger idKalendara;
    private BigInteger idDogadjaja;

    public DogadjajPKDTO() {
    }

    public DogadjajPKDTO(BigInteger idKalendara, BigInteger idDogadjaja) {
        this.idKalendara = idKalendara;
        this.idDogadjaja = idDogadjaja;
    }

    public BigInteger getIdDogadjaja() {
        return idDogadjaja;
    }

    public BigInteger getIdKalendara() {
        return idKalendara;
    }

    public void setIdDogadjaja(BigInteger idDogadjaja) {
        this.idDogadjaja = idDogadjaja;
    }

    public void setIdKalendara(BigInteger idKalendara) {
        this.idKalendara = idKalendara;
    }

}
