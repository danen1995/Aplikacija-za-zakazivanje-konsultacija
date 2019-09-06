package rs.ac.bg.fon.silab.AppKons.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import rs.ac.bg.fon.silab.AppKons.dto.KalendarDTO;
import rs.ac.bg.fon.silab.AppKons.service.KalendarService;

@RestController
@CrossOrigin
@RequestMapping("/kalendar")

public class KalendarRestController {

    @Autowired
    KalendarService service;

 
    @RequestMapping(value = "/zaNastavnika", method = RequestMethod.GET)
    public @ResponseBody
    Object vratiKalendareZaNastavnika(@RequestParam String jmbg) {
        List<KalendarDTO> kalendariDTO = service.vratiKalendareZaNastavnika(jmbg);
        return ResponseEntity.status(HttpStatus.OK).body(kalendariDTO);
    }

}
