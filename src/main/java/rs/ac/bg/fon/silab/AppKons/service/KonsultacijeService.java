/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.AppKons.service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import rs.ac.bg.fon.silab.AppKons.dto.KonsultacijeDTO;

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
