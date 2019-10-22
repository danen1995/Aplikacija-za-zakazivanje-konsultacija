/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.AppSchSys.service;

import java.util.List;
import rs.ac.bg.fon.silab.AppSchSys.dto.TeacherDTO;

/**
 *
 * @author Dane
 */
public interface TeacherService {

    public List<TeacherDTO> findAll();

    public TeacherDTO findById(String teacherId);

}
