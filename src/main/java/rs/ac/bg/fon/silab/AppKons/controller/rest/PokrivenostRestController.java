package rs.ac.bg.fon.silab.AppKons.controller.rest;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import rs.ac.bg.fon.silab.AppKons.entities.PokrivenostNastave;
import rs.ac.bg.fon.silab.AppKons.service.PokrivenostService;

@RestController
@RequestMapping("/pokrivenost")

public class PokrivenostRestController {

    @Autowired
    PokrivenostService service;

    @RequestMapping("/zaNastavnika/{JMBGNastavnika}")
    public @ResponseBody
    List<PokrivenostNastave> vratiPokrivenostiZaNastavnika(@PathVariable String JMBGNastavnika) {
        return service.findByJmbgNastavnika(JMBGNastavnika);
    }

}
