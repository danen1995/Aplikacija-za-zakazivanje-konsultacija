/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.AppKons.service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import rs.ac.bg.fon.silab.AppKons.dto.StudentKonsultacijeDTO;
import rs.ac.bg.fon.silab.AppKons.entities.StudentKonsultacije;

/**
 *
 * @author Dane
 */
public interface StudentKonsultacijeService {

    public List<StudentKonsultacije> findAll();

    public StudentKonsultacijeDTO vratiPoIDu(BigInteger idKalendara, BigInteger idDogadjaja, String brojIndeksaStudenta);

    public List<StudentKonsultacijeDTO> findByBrojIndeksaStudenta(String brojIndeksa);

    public List<StudentKonsultacijeDTO> findByJMBGNastavnika(String JMBGNastavnika);

    public void otkaziZakazaneKonsultacije(BigInteger idKalendara, BigInteger idDogadjaja, String brojIndeksaStudenta);

    public StudentKonsultacijeDTO zakaziKonsultacije(StudentKonsultacijeDTO konsultacije);

    public StudentKonsultacijeDTO azurirajKonsultacije(StudentKonsultacijeDTO konsultacije);

    public List<StudentKonsultacijeDTO> vratiSveZaDogadjaj(BigDecimal idKalendara, BigInteger idDogadjaja);

}
