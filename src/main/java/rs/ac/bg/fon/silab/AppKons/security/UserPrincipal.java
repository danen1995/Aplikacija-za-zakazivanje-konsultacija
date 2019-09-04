package rs.ac.bg.fon.silab.AppKons.security;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.math.BigDecimal;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import rs.ac.bg.fon.silab.AppKons.dto.KorisnickiNalogDTO;
import rs.ac.bg.fon.silab.AppKons.dto.NastavnikDTO;
import rs.ac.bg.fon.silab.AppKons.dto.StudentDTO;
import rs.ac.bg.fon.silab.AppKons.entities.KorisnickiNalog;
import rs.ac.bg.fon.silab.AppKons.entities.Nastavnik;
import rs.ac.bg.fon.silab.AppKons.entities.Student;

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
    private NastavnikDTO nastavnik;
    private StudentDTO student;

    private Collection<? extends GrantedAuthority> authorities;

    public UserPrincipal(BigDecimal id, String username, String password, Collection<? extends GrantedAuthority> authorities, NastavnikDTO nastavnik, StudentDTO student) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.authorities = authorities;
        this.nastavnik = nastavnik;
        this.student = student;
    }

    public static UserPrincipal create(KorisnickiNalogDTO user) {
        List<GrantedAuthority> authorities = user.getRolaCollection().stream().map(role
                -> new SimpleGrantedAuthority(role.getNazivRole())
        ).collect(Collectors.toList());

        return new UserPrincipal(
                user.getIdKorisnickogNaloga(),
                user.getKorisnickoIme(),
                user.getLozinka(),
                authorities,
                user.getNastavnik(),
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

    public NastavnikDTO getNastavnik() {
        return nastavnik;
    }

    public StudentDTO getStudent() {
        return student;
    }

}
