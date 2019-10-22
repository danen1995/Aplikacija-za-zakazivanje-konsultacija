package rs.ac.bg.fon.silab.AppSchSys.controller.rest;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import rs.ac.bg.fon.silab.AppSchSys.dto.TeacherDTO;
import rs.ac.bg.fon.silab.AppSchSys.service.TeacherService;

@RestController
@RequestMapping("/teacher")
@CrossOrigin
public class TeacherRestController {

    @Autowired
    TeacherService service;

    @GetMapping("/getAll")
    public @ResponseBody
    Object getAll() {
        List<TeacherDTO> allTeachers = service.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(allTeachers);
    }

    @GetMapping("/get")
    public @ResponseBody
    TeacherDTO get(@RequestParam(value = "teacherId") String teacherId) {
        return service.findById(teacherId);
    }

}
