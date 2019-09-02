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
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import rs.ac.bg.fon.silab.AppKons.dao.KorisnickiNalogDAO;
import rs.ac.bg.fon.silab.AppKons.dto.KorisnickiNalogDTO;
import rs.ac.bg.fon.silab.AppKons.dto.NastavnikDTO;
import rs.ac.bg.fon.silab.AppKons.dto.UserDTO;
import rs.ac.bg.fon.silab.AppKons.entities.KorisnickiNalog;
import rs.ac.bg.fon.silab.AppKons.payload.ApiResponse;
import rs.ac.bg.fon.silab.AppKons.payload.JwtAuthenticationResponse;
import rs.ac.bg.fon.silab.AppKons.security.JwtTokenProvider;
import rs.ac.bg.fon.silab.AppKons.service.KorisnickiNalogService;
import rs.ac.bg.fon.silab.AppKons.serviceImpl.KorisnickiNalogServiceImpl;

@RestController
@CrossOrigin

public class KorisnickiNalogRestController {

    @Autowired
    JwtTokenProvider tokenProvider;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    KorisnickiNalogService service;

    @Autowired
    AuthenticationManager authenticationManager;

//    @CrossOrigin
//    @RequestMapping(value = "/login", method = RequestMethod.POST)
//    public @ResponseBody
//    Object login(@RequestBody KorisnickiNalogDTO user) {
//        try {
//            return ResponseEntity.status(HttpStatus.OK).body(service.authenticate(user));
//        } catch (Exception ex) {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Greska. Ne postoji takav Student/Nastavnik.");
//
//        }
//    }
    @CrossOrigin
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<?> authenticateUser(@RequestBody KorisnickiNalogDTO loginRequest) {

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

//    @CrossOrigin
//    @RequestMapping(value = "/register", method = RequestMethod.POST)
//    public @ResponseBody
//    Object register(@RequestBody KorisnickiNalogDTO user) {
//        try {
//            return service.registrujSe(user);
//        } catch (Exception ex) {
//            System.out.println("Message" + ex.getMessage());
//            if (ex.getMessage().contains("[DIPLOMSKI.KORISNICKI_NALOG_UK1]")) {
//                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Došlo je do greške prilikom registracije. Korisnik sa tim korisnickim imenom vec postoji!");
//            }
//            if (ex.getMessage().contains("[DIPLOMSKI.KORISNICKI_NALOG_UK3]")) {
//                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Došlo je do greške prilikom registracije. Korisnik sa ovim brojem indeksa je vec registrovan.");
//            } else {
//                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Došlo je do greške prilikom registracije. Nepoznata greska! Proverite konekciju.");
//
//            }
//
//        }
//    }
    @CrossOrigin
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseEntity<?> registerUser(@Valid @RequestBody KorisnickiNalogDTO korisnickiNalogDTO) {
        if (service.existsByKorisnickoIme(korisnickiNalogDTO.getKorisnickoIme())) {
            return new ResponseEntity(new ApiResponse(false, "Username is already taken!"),
                    HttpStatus.BAD_REQUEST);
        }

        korisnickiNalogDTO.setLozinka(passwordEncoder.encode(korisnickiNalogDTO.getLozinka()));
//        Role userRole = roleRepository.findByName(RoleName.ROLE_USER)
//                .orElseThrow(() -> new AppException("User Role not set."));
//
//        user.setRoles(Collections.singleton(userRole));
        KorisnickiNalogDTO result = service.registrujSe(korisnickiNalogDTO);

//        URI location = ServletUriComponentsBuilder
//                .fromCurrentContextPath().path("/users/{username}")
//                .buildAndExpand(result.getUsername()).toUri();
        return ResponseEntity.ok(new ApiResponse(true, "Korisnik je uspesno registrovan"));
//        return ResponseEntity.created(location).body(new ApiResponse(true, "User registered successfully"));
    }

    @RequestMapping(value = "/sviNalozi", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    Object findAll() {
        List<KorisnickiNalogDTO> nalozi = service.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(nalozi);
    }

    @RequestMapping(value = "/tipUsera", method = RequestMethod.GET)
    public String tipUsera(@RequestParam(value = "korID") BigDecimal korID) {
        return service.tipUsera(korID);
    }

}
