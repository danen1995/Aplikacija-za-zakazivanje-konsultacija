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
import rs.ac.bg.fon.silab.AppSchSys.dto.CoverageDTO;
import rs.ac.bg.fon.silab.AppSchSys.entities.Coverage;
import rs.ac.bg.fon.silab.AppSchSys.mapper.GenericMapper;
import rs.ac.bg.fon.silab.AppSchSys.dao.CoverageDAO;
import rs.ac.bg.fon.silab.AppSchSys.service.CoverageService;

/**
 *
 * @author Dane
 */
@Service
public class CoverageServiceImpl implements CoverageService {

    @Autowired
    GenericMapper mapper;
    @Autowired
    CoverageDAO repository;

    public List<Coverage> findAll() {
        return repository.findAll();
    }

    public List<CoverageDTO> findByTeacherId(String teacherId) {
        List<Coverage> pokrNast = repository.findByTeacherId(teacherId);
        List<CoverageDTO> pokrNastDTO = new ArrayList<>();
        for (Coverage pokrivenostNastave : pokrNast) {
            pokrNastDTO.add(mapper.coverageToCoverageDTO(pokrivenostNastave));
        }
        return pokrNastDTO;
    }

}
