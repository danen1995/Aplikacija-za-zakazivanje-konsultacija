/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.AppSchSys.serviceImpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.ac.bg.fon.silab.AppSchSys.entities.Student;
import rs.ac.bg.fon.silab.AppSchSys.dao.StudentDAO;
import rs.ac.bg.fon.silab.AppSchSys.dto.StudentDTO;
import rs.ac.bg.fon.silab.AppSchSys.mapper.GenericMapper;
import rs.ac.bg.fon.silab.AppSchSys.service.StudentService;

/**
 *
 * @author Dane
 */
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentDAO repository;

    @Autowired
    GenericMapper mapper;

    public List<Student> findAll() {
        return repository.findAll();
    }

    public StudentDTO findByIndexNumber(String indexNumber) {
        return mapper.studentToStudentDTO(repository.findByIndexNumber(indexNumber));
    }

}
