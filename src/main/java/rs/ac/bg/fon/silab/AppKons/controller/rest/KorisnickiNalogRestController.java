package rs.ac.bg.fon.silab.AppKons.controller.rest;

import java.math.BigDecimal;
import java.net.URI;
import java.util.Collections;
import java.util.List;
import javax.validation.Valid;
import org.apache.tomcat.util.codec.binary.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import rs.ac.bg.fon.silab.AppKons.dao.KorisnickiNalogDAO;
import rs.ac.bg.fon.silab.AppKons.dao.RolaDAO;
import rs.ac.bg.fon.silab.AppKons.dto.KorisnickiNalogDTO;
import rs.ac.bg.fon.silab.AppKons.dto.NastavnikDTO;
import rs.ac.bg.fon.silab.AppKons.dto.UserDTO;
import rs.ac.bg.fon.silab.AppKons.entities.Rola;
import rs.ac.bg.fon.silab.AppKons.exception.AppException;
import rs.ac.bg.fon.silab.AppKons.mapper.GenericMapper;
import rs.ac.bg.fon.silab.AppKons.payload.ApiResponse;
import rs.ac.bg.fon.silab.AppKons.payload.JwtAuthenticationResponse;
import rs.ac.bg.fon.silab.AppKons.security.CurrentUser;
import rs.ac.bg.fon.silab.AppKons.security.JwtTokenProvider;
import rs.ac.bg.fon.silab.AppKons.security.UserPrincipal;
import rs.ac.bg.fon.silab.AppKons.service.KorisnickiNalogService;
import rs.ac.bg.fon.silab.AppKons.serviceImpl.KorisnickiNalogServiceImpl;

@RestController
@CrossOrigin
@RequestMapping("/api/auth")
public class KorisnickiNalogRestController {

    @Autowired
    GenericMapper mapper;

    @Autowired
    JwtTokenProvider tokenProvider;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    KorisnickiNalogService service;

    @Autowired
    RolaDAO rolaRepository;

    @Autowired
    AuthenticationManager authenticationManager;

    @CrossOrigin
    @RequestMapping(value = "/signin", method = RequestMethod.POST)
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody KorisnickiNalogDTO loginRequest) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getKorisnickoIme(),
                        loginRequest.getLozinka()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = tokenProvider.generateToken(authentication);

        return ResponseEntity.ok(new JwtAuthenticationResponse(jwt));
    }

    @CrossOrigin
    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public ResponseEntity<?> registerUser(@Valid @RequestBody KorisnickiNalogDTO korisnickiNalogDTO) {

        if (service.existsByKorisnickoIme(korisnickiNalogDTO.getKorisnickoIme())) {
            return new ResponseEntity(new ApiResponse(false, "Username is already taken!"),
                    HttpStatus.BAD_REQUEST);
        }

        Rola userRole = rolaRepository.findByNazivRole("ROLE_STUDENT")
                .orElseThrow(() -> new AppException("User Role not set."));
        korisnickiNalogDTO.setRolaCollection(Collections.singleton(userRole));
        korisnickiNalogDTO.setLozinka(passwordEncoder.encode(korisnickiNalogDTO.getLozinka()));

        KorisnickiNalogDTO result = service.registrujSe(korisnickiNalogDTO);

//        URI location = ServletUriComponentsBuilder
//                .fromCurrentContextPath().path("/users/{username}")
//                .buildAndExpand(result.getUsername()).toUri();
        return ResponseEntity.ok(new ApiResponse(true, "User registered successfully"));
//        return ResponseEntity.created(location).body(new ApiResponse(true, "User registered successfully"));
    }

    @RequestMapping(value = "/allAccounts", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    Object findAll() {
        List<KorisnickiNalogDTO> nalozi = service.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(nalozi);
    }

    @RequestMapping(value = "/studentOrProfessorID", method = RequestMethod.GET)
    public String tipUsera(@RequestParam(value = "korID") BigDecimal korID) {
        return service.tipUsera(korID);
    }

    @GetMapping("/user/me")
    @PreAuthorize("hasRole('STUDENT')")
    public KorisnickiNalogDTO getCurrentUser(@CurrentUser UserPrincipal currentUser) {
        return mapper.userPrincipalToKorisnickiNalogDTO(currentUser);
    }
}
