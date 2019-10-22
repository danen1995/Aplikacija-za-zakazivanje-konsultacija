package rs.ac.bg.fon.silab.AppSchSys.controller.rest;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import rs.ac.bg.fon.silab.AppSchSys.dto.CoverageDTO;
import rs.ac.bg.fon.silab.AppSchSys.service.CoverageService;

@RestController
@RequestMapping("/coverage")
@CrossOrigin

public class CoverageRestController {

    @Autowired
    CoverageService service;

    @RequestMapping("/teacher/{teacherId}")
    public @ResponseBody
    List<CoverageDTO> getCoverageForTeacher(@PathVariable String teacherId) {
        return service.findByTeacherId(teacherId);
    }

}
