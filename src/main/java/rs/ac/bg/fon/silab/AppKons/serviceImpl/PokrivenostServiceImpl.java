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
import rs.ac.bg.fon.silab.AppKons.dto.PokrivenostNastaveDTO;
import rs.ac.bg.fon.silab.AppKons.entities.PokrivenostNastave;
import rs.ac.bg.fon.silab.AppKons.mapper.GenericMapper;
import rs.ac.bg.fon.silab.AppKons.dao.PokrivenostDAO;
import rs.ac.bg.fon.silab.AppKons.service.PokrivenostService;

/**
 *
 * @author Dane
 */
@Service
public class PokrivenostServiceImpl implements PokrivenostService {

    @Autowired
    GenericMapper mapper;
    @Autowired
    PokrivenostDAO repository;

    public List<PokrivenostNastave> findAll() {
        return repository.findAll();
    }

    public List<PokrivenostNastaveDTO> findByJmbgNastavnika(String JMBGNastavnika) {
        List<PokrivenostNastave> pokrNast = repository.findByJmbgNastavnika(JMBGNastavnika);
        List<PokrivenostNastaveDTO> pokrNastDTO = new ArrayList<>();
        for (PokrivenostNastave pokrivenostNastave : pokrNast) {
            pokrNastDTO.add(mapper.pokrivenostNastaveToPokrivenostNastaveDTO(pokrivenostNastave));
        }
        return pokrNastDTO;
    }

}
