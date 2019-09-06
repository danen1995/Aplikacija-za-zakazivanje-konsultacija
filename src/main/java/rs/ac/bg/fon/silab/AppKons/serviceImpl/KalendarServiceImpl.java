/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.AppKons.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.ac.bg.fon.silab.AppKons.dto.KalendarDTO;
import rs.ac.bg.fon.silab.AppKons.entities.Kalendar;
import rs.ac.bg.fon.silab.AppKons.mapper.GenericMapper;
import rs.ac.bg.fon.silab.AppKons.dao.KalendarDAO;
import rs.ac.bg.fon.silab.AppKons.service.KalendarService;

/**
 *
 * @author Dane
 */
@Service
public class KalendarServiceImpl implements KalendarService {

    @Autowired
    GenericMapper mapper;
    @Autowired
    KalendarDAO repository;

    public List<KalendarDTO> vratiKalendareZaNastavnika(String JMBGNastavnika) {
        List<Kalendar> kons = repository.vratiKalendareZaNastavnika(JMBGNastavnika);
        List<KalendarDTO> konsDTO = new ArrayList<>();
        for (Kalendar k : kons) {
            konsDTO.add(mapper.kalendarToKalendarDTO(k));
        }
        return konsDTO;
    }

}
