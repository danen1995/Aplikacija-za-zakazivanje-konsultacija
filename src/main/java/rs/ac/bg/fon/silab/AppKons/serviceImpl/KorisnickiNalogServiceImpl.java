/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.AppKons.serviceImpl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.ac.bg.fon.silab.AppKons.dto.KorisnickiNalogDTO;
import rs.ac.bg.fon.silab.AppKons.entities.KorisnickiNalog;
import rs.ac.bg.fon.silab.AppKons.mapper.GenericMapper;
import rs.ac.bg.fon.silab.AppKons.dao.KorisnickiNalogDAO;
import rs.ac.bg.fon.silab.AppKons.service.KorisnickiNalogService;

/**
 *
 * @author student
 */
@Service
public class KorisnickiNalogServiceImpl implements KorisnickiNalogService {

    @Autowired
    private KorisnickiNalogDAO userDAO;
    @Autowired
    GenericMapper mapper;

    public Optional<KorisnickiNalogDTO> findByKorisnickoIme(String korisnickoIme) {
        if (!userDAO.findByKorisnickoIme(korisnickoIme).isPresent()) {
            return Optional.empty();
        }
        return Optional.of(mapper.korisnickiNalogToKorisnickiNalogDTO(userDAO.findByKorisnickoIme(korisnickoIme).get()));
    }

    public Optional<KorisnickiNalogDTO> findByIdKorisnickogNaloga(BigDecimal id) {
        if (!userDAO.findByIdKorisnickogNaloga(id).isPresent()) {
            return Optional.empty();
        }
        return Optional.of(mapper.korisnickiNalogToKorisnickiNalogDTO(userDAO.findByIdKorisnickogNaloga(id).get()));
    }

    public KorisnickiNalogDTO registrujSe(KorisnickiNalogDTO user) {
        KorisnickiNalog kor = mapper.korisnickiNalogDTOToKorisnickiNalog(user);
        return mapper.korisnickiNalogToKorisnickiNalogDTO(userDAO.save(kor));
    }

    public List<KorisnickiNalogDTO> findAll() {
        List<KorisnickiNalog> nalozi = userDAO.findAll();
        List<KorisnickiNalogDTO> naloziDTO = new ArrayList<>();
        for (KorisnickiNalog nalog : nalozi) {
            naloziDTO.add(mapper.korisnickiNalogToKorisnickiNalogDTO(nalog));
        }
        return naloziDTO;

    }

    public String tipUsera(BigDecimal korID) {
        Optional<KorisnickiNalog> kn = userDAO.findById(korID);
        if (kn.get().getStudent() == null) {
            return kn.get().getNastavnik().getJmbg();
        } else {
            return kn.get().getStudent().getBrojIndeksa();
        }
    }

    public Boolean existsByKorisnickoIme(String korisnickoIme) {
        return userDAO.existsByKorisnickoIme(korisnickoIme);
    }

  

}
