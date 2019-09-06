/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.AppKons.service;

import java.util.List;
import rs.ac.bg.fon.silab.AppKons.dto.KalendarDTO;

/**
 *
 * @author Dane
 */
public interface KalendarService {

    public List<KalendarDTO> vratiKalendareZaNastavnika(String JMBGNastavnika);

}
