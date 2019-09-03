package rs.ac.bg.fon.silab.AppKons.security;

import java.math.BigDecimal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import rs.ac.bg.fon.silab.AppKons.dao.KorisnickiNalogDAO;
import rs.ac.bg.fon.silab.AppKons.entities.KorisnickiNalog;
import rs.ac.bg.fon.silab.AppKons.exception.ResourceNotFoundException;

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
    KorisnickiNalogDAO userRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
        // Let people login with either username or email
        KorisnickiNalog user = userRepository.findByKorisnickoIme(username)
                .orElseThrow(()
                        -> new UsernameNotFoundException("User not found with username : " + username)
                );
        System.out.println("loadUserByUsername "+ user.getRolaCollection().size());
        return UserPrincipal.create(user);
    }

    @Transactional
    public UserDetails loadUserById(BigDecimal id) throws Throwable {
        KorisnickiNalog user = userRepository.nadjiPoIdu(id).orElseThrow(
                () -> new ResourceNotFoundException("User", "id", id)
        );
        System.out.println("loadUserById" + user.getRolaCollection().size());

        return UserPrincipal.create(user);
    }
}
