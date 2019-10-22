/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.AppSchSys.dto;

import java.util.Date;

/**
 *
 * @author Dane
 */
public class CourseDTO extends EventDTO {

    private String courseFunction;
    private SubjectDTO subjectId;

    public CourseDTO() {
    }

    public CourseDTO(String courseFunction, SubjectDTO subjectId, EventPKDTO eventPK, Date startDateTime, Date endDateTime, String place, CalendarDTO calendarDTO, EventTypeDTO eventTypeId) {
        super(eventPK, startDateTime, endDateTime, place, calendarDTO, eventTypeId);
        this.courseFunction = courseFunction;
        this.subjectId = subjectId;
    }

    public String getFUNCTIONNastave() {
        return courseFunction;
    }

    public void setFUNCTIONNastave(String courseFunction) {
        this.courseFunction = courseFunction;
    }

    public SubjectDTO getsubjectId() {
        return subjectId;
    }

    public void setsubjectId(SubjectDTO subjectId) {
        this.subjectId = subjectId;
    }
}
