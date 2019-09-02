/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.AppKons.service;

import rs.ac.bg.fon.silab.AppKons.serviceImpl.*;
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

/**
 *
 * @author Dane
 */
public interface KonsultacijeService {

    public List<KonsultacijeDTO> findAll();

    public List<KonsultacijeDTO> vratiKonsultacijeZaNastavnika(String JMBGNastavnika);

    public KonsultacijeDTO generisiKonsultacije(KonsultacijeDTO konsultacije);

    public List<KonsultacijeDTO> vratiKonsultacijeZaNastavnikovKalendar(String jmbg, BigDecimal idKalendara);

    public void otkaziKonsultacije(BigInteger idKalendara, BigInteger idDogadjaja);
}
