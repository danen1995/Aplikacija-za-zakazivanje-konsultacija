/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.AppSchSys.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import rs.ac.bg.fon.silab.AppSchSys.dto.UserAccountDTO;

/**
 *
 * @author student
 */
public interface UserAccountService {

    public UserAccountDTO registrujSe(UserAccountDTO user);

    public Optional<UserAccountDTO> findByUserName(String userName);

    public Optional<UserAccountDTO> findByUserAccountId(BigDecimal id);

    public List<UserAccountDTO> findAll();

    public String userType(BigDecimal userAccountId);

    public Boolean existsByUserName(String userName);

    public boolean studentAlreadyRegistered(String indexNumber);

}
