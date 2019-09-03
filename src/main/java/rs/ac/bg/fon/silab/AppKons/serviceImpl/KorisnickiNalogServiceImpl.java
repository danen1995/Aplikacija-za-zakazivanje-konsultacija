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
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.ac.bg.fon.silab.AppKons.dto.KorisnickiNalogDTO;
import rs.ac.bg.fon.silab.AppKons.dto.NastavnikDTO;
import rs.ac.bg.fon.silab.AppKons.dto.UserDTO;
import rs.ac.bg.fon.silab.AppKons.entities.KorisnickiNalog;
import rs.ac.bg.fon.silab.AppKons.entities.Nastavnik;
import rs.ac.bg.fon.silab.AppKons.mapper.GenericMapper;
import rs.ac.bg.fon.silab.AppKons.dao.KorisnickiNalogDAO;
import rs.ac.bg.fon.silab.AppKons.dao.NastavnikDAO;
import rs.ac.bg.fon.silab.AppKons.dao.StudentDAO;
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

    public KorisnickiNalogDTO login(String username, String password) {
        return mapper.korisnickiNalogToKorisnickiNalogDTO(userDAO.login(username, password));
    }

    public KorisnickiNalogDTO registrujSe(KorisnickiNalogDTO user) {
        KorisnickiNalog kor = mapper.korisnickiNalogDTOToKorisnickiNalog(user);
        return mapper.korisnickiNalogToKorisnickiNalogDTO(userDAO.save(kor));
    }

    public Optional<KorisnickiNalog> findByKorisnickoIme(String korisnickoIme) {
        return userDAO.findByKorisnickoIme(korisnickoIme);
    }

    public Object authenticate(KorisnickiNalogDTO user) throws Exception {
        KorisnickiNalog userDB = userDAO.login(user.getKorisnickoIme(), user.getLozinka());
        if (userDB == null) {
            throw new Exception("Unknown user.");
        }
        return userDB;
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
        Optional<KorisnickiNalog> kn = userDAO.nadjiPoIdu(korID);
        System.out.println(kn.get().getKorisnickoIme());
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
