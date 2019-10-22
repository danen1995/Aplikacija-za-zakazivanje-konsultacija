/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.AppSchSys.dto;

/**
 *
 * @author Dane
 */
public class CoverageDTO {

    private CoveragePKDTO coveragePK;
    private CoveragePKDTO coveragePKDTO;
    private String function;
    private TeacherDTO teacher;
    private SubjectDTO subject;
    private SchoolYearDTO schoolYearId;

    public CoverageDTO() {
    }

    public CoverageDTO(CoveragePKDTO coveragePK, CoveragePKDTO coveragePKDTO, String function, TeacherDTO teacher, SubjectDTO subject, SchoolYearDTO schoolYearId) {
        this.coveragePK = coveragePK;
        this.coveragePKDTO = coveragePKDTO;
        this.function = function;
        this.teacher = teacher;
        this.subject = subject;
        this.schoolYearId = schoolYearId;
    }

    public CoveragePKDTO getCoveragePK() {
        return coveragePK;
    }

    public CoveragePKDTO getCoveragePKDTO() {
        return coveragePKDTO;
    }

    public String getFunction() {
        return function;
    }

    public TeacherDTO getTeacher() {
        return teacher;
    }

    public SubjectDTO getSubject() {
        return subject;
    }

    public SchoolYearDTO getSchoolYearId() {
        return schoolYearId;
    }

    public void setCoveragePK(CoveragePKDTO coveragePK) {
        this.coveragePK = coveragePK;
    }

    public void setCoveragePKDTO(CoveragePKDTO coveragePKDTO) {
        this.coveragePKDTO = coveragePKDTO;
    }

    public void setFunction(String function) {
        this.function = function;
    }

    public void setTeacher(TeacherDTO teacher) {
        this.teacher = teacher;
    }

    public void setSubject(SubjectDTO subject) {
        this.subject = subject;
    }

    public void setSchoolYearId(SchoolYearDTO schoolYearId) {
        this.schoolYearId = schoolYearId;
    }

}
