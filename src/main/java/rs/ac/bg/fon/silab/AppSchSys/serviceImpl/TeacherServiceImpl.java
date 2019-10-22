/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.AppSchSys.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.ac.bg.fon.silab.AppSchSys.dto.TeacherDTO;
import rs.ac.bg.fon.silab.AppSchSys.entities.Teacher;
import rs.ac.bg.fon.silab.AppSchSys.mapper.GenericMapper;
import rs.ac.bg.fon.silab.AppSchSys.dao.TeacherDAO;
import rs.ac.bg.fon.silab.AppSchSys.service.TeacherService;

/**
 *
 * @author Dane
 */
@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    GenericMapper mapper;
    @Autowired
    TeacherDAO repository;

    public List<TeacherDTO> findAll() {
        List<Teacher> nast = repository.findAll();
        List<TeacherDTO> nastDTO = new ArrayList<>();
        for (Teacher k : nast) {
            nastDTO.add(mapper.teacherToteacherDTO(k));
        }
        return nastDTO;
    }

    public TeacherDTO findById(String teacherId) {
        return mapper.teacherToteacherDTO(repository.findById(teacherId).get());
    }

}
