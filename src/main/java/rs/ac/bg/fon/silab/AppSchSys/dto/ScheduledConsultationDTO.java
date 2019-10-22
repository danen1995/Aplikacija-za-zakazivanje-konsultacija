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
public class ScheduledConsultationDTO {

    private ScheduledConsultationPKDTO studentConsultationPK;
    private String status;
    private String title;
    private String description;
//    private Collection<PrilogDTO> attachmentCollection;
    private ConsultationDTO Consultation;
    private StudentDTO student;

    public ScheduledConsultationDTO() {
    }

    public ScheduledConsultationDTO(ScheduledConsultationPKDTO studentConsultationPK, String status, String title, String description, ConsultationDTO Consultation, StudentDTO student) {
        this.studentConsultationPK = studentConsultationPK;
        this.status = status;
        this.title = title;
        this.description = description;
        this.Consultation = Consultation;
        this.student = student;
    }

    public ScheduledConsultationPKDTO getStudentConsultationPK() {
        return studentConsultationPK;
    }

    public String getStatus() {
        return status;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public ConsultationDTO getConsultation() {
        return Consultation;
    }

    public StudentDTO getStudent() {
        return student;
    }

    public void setStudentConsultationPK(ScheduledConsultationPKDTO studentConsultationPK) {
        this.studentConsultationPK = studentConsultationPK;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setConsultation(ConsultationDTO Consultation) {
        this.Consultation = Consultation;
    }

    public void setStudent(StudentDTO student) {
        this.student = student;
    }

}
