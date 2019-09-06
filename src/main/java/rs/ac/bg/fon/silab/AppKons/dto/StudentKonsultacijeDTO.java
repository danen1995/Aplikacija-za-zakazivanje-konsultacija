/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.AppKons.dto;


/**
 *
 * @author Dane
 */
public class StudentKonsultacijeDTO {

    private StudentKonsultacijePKDTO studentKonsultacijePK;
    private String status;
    private String naslov;
    private String opis;
//    private Collection<PrilogDTO> prilogCollection;
    private KonsultacijeDTO konsultacije;
    private StudentDTO student;

    public StudentKonsultacijeDTO() {
    }

    public StudentKonsultacijeDTO(StudentKonsultacijePKDTO studentKonsultacijePK, String status, String naslov, String opis, KonsultacijeDTO konsultacije, StudentDTO student) {
        this.studentKonsultacijePK = studentKonsultacijePK;
        this.status = status;
        this.naslov = naslov;
        this.opis = opis;
        this.konsultacije = konsultacije;
        this.student = student;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNaslov() {
        return naslov;
    }

    public void setNaslov(String naslov) {
        this.naslov = naslov;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

//    public Collection<PrilogDTO> getPrilogCollection() {
//        return prilogCollection;
//    }
//
//    public void setPrilogCollection(Collection<PrilogDTO> prilogCollection) {
//        this.prilogCollection = prilogCollection;
//    }
    public KonsultacijeDTO getKonsultacije() {
        return konsultacije;
    }

    public void setKonsultacije(KonsultacijeDTO konsultacije) {
        this.konsultacije = konsultacije;
    }

    public StudentDTO getStudent() {
        return student;
    }

    public void setStudent(StudentDTO student) {
        this.student = student;
    }

    public void setStudentKonsultacijePK(StudentKonsultacijePKDTO studentKonsultacijePK) {
        this.studentKonsultacijePK = studentKonsultacijePK;
    }

    public StudentKonsultacijePKDTO getStudentKonsultacijePK() {
        return studentKonsultacijePK;
    }

}
