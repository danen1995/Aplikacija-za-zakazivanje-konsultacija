/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.AppKons.service;

import java.util.List;
import rs.ac.bg.fon.silab.AppKons.dto.NastavnikDTO;

/**
 *
 * @author Dane
 */
public interface NastavnikService {

    public List<NastavnikDTO> findAll();

    public NastavnikDTO vratiNastavnika(String jmbg);

}
