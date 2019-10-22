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
import rs.ac.bg.fon.silab.AppSchSys.dto.CalendarDTO;
import rs.ac.bg.fon.silab.AppSchSys.entities.Calendar;
import rs.ac.bg.fon.silab.AppSchSys.mapper.GenericMapper;
import rs.ac.bg.fon.silab.AppSchSys.dao.CalendarDAO;
import rs.ac.bg.fon.silab.AppSchSys.service.CalendarService;

/**
 *
 * @author Dane
 */
@Service
public class CalendarServiceImpl implements CalendarService {

    @Autowired
    GenericMapper mapper;
    @Autowired
    CalendarDAO repository;

    public List<CalendarDTO> getCalendarsForTeacher(String teacherId) {
        List<Calendar> kons = repository.getCalendarsForTeacher(teacherId);
        List<CalendarDTO> konsDTO = new ArrayList<>();
        for (Calendar k : kons) {
            konsDTO.add(mapper.calendarToCalendarDTO(k));
        }
        return konsDTO;
    }

}
