/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.AppKons.serviceImpl;

import java.io.IOException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import rs.ac.bg.fon.silab.AppKons.dto.KonsultacijeDTO;
import rs.ac.bg.fon.silab.AppKons.dto.PrilogDTO;
import rs.ac.bg.fon.silab.AppKons.entities.DogadjajPK;
import rs.ac.bg.fon.silab.AppKons.entities.Konsultacije;
import rs.ac.bg.fon.silab.AppKons.entities.Prilog;
import rs.ac.bg.fon.silab.AppKons.mapper.GenericMapper;
import rs.ac.bg.fon.silab.AppKons.dao.KonsultacijeDAO;
import rs.ac.bg.fon.silab.AppKons.dao.PrilogDAO;
import rs.ac.bg.fon.silab.AppKons.entities.StudentKonsultacije;
import rs.ac.bg.fon.silab.AppKons.service.PrilogService;

/**
 *
 * @author Dane
 */
@Service
public class PrilogServiceImpl implements PrilogService {

    @Autowired
    GenericMapper mapper;
    @Autowired
    PrilogDAO repository;

    public Prilog dodajPrilog(MultipartFile file, BigInteger idKalendara, BigInteger idDogadjaja, String brojIndeksa) {
        try {
            Prilog p = new Prilog(file.getOriginalFilename(), file.getBytes(), new StudentKonsultacije(idKalendara, idDogadjaja, brojIndeksa));
            return repository.save(p);

        } catch (Exception ex) {
            System.out.println("Greska u dodaj prilog" + ex.getMessage());
            return null;
        }

    }

    public List<PrilogDTO> findAll() {
        List<Prilog> prilozi = repository.findAll();
        List<PrilogDTO> priloziDTO = new ArrayList<>();
        for (Prilog p : prilozi) {
            priloziDTO.add(mapper.prilogToPrilogDTO(p));
        }
        return priloziDTO;
    }
    
    public Prilog findByStudentKonsultacije(BigInteger idKalendara, BigInteger idDogadjaja, String brojIndeksa){
        return repository.findByStudentKonsultacije(idKalendara, idDogadjaja, brojIndeksa);
    }
    
}
