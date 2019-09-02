package rs.ac.bg.fon.silab.AppKons.controller.rest;

import java.awt.MediaTracker;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigInteger;
import java.util.List;
import javafx.scene.media.Media;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import rs.ac.bg.fon.silab.AppKons.dto.PrilogDTO;
import rs.ac.bg.fon.silab.AppKons.entities.Prilog;
import rs.ac.bg.fon.silab.AppKons.service.PrilogService;
import rs.ac.bg.fon.silab.AppKons.serviceImpl.PrilogServiceImpl;

@RestController
@RequestMapping("/prilog")
@CrossOrigin
public class PrilogRestController {

    @Autowired
    PrilogService service;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    @CrossOrigin
    public @ResponseBody
    Object dodajPrilog(@RequestParam MultipartFile file, @RequestParam BigInteger idKalendara, @RequestParam BigInteger idDogadjaja, @RequestParam String brojIndeksa) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(service.dodajPrilog(file, idKalendara, idDogadjaja, brojIndeksa));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Greska.");
        }
    }

    @RequestMapping(value = "/upload", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    @CrossOrigin
    public ResponseEntity<Object> uploadFile(@RequestParam MultipartFile file2, @RequestParam String nazivFajla) throws IOException {
        File convertFile = new File("D:\\Desktop\\Diplomski rad\\Front end - Oracle JET\\Oracle JET Aplikacija\\Oracle JET - AppKons\\prilozi\\" + nazivFajla + " - " + file2.getOriginalFilename());
        convertFile.createNewFile();
        FileOutputStream fout = new FileOutputStream(convertFile);
        fout.write(file2.getBytes());
        fout.close();
        return new ResponseEntity<>("Prilog je uspesno postavljen", HttpStatus.OK);

    }

    @RequestMapping(value = "/download", method = RequestMethod.GET)
    public ResponseEntity<Object> download(@RequestParam BigInteger idKalendara, @RequestParam BigInteger idDogadjaja, @RequestParam String brojIndeksa) throws IOException {
        Prilog prilog = service.findByStudentKonsultacije(idKalendara, idDogadjaja, brojIndeksa);
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + prilog.getNaziv()+ "\"").body(new ByteArrayResource(prilog.getLokacija()));
    }

    @GetMapping("/sve")
    public @ResponseBody
    Object sviPrilozi() {
        List<PrilogDTO> sviPrilozi = service.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(sviPrilozi);
    }

}
