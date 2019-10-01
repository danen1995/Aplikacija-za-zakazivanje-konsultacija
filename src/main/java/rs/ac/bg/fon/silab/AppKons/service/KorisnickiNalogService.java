/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.AppKons.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import rs.ac.bg.fon.silab.AppKons.dto.KorisnickiNalogDTO;

/**
 *
 * @author student
 */
public interface KorisnickiNalogService {

    public KorisnickiNalogDTO registrujSe(KorisnickiNalogDTO user);

    public Optional<KorisnickiNalogDTO> findByKorisnickoIme(String korisnickoIme);

    public Optional<KorisnickiNalogDTO> findByIdKorisnickogNaloga(BigDecimal id);

    public List<KorisnickiNalogDTO> findAll();

    public String tipUsera(BigDecimal korID);

    public Boolean existsByKorisnickoIme(String korisnickoIme);

    public boolean studentAlreadyRegistered(String brojIndeksa);

}
