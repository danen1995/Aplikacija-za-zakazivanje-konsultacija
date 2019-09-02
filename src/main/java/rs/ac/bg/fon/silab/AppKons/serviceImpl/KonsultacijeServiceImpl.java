/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.AppKons.serviceImpl;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.ac.bg.fon.silab.AppKons.dto.KonsultacijeDTO;
import rs.ac.bg.fon.silab.AppKons.entities.DogadjajPK;
import rs.ac.bg.fon.silab.AppKons.entities.Konsultacije;
import rs.ac.bg.fon.silab.AppKons.mapper.GenericMapper;
import rs.ac.bg.fon.silab.AppKons.dao.KonsultacijeDAO;
import rs.ac.bg.fon.silab.AppKons.entities.StudentKonsultacijePK;
import rs.ac.bg.fon.silab.AppKons.service.KalendarService;
import rs.ac.bg.fon.silab.AppKons.service.KonsultacijeService;

/**
 *
 * @author Dane
 */
@Service
public class KonsultacijeServiceImpl implements KonsultacijeService  {

    @Autowired
    GenericMapper mapper;
    @Autowired
    KonsultacijeDAO repository;

    public List<KonsultacijeDTO> findAll() {
        List<Konsultacije> kons = repository.findAll();
        List<KonsultacijeDTO> konsDTO = new ArrayList<>();
        for (Konsultacije k : kons) {
            konsDTO.add(mapper.konsultacijeToKonsultacijeDTO(k));
        }
        return konsDTO;
    }

    public List<KonsultacijeDTO> vratiKonsultacijeZaNastavnika(String JMBGNastavnika) {
        List<Konsultacije> kons = repository.vratiKonsultacijeZaNastavnika(JMBGNastavnika);
        List<KonsultacijeDTO> konsDTO = new ArrayList<>();
        for (Konsultacije k : kons) {
            konsDTO.add(mapper.konsultacijeToKonsultacijeDTO(k));
        }
        return konsDTO;
    }

    public KonsultacijeDTO generisiKonsultacije(KonsultacijeDTO konsultacije) {
        Konsultacije kons = mapper.konsultacijeDTOToKonsultacije(konsultacije);
        return mapper.konsultacijeToKonsultacijeDTO(repository.save(kons));
    }

    public List<KonsultacijeDTO> vratiKonsultacijeZaNastavnikovKalendar(String jmbg, BigDecimal idKalendara) {
        List<Konsultacije> kons = repository.vratiKonsultacijeZaNastavnikovKalendar(jmbg, idKalendara);
        List<KonsultacijeDTO> konsDTO = new ArrayList<>();
        for (Konsultacije k : kons) {
            konsDTO.add(mapper.konsultacijeToKonsultacijeDTO(k));
        }
        return konsDTO;
    }

    public void otkaziKonsultacije(BigInteger idKalendara, BigInteger idDogadjaja) {
        repository.deleteById(new DogadjajPK(idKalendara, idDogadjaja));
    }

}
