package rs.ac.bg.fon.silab.AppSchSys.controller.rest;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import rs.ac.bg.fon.silab.AppSchSys.dto.UserAccountDTO;
import rs.ac.bg.fon.silab.AppSchSys.entities.Role;
import rs.ac.bg.fon.silab.AppSchSys.exception.AppException;
import rs.ac.bg.fon.silab.AppSchSys.mapper.GenericMapper;
import rs.ac.bg.fon.silab.AppSchSys.payload.ApiResponse;
import rs.ac.bg.fon.silab.AppSchSys.payload.JwtAuthenticationResponse;
import rs.ac.bg.fon.silab.AppSchSys.security.CurrentUser;
import rs.ac.bg.fon.silab.AppSchSys.security.JwtTokenProvider;
import rs.ac.bg.fon.silab.AppSchSys.security.UserPrincipal;
import rs.ac.bg.fon.silab.AppSchSys.service.StudentService;
import rs.ac.bg.fon.silab.AppSchSys.dao.RoleDAO;
import rs.ac.bg.fon.silab.AppSchSys.service.UserAccountService;
import rs.ac.bg.fon.silab.AppSchSys.service.TeacherService;

@RestController
@CrossOrigin
@RequestMapping("/api/auth")
public class UserAccountRestController {

    @Autowired
    GenericMapper mapper;

    @Autowired
    JwtTokenProvider tokenProvider;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    UserAccountService service;

    @Autowired
    RoleDAO roleRepository;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    TeacherService teacherService;

    @Autowired
    StudentService studentService;

    @CrossOrigin
    @RequestMapping(value = "/signin", method = RequestMethod.POST)
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody UserAccountDTO loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUserName(),
                        loginRequest.getPassword()
                )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = tokenProvider.generateToken(authentication);
        return ResponseEntity.ok(new JwtAuthenticationResponse(jwt));
    }

    @CrossOrigin
    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public ResponseEntity<?> registerUser(@Valid @RequestBody UserAccountDTO userAccountDTO) {
        if (service.existsByUserName(userAccountDTO.getUserName())) {
            return new ResponseEntity(new ApiResponse(false, "Username is already taken!"),
                    HttpStatus.BAD_REQUEST);
        }
        if (service.studentAlreadyRegistered(userAccountDTO.getStudent().getIndexNumber())) {
            return new ResponseEntity(new ApiResponse(false, "Student already registered! Please log in!"),
                    HttpStatus.BAD_REQUEST);
        }

        Role userRole = roleRepository.findByRoleName("ROLE_STUDENT")
                .orElseThrow(() -> new AppException("User Role not set."));
        userAccountDTO.setRolеCollection(Collections.singleton(userRole));
        userAccountDTO.setPassword(passwordEncoder.encode(userAccountDTO.getPassword()));
        UserAccountDTO result = service.registrujSe(userAccountDTO);
        return ResponseEntity.ok(new ApiResponse(true, "User registered successfully"));
//        URI location = ServletUriComponentsBuilder
//                .fromCurrentContextPath().path("/users/{username}")
//                .buildAndExpand(result.getUsername()).toUri();
//        return ResponseEntity.created(location).body(new ApiResponse(true, "User registered successfully"));
    }

    @RequestMapping(value = "/allAccounts", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    Object findAll() {
        List<UserAccountDTO> nalozi = service.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(nalozi);
    }

    @RequestMapping(value = "/studentOrProfessorID", method = RequestMethod.GET)
    public String userType(@RequestParam(value = "userAccountId") BigDecimal userAccountId) {
        return service.userType(userAccountId);
    }

//    @GetMapping("/user/me")
//    @PreAuthorize("hasRole('STUDENT')")
//    public UserAccountDTO getCurrentUser(@CurrentUser UserPrincipal currentUser) {
//        return new UserAccountDTO(currentUser.getId(), currentUser.getUsername(), currentUser.getPassword(), currentUser.getteacher(), currentUser.getStudent(), mapper.grantedAuthoritiesToROLEs(currentUser.getAuthorities()));
//    }
    @GetMapping("/user/me")
    public @ResponseBody
    Object getUserProfile(@CurrentUser UserPrincipal currentUser) {
        for (GrantedAuthority permission : currentUser.getAuthorities()) {
            if (permission.getAuthority().equals("ROLE_STUDENT")) {
                return ResponseEntity.status(HttpStatus.OK).body(studentService.findByIndexNumber(currentUser.getStudent().getIndexNumber()));
            }
            if (permission.getAuthority().equals("ROLE_TEACHER")) {
                return ResponseEntity.status(HttpStatus.OK).body(teacherService.findById(currentUser.getTeacher().getTeacherId()));
            }
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Doslo je do greske. Nalogu nije dodeljen student ili teacher.");
    }
}
