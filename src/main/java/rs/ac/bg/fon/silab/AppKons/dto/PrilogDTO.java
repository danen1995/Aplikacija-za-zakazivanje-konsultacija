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
public class PrilogDTO {

    private BigDecimal idPriloga;
    private String naziv;
    private byte[] lokacija;
    private StudentKonsultacijeDTO studentKonsultacije;

    public PrilogDTO() {
    }

    public PrilogDTO(BigDecimal idPriloga, String naziv, byte[] lokacija, StudentKonsultacijeDTO studentKonsultacije) {
        this.idPriloga = idPriloga;
        this.naziv = naziv;
        this.lokacija = lokacija;
        this.studentKonsultacije = studentKonsultacije;
    }

    public BigDecimal getIdPriloga() {
        return idPriloga;
    }

    public void setIdPriloga(BigDecimal idPriloga) {
        this.idPriloga = idPriloga;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public byte[] getLokacija() {
        return lokacija;
    }

    public void setLokacija(byte[] lokacija) {
        this.lokacija = lokacija;
    }

    public StudentKonsultacijeDTO getStudentKonsultacije() {
        return studentKonsultacije;
    }

    public void setStudentKonsultacije(StudentKonsultacijeDTO studentKonsultacije) {
        this.studentKonsultacije = studentKonsultacije;
    }

}
