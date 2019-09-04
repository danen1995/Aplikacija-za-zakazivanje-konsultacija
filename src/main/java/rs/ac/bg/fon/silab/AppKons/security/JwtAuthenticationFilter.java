package rs.ac.bg.fon.silab.AppKons.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.logging.Level;

/**
 * We’ll use JWTAuthenticationFilter to implement a filter that -
 *
 * reads JWT authentication token from the Authorization header of all the
 * requests validates the token loads the user details associated with that
 * token. Sets the user details in Spring Security’s SecurityContext. Spring
 * Security uses the user details to perform authorization checks. We can also
 * access the user details stored in the SecurityContext in our controllers to
 * perform our business logic.
 *
 *
 * Finally, Let’s write the JWTAuthenticationFilter to get the JWT token from
 * the request, validate it, load the user associated with the token, and pass
 * it to Spring Security -
 */
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    @Autowired
    private JwtTokenProvider tokenProvider;

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    private static final Logger logger = LoggerFactory.getLogger(JwtAuthenticationFilter.class);

    /*
    Svaki put kad se identifikuje request prvo se pozove ova metoda - valjda.
        
     */
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        try {
            String jwt = getJwtFromRequest(request);

            if (StringUtils.hasText(jwt) && tokenProvider.validateToken(jwt)) {
                BigDecimal userId = tokenProvider.getUserIdFromJWT(jwt);

                /*
                    Note that you could also encode the user's username and roles inside JWT claims
                    and create the UserDetails object by parsing those claims from the JWT.
                    That would avoid the following database hit. It's completely up to you.
                 */
                UserDetails userDetails = customUserDetailsService.loadUserById(userId);
                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        } catch (Exception ex) {
            logger.error("Could not set user authentication in security context", ex);
        } catch (Throwable ex) {
            java.util.logging.Logger.getLogger(JwtAuthenticationFilter.class.getName()).log(Level.SEVERE, null, ex);
        }

        filterChain.doFilter(request, response);
    }

    private String getJwtFromRequest(HttpServletRequest request) {
        String bearerToken = request.getHeader("Authorization");
        if (StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7, bearerToken.length());
        }
        return null;
    }

    /**
     * In the above filter, We’re first parsing the JWT retrieved from the
     * Authorization header of the request and obtaining the user’s Id. After
     * that, We’re loading the user’s details from the database and setting the
     * authentication inside spring security’s context.
     *
     * Note that, the database hit in the above filter is optional. You could
     * also encode the user’s username and roles inside JWT claims and create
     * the UserDetails object by parsing those claims from the JWT. That would
     * avoid the database hit.
     */
}
