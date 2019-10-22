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
public class TeacherDTO extends UserDTO {

    private String teacherId;
    private String firstName;
    private String lastName;
    private String email;
    private String telephone;
    private String cabinet;
    private String image;
//    private Collection<PokrivenostNastaveDTO> coverageCollection;
//    private Collection<CalendarDTO> calendarCollection;
//    private Collection<UserAccountDTO> UserAccountCollection;

    public TeacherDTO() {
    }

    public TeacherDTO(String teacherId, String firstName, String lastName, String email, String telephone, String cabinet, String image) {
        this.teacherId = teacherId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.telephone = telephone;
        this.cabinet = cabinet;
        this.image = image;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getCabinet() {
        return cabinet;
    }

    public String getImage() {
        return image;
    }

    public void setTeacherId(String teacherId) {
        this.teacherId = teacherId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public void setCabinet(String cabinet) {
        this.cabinet = cabinet;
    }

    public void setImage(String image) {
        this.image = image;
    }

}
