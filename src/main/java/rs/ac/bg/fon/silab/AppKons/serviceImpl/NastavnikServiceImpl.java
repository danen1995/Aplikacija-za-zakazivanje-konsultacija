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
import rs.ac.bg.fon.silab.AppKons.dto.NastavnikDTO;
import rs.ac.bg.fon.silab.AppKons.entities.Nastavnik;
import rs.ac.bg.fon.silab.AppKons.mapper.GenericMapper;
import rs.ac.bg.fon.silab.AppKons.dao.NastavnikDAO;
import rs.ac.bg.fon.silab.AppKons.service.NastavnikService;

/**
 *
 * @author Dane
 */
@Service
public class NastavnikServiceImpl implements NastavnikService {

    @Autowired
    GenericMapper mapper;
    @Autowired
    NastavnikDAO repository;

    public List<NastavnikDTO> findAll() {
        List<Nastavnik> nast = repository.findAll();
        List<NastavnikDTO> nastDTO = new ArrayList<>();
        for (Nastavnik k : nast) {
            nastDTO.add(mapper.nastavnikToNastavnikDTO(k));
        }
        return nastDTO;
    }

    public NastavnikDTO vratiNastavnika(String jmbg) {
        return mapper.nastavnikToNastavnikDTO(repository.findById(jmbg).get());
    }

}
