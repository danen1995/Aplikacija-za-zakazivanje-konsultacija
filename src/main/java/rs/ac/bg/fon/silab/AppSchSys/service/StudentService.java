/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.AppSchSys.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.ac.bg.fon.silab.AppSchSys.entities.Student;
import rs.ac.bg.fon.silab.AppSchSys.dao.StudentDAO;
import rs.ac.bg.fon.silab.AppSchSys.dto.StudentDTO;
import rs.ac.bg.fon.silab.AppSchSys.dao.ConsultationsDAO;

/**
 *
 * @author Dane
 */
public interface StudentService {

    public List<Student> findAll();

    public StudentDTO findByIndexNumber(String indexNumber);

}
