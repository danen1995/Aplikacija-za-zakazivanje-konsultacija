/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.AppSchSys.dto;

import java.math.BigDecimal;

/**
 *
 * @author Dane
 */
public class SchoolYearDTO {

    private BigDecimal schoolYearId;
    private String schoolYear;
    private String semester;
//    private Collection<PokrivenostNastaveDTO> coverageCollection;
//    private Collection<CalendarDTO> calendarCollection;

    public SchoolYearDTO() {
    }

    public SchoolYearDTO(BigDecimal schoolYearId, String schoolYear, String semester) {
        this.schoolYearId = schoolYearId;
        this.schoolYear = schoolYear;
        this.semester = semester;
    }

    public void setSchoolYearId(BigDecimal schoolYearId) {
        this.schoolYearId = schoolYearId;
    }

    public void setSchoolYear(String schoolYear) {
        this.schoolYear = schoolYear;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }

    public BigDecimal getSchoolYearId() {
        return schoolYearId;
    }

    public String getSchoolYear() {
        return schoolYear;
    }

    public String getSemester() {
        return semester;
    }

}
