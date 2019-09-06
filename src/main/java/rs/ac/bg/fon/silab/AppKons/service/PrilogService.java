/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.AppKons.service;

import java.math.BigInteger;
import java.util.List;
import org.springframework.web.multipart.MultipartFile;
import rs.ac.bg.fon.silab.AppKons.dto.PrilogDTO;
import rs.ac.bg.fon.silab.AppKons.entities.Prilog;

/**
 *
 * @author Dane
 */
public interface PrilogService {

    public Prilog dodajPrilog(MultipartFile file, BigInteger idKalendara, BigInteger idDogadjaja, String brojIndeksa);

    public List<PrilogDTO> findAll();

    public Prilog findByStudentKonsultacije(BigInteger idKalendara, BigInteger idDogadjaja, String brojIndeksa);

}
