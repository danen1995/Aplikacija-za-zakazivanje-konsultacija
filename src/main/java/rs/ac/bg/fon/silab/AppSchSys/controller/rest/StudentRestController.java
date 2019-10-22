 package rs.ac.bg.fon.silab.AppSchSys.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import rs.ac.bg.fon.silab.AppSchSys.dto.StudentDTO;
import rs.ac.bg.fon.silab.AppSchSys.entities.Student;
import rs.ac.bg.fon.silab.AppSchSys.service.StudentService;

@RestController
@RequestMapping("/student")
@CrossOrigin

public class StudentRestController {

    @Autowired
    StudentService service;

    @GetMapping("/all")
    public @ResponseBody
    List<Student> findAll() {
        return service.findAll();
    }

    @GetMapping("/get")
    public @ResponseBody
    StudentDTO findByIndexNumber(@RequestParam(value = "indexNumber") String indexNumber) {
        return service.findByIndexNumber(indexNumber);
    }

}
