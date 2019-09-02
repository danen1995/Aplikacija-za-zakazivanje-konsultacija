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
import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.ac.bg.fon.silab.AppKons.dto.KorisnickiNalogDTO;
import rs.ac.bg.fon.silab.AppKons.dto.StudentKonsultacijeDTO;
import rs.ac.bg.fon.silab.AppKons.entities.Konsultacije;
import rs.ac.bg.fon.silab.AppKons.entities.KorisnickiNalog;
import rs.ac.bg.fon.silab.AppKons.entities.StudentKonsultacije;
import rs.ac.bg.fon.silab.AppKons.entities.StudentKonsultacijePK;
import rs.ac.bg.fon.silab.AppKons.mapper.GenericMapper;
import rs.ac.bg.fon.silab.AppKons.dao.KonsultacijeDAO;
import rs.ac.bg.fon.silab.AppKons.dao.StudentKonsultacijeDAO;
import rs.ac.bg.fon.silab.AppKons.service.StudentKonsultacijeService;

/**
 *
 * @author Dane
 */
@Service
public class StudentKonsultacijeServiceImpl implements StudentKonsultacijeService {

    @Autowired
    GenericMapper mapper;
    @Autowired
    StudentKonsultacijeDAO repository;

    public List<StudentKonsultacije> findAll() {
        return repository.findAll();
    }

    public StudentKonsultacijeDTO vratiPoIDu(BigInteger idKalendara, BigInteger idDogadjaja, String brojIndeksaStudenta) {
        return mapper.studentKonsultacijeToStudentKonsultacijeDTO(repository.findById(new StudentKonsultacijePK(idKalendara, idDogadjaja, brojIndeksaStudenta)).get());
    }

    public List<StudentKonsultacijeDTO> findByBrojIndeksaStudenta(String brojIndeksa) {
        List<StudentKonsultacije> studentKons = repository.findByBrojIndeksaStudenta(brojIndeksa);
        List<StudentKonsultacijeDTO> studentKonsDTO = new ArrayList<>();
        for (StudentKonsultacije studentKon : studentKons) {
            studentKonsDTO.add(mapper.studentKonsultacijeToStudentKonsultacijeDTO(studentKon));
        }
        return studentKonsDTO;
    }

    public List<StudentKonsultacijeDTO> findByJMBGNastavnika(String JMBGNastavnika) {
        List<StudentKonsultacije> studentKons = repository.findByJMBGNastavnika(JMBGNastavnika);
        List<StudentKonsultacijeDTO> studentKonsDTO = new ArrayList<>();
        for (StudentKonsultacije studentKon : studentKons) {
            studentKonsDTO.add(mapper.studentKonsultacijeToStudentKonsultacijeDTO(studentKon));
        }
        return studentKonsDTO;
    }

    public void otkaziZakazaneKonsultacije(BigInteger idKalendara, BigInteger idDogadjaja, String brojIndeksaStudenta) {
        repository.deleteById(new StudentKonsultacijePK(idKalendara, idDogadjaja, brojIndeksaStudenta));
    }

    public StudentKonsultacijeDTO zakaziKonsultacije(StudentKonsultacijeDTO konsultacije) {
        return mapper.studentKonsultacijeToStudentKonsultacijeDTO(repository.save(mapper.studentKonsultacijeDTOToStudentKonsultacije(konsultacije)));
    }

    public StudentKonsultacijeDTO azurirajKonsultacije(StudentKonsultacijeDTO konsultacije) {
        return mapper.studentKonsultacijeToStudentKonsultacijeDTO(repository.save(mapper.studentKonsultacijeDTOToStudentKonsultacije(konsultacije)));
    }

    public List<StudentKonsultacijeDTO> vratiSveZaDogadjaj(BigDecimal idKalendara, BigInteger idDogadjaja) {
        List<StudentKonsultacije> studentKons = repository.vratiSveZaDogadjaj(idKalendara, idDogadjaja);
        List<StudentKonsultacijeDTO> studentKonsDTO = new ArrayList<>();
        for (StudentKonsultacije studentKon : studentKons) {
            studentKonsDTO.add(mapper.studentKonsultacijeToStudentKonsultacijeDTO(studentKon));
        }
        return studentKonsDTO;
    }

}
