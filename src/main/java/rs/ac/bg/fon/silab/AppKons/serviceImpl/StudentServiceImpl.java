/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.AppKons.serviceImpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.ac.bg.fon.silab.AppKons.entities.Student;
import rs.ac.bg.fon.silab.AppKons.dao.StudentDAO;
import rs.ac.bg.fon.silab.AppKons.service.StudentService;

/**
 *
 * @author Dane
 */
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentDAO repository;

    public List<Student> findAll() {
        return repository.findAll();
    }

    public Student vratiStudenta(String brojIndeksa) {
        return repository.vratiStudenta(brojIndeksa);
    }

}
