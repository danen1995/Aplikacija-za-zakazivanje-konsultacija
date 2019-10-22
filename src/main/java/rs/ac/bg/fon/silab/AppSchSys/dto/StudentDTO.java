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
public class StudentDTO extends UserDTO {

    private String indexNumber;
    private String firstName;
    private String lastName;
    private Short yearOfEntry;
    private String department;
    private String telephone;
    private String email;
//    private Collection<StudentConsultationDTO> studentConsultationCollection;
//    private Collection<UserAccountDTO> UserAccountCollection;

    public StudentDTO() {
    }

    public StudentDTO(String indexNumber, String FIRST_NAME, String LAST_NAME, Short yearOfEntry, String department, String telephone, String email) {
        this.indexNumber = indexNumber;
        this.firstName = FIRST_NAME;
        this.lastName = LAST_NAME;
        this.yearOfEntry = yearOfEntry;
        this.department = department;
        this.telephone = telephone;
        this.email = email;
    }

    public String getIndexNumber() {
        return indexNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Short getYearOfEntry() {
        return yearOfEntry;
    }

    public String getDepartment() {
        return department;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setIndexNumber(String indexNumber) {
        this.indexNumber = indexNumber;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setYearOfEntry(Short yearOfEntry) {
        this.yearOfEntry = yearOfEntry;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
