package rs.ac.bg.fon.silab.AppKons.controller.rest;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import rs.ac.bg.fon.silab.AppKons.dto.KonsultacijeDTO;
import rs.ac.bg.fon.silab.AppKons.service.KonsultacijeService;
import rs.ac.bg.fon.silab.AppKons.serviceImpl.KonsultacijeServiceImpl;

@RestController
@RequestMapping("/konsultacije")
@CrossOrigin
public class KonsultacijeRestController {

    @Autowired
    KonsultacijeService service;

    @GetMapping("/sve")
    public @ResponseBody
    Object vratiSveKonsultacije() {
        List<KonsultacijeDTO> sveKons = service.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(sveKons);
    }

    @GetMapping("/zaNastavnika")
    public @ResponseBody
    Object vratiKonsultacijeZaNastavnika(@RequestParam(value = "JMBGNastavnika") String JMBGNastavnika) {
        List<KonsultacijeDTO> konsZaNastavnika = service.vratiKonsultacijeZaNastavnika(JMBGNastavnika);
        return ResponseEntity.status(HttpStatus.OK).body(konsZaNastavnika);
    }

    @GetMapping("/zaNastavnikovKalendar")
    public @ResponseBody
    Object vratiKonsultacijeZaNastavnikovKalendar(@RequestParam(value = "jmbg") String jmbg, @RequestParam(value = "idKalendara") BigDecimal idKalendara) {
        List<KonsultacijeDTO> konsZaNastavnika = service.vratiKonsultacijeZaNastavnikovKalendar(jmbg, idKalendara);
        return ResponseEntity.status(HttpStatus.OK).body(konsZaNastavnika);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @CrossOrigin
    public @ResponseBody
    Object generisiKonsultacije(@RequestBody KonsultacijeDTO konsultacije) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.generisiKonsultacije(konsultacije));
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Greska.");
        }
    }

    @RequestMapping(value = "/ispis", method = RequestMethod.GET)
    @CrossOrigin
    public @ResponseBody
    Object generisiListuKonsultacija(@RequestParam Integer dan,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date datumOd,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date datumDo
    //            @RequestParam @DateTimeFormat(pattern = "'T'HH:mm:ss") Time vremePocetka,
    //            @RequestParam @DateTimeFormat(pattern = "'T'HH:mm:ss") Time vremeZavrsetka
    ) {
        try {
            List<String> lista = new ArrayList<>();
            Calendar start = Calendar.getInstance();
            start.setTime(datumOd);
            Calendar end = Calendar.getInstance();
            end.setTime(datumDo);
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            for (Date date = start.getTime(); start.before(end); start.add(Calendar.DATE, 1), date = start.getTime()) {
                System.out.println(date);
                System.out.println(date.getDay());
                if (date.getDay() == dan) {
                    lista.add(df.format(date));
                }
            }
            return ResponseEntity.status(HttpStatus.OK).body(lista);

        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Greska.");
        }
    }

    @RequestMapping(value = "izbrisi", method = RequestMethod.DELETE)
    public void izbrisiKonsultacije(@RequestParam BigInteger idKalendara, @RequestParam BigInteger idDogadjaja) {
        service.otkaziKonsultacije(idKalendara, idDogadjaja);
    }
}
