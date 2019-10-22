/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.AppSchSys.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;
import java.util.Collection;
import rs.ac.bg.fon.silab.AppSchSys.entities.Role;

/**
 *
 * @author Dane
 */
public class UserAccountDTO {

    @JsonProperty(value = "userAccountId", access = JsonProperty.Access.WRITE_ONLY)
    private BigDecimal userAccountId;
    private String userName;
    @JsonProperty(value = "password", access = JsonProperty.Access.WRITE_ONLY)
    private String password;
    private TeacherDTO teacher;
    private StudentDTO student;
    private Collection<Role> rolеCollection;

    public UserAccountDTO() {
    }

    public UserAccountDTO(BigDecimal userAccountId, String userName, String password, TeacherDTO teacher, StudentDTO student, Collection<Role> rolеCollection) {
        this.userAccountId = userAccountId;
        this.userName = userName;
        this.password = password;
        this.teacher = teacher;
        this.student = student;
        this.rolеCollection = rolеCollection;
    }

    public BigDecimal getUserAccountId() {
        return userAccountId;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public TeacherDTO getTeacher() {
        return teacher;
    }

    public StudentDTO getStudent() {
        return student;
    }

    public Collection<Role> getRolеCollection() {
        return rolеCollection;
    }

    public void setUserAccountId(BigDecimal userAccountId) {
        this.userAccountId = userAccountId;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setTeacher(TeacherDTO teacher) {
        this.teacher = teacher;
    }

    public void setStudent(StudentDTO student) {
        this.student = student;
    }

    public void setRolеCollection(Collection<Role> rolеCollection) {
        this.rolеCollection = rolеCollection;
    }

}
