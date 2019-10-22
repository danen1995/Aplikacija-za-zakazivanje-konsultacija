/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.silab.AppSchSys.serviceImpl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rs.ac.bg.fon.silab.AppSchSys.dto.UserAccountDTO;
import rs.ac.bg.fon.silab.AppSchSys.entities.UserAccount;
import rs.ac.bg.fon.silab.AppSchSys.mapper.GenericMapper;
import rs.ac.bg.fon.silab.AppSchSys.dao.UserAccountDAO;
import rs.ac.bg.fon.silab.AppSchSys.service.UserAccountService;

/**
 *
 * @author student
 */
@Service
public class UserAccountServiceImpl implements UserAccountService {

    @Autowired
    private UserAccountDAO userDAO;
    @Autowired
    GenericMapper mapper;

    public Optional<UserAccountDTO> findByUserName(String userName) {
        if (!userDAO.findByUserName(userName).isPresent()) {
            return Optional.empty();
        }
        return Optional.of(mapper.userAccountToUserAccountDTO(userDAO.findByUserName(userName).get()));
    }

    public Optional<UserAccountDTO> findByUserAccountId(BigDecimal id) {
        if (!userDAO.findByUserAccountId(id).isPresent()) {
            return Optional.empty();
        }
        return Optional.of(mapper.userAccountToUserAccountDTO(userDAO.findByUserAccountId(id).get()));
    }

    public UserAccountDTO registrujSe(UserAccountDTO user) {
        UserAccount kor = mapper.userAccountDTOToUserAccount(user);
        return mapper.userAccountToUserAccountDTO(userDAO.save(kor));
    }

    public List<UserAccountDTO> findAll() {
        List<UserAccount> nalozi = userDAO.findAll();
        List<UserAccountDTO> naloziDTO = new ArrayList<>();
        for (UserAccount nalog : nalozi) {
            naloziDTO.add(mapper.userAccountToUserAccountDTO(nalog));
        }
        return naloziDTO;

    }

    public String userType(BigDecimal userAccountId) {
        Optional<UserAccount> kn = userDAO.findById(userAccountId);
        if (kn.get().getStudent() == null) {
            return kn.get().getTeacher().getTeacherId();
        } else {
            return kn.get().getStudent().getIndexNumber();
        }
    }

    public Boolean existsByUserName(String userName) {
        return userDAO.existsByUserName(userName);
    }

    public boolean studentAlreadyRegistered(String indexNumber) {
        return userDAO.existsByIndexNumber(indexNumber);
    }

}
