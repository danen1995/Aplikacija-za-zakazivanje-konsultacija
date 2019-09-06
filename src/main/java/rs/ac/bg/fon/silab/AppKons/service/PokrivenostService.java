/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.AppKons.service;

import java.util.List;
import rs.ac.bg.fon.silab.AppKons.dto.PokrivenostNastaveDTO;
import rs.ac.bg.fon.silab.AppKons.entities.PokrivenostNastave;

/**
 *
 * @author Dane
 */
public interface PokrivenostService {

    public List<PokrivenostNastave> findAll();

    public List<PokrivenostNastaveDTO> findByJmbgNastavnika(String JMBGNastavnika);

}
