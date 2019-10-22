/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.AppSchSys.dto;

import java.math.BigInteger;

/**
 *
 * @author Dane
 */
public class SubjectDTO {

    private String name;
    private BigInteger espb;
    private String yearOfStudies;
//    private List<PokrivenostNastaveDTO> coverageCollection;
//    private Collection<NastavaDTO> nastavaCollection;

    public SubjectDTO() {
    }

    public SubjectDTO(String name, BigInteger espb, String yearOfStudies) {
        this.name = name;
        this.espb = espb;
        this.yearOfStudies = yearOfStudies;
    }

    public String getName() {
        return name;
    }

    public BigInteger getEspb() {
        return espb;
    }

    public String getYearOfStudies() {
        return yearOfStudies;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEspb(BigInteger espb) {
        this.espb = espb;
    }

    public void setYearOfStudies(String yearOfStudies) {
        this.yearOfStudies = yearOfStudies;
    }

  
}
