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
public class CoveragePKDTO {

    private String teacherId;
    private BigInteger subjectId;

    public CoveragePKDTO() {
    }

    public CoveragePKDTO(String teacherId, BigInteger subjectId) {
        this.teacherId = teacherId;
        this.subjectId = subjectId;
    }

    public BigInteger getsubjectId() {
        return subjectId;
    }

    public String getteacherId() {
        return teacherId;
    }

    public void setsubjectId(BigInteger subjectId) {
        this.subjectId = subjectId;
    }

    public void setteacherId(String teacherId) {
        this.teacherId = teacherId;
    }

}
