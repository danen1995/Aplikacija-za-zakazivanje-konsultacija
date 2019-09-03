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
import rs.ac.bg.fon.silab.AppKons.entities.KorisnickiNalog;

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

    private Collection<? extends GrantedAuthority> authorities;

    public UserPrincipal(BigDecimal id, String username, String password, Collection<? extends GrantedAuthority> authorities) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.authorities = authorities;
    }

    public static UserPrincipal create(KorisnickiNalog user) {
        List<GrantedAuthority> authorities = user.getRolaCollection().stream().map(role
                -> new SimpleGrantedAuthority(role.getNazivRole())
        ).collect(Collectors.toList());
        
        System.out.println("DANE123" + authorities.get(0).getAuthority());


        return new UserPrincipal(
                user.getIdKorisnickogNaloga(),
                user.getKorisnickoIme(),
                user.getLozinka(),
                authorities
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
    
    
}
