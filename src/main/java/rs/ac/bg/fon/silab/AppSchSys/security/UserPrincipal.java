package rs.ac.bg.fon.silab.AppSchSys.security;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.math.BigDecimal;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import rs.ac.bg.fon.silab.AppSchSys.dto.UserAccountDTO;
import rs.ac.bg.fon.silab.AppSchSys.dto.TeacherDTO;
import rs.ac.bg.fon.silab.AppSchSys.dto.StudentDTO;
import rs.ac.bg.fon.silab.AppSchSys.dto.TeacherDTO;
import rs.ac.bg.fon.silab.AppSchSys.entities.UserAccount;
import rs.ac.bg.fon.silab.AppSchSys.entities.Teacher;
import rs.ac.bg.fon.silab.AppSchSys.entities.Role;
import rs.ac.bg.fon.silab.AppSchSys.entities.Student;
import rs.ac.bg.fon.silab.AppSchSys.mapper.GenericMapper;

/**
 * Next, Let’s define our custom UserDetails class called UserPrincipal. This is
 * the class whose instances will be returned from our custom
 * UserDetailsService. Spring Security will use the information stored in the
 * UserPrincipal object to perform authentication and authorization.
 *
 * Here is the complete UserPrincipal class -
 */
public class UserPrincipal implements UserDetails {

    private BigDecimal id;
    private String username;
    @JsonIgnore
    private String password;
    private TeacherDTO teacherDTO;
    private StudentDTO studentDTO;

    private Collection<? extends GrantedAuthority> authorities;

    public UserPrincipal() {
    }

    public UserPrincipal(BigDecimal id, String username, String password, Collection<? extends GrantedAuthority> authorities, TeacherDTO teacherDTO, StudentDTO studentDTO) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.authorities = authorities;
        this.teacherDTO = teacherDTO;
        this.studentDTO = studentDTO;
    }

    public UserPrincipal create(UserAccountDTO user) {

        List<GrantedAuthority> authorities = user.getRolеCollection().stream().map(role
                -> new SimpleGrantedAuthority(((Role) role).getRoleName())
        ).collect(Collectors.toList());

        return new UserPrincipal(
                user.getUserAccountId(),
                user.getUserName(),
                user.getPassword(),
                authorities,
                user.getTeacher(),
                user.getStudent()
        );
    }

    public BigDecimal getId() {
        return id;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        UserPrincipal that = (UserPrincipal) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    public TeacherDTO getTeacher() {
        return teacherDTO;
    }

    public StudentDTO getStudent() {
        return studentDTO;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setTeacher(TeacherDTO teacherDTO) {
        this.teacherDTO = teacherDTO;
    }

    public void setStudent(StudentDTO studentDTO) {
        this.studentDTO = studentDTO;
    }

    public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
        this.authorities = authorities;
    }

}
