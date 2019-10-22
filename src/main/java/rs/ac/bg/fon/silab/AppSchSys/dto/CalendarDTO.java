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
public class CalendarDTO {

    private BigDecimal calendarId;
    private TeacherDTO teacherDTO;
    private SchoolYearDTO schoolYearId;
//    private Collection<DogadjajDTO> eventCollection;

    public CalendarDTO() {
    }

    public CalendarDTO(BigDecimal calendarId, TeacherDTO teacherDTO, SchoolYearDTO schoolYearId) {
        this.calendarId = calendarId;
        this.teacherDTO = teacherDTO;
        this.schoolYearId = schoolYearId;
    }

    public BigDecimal getCalendarId() {
        return calendarId;
    }

    public TeacherDTO getTeacherDTO() {
        return teacherDTO;
    }

    public SchoolYearDTO getSchoolYearId() {
        return schoolYearId;
    }

    public void setCalendarId(BigDecimal calendarId) {
        this.calendarId = calendarId;
    }

    public void setTeacherDTO(TeacherDTO teacherDTO) {
        this.teacherDTO = teacherDTO;
    }

    public void setSchoolYearId(SchoolYearDTO schoolYearId) {
        this.schoolYearId = schoolYearId;
    }

}
