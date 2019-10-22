package rs.ac.bg.fon.silab.AppSchSys.security;

import java.math.BigDecimal;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rs.ac.bg.fon.silab.AppSchSys.dto.UserAccountDTO;
import rs.ac.bg.fon.silab.AppSchSys.entities.UserAccount;
import rs.ac.bg.fon.silab.AppSchSys.exception.ResourceNotFoundException;
import rs.ac.bg.fon.silab.AppSchSys.dao.UserAccountDAO;
import rs.ac.bg.fon.silab.AppSchSys.service.UserAccountService;

/**
 * To authenticate a User or perform various role-based checks, Spring security
 * needs to load users details somehow.
 *
 * For this purpose, It consists of an interface called UserDetailsService which
 * has a single method that loads a user based on username-
 *
 * UserDetails loadUserByUsername(String username) throws
 * UsernameNotFoundException; We’ll define a CustomUserDetailsService that
 * implements UserDetailsService interface and provides the implementation for
 * loadUserByUsername() method.
 *
 * Note that, the loadUserByUsername() method returns a UserDetails object that
 * Spring Security uses for performing various authentication and role based
 * validations.
 *
 * In our implementation, We’ll also define a custom UserPrincipal class that
 * will implement UserDetails interface, and return the UserPrincipal object
 * from loadUserByUsername() method.
 */
@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    UserAccountService service;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        // Let people login with either username or email
        //orElseThrow baca NoSuchElemenrException ako vrednost nije prisutna (isPresent)
        UserAccountDTO user = service.findByUserName(username)
                .orElseThrow(()
                        -> new UsernameNotFoundException("User not found with username : " + username)
                );
        return new UserPrincipal().create(user);

    }

    @Transactional
    public UserDetails loadUserById(BigDecimal id) throws Throwable {
        Optional<UserAccountDTO> kndto = service.findByUserAccountId(id);

        UserAccountDTO user = service.findByUserAccountId(id).orElseThrow(
                () -> new ResourceNotFoundException("User", "id", id)
        );
        return new UserPrincipal().create(user);
    }
}
