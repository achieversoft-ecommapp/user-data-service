package com.achieversoft.ecommapp.userdata.service;

import com.achieversoft.ecommapp.userdata.common.exception.UserDataException;
import com.achieversoft.ecommapp.userdata.entity.Credentials;
import com.achieversoft.ecommapp.userdata.repository.CredentialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * The type Login service.
 */
@Service
public class LoginService {

    @Autowired
    private CredentialRepository repository;

    /**
     * Gets login by id.
     *
     * @param id the id
     * @return the login by id
     * @throws UserDataException the login data exception
     */
    public Credentials getCredentialById(String id) throws UserDataException {
        return repository.findById(id).get();
    }

    /**
     * Gets logins.
     *
     * @return the logins
     * @throws UserDataException the login data exception
     */
    public List<Credentials> getCredentialDetails() throws UserDataException {
        return repository.findAll();
    }

    /**
     * Save or update login string.
     *
     * @param list the list
     * @return the string
     * @throws UserDataException the login data exception
     */
    public String saveOrUpdateCredential(List<Credentials> list) throws UserDataException {
        int count=repository.saveAll(list).size();
        return "Updated "+count+" Records";
    }

    /**
     * Delete all login string.
     *
     * @return the string
     * @throws UserDataException the login data exception
     */
    public String deleteAllCredential() throws UserDataException {
        repository.deleteAll();
        return "All Records Deleted Successfully.";
    }

    /**
     * Delete login string.
     *
     * @param id the id
     * @return the string
     * @throws UserDataException the login data exception
     */
    public String deleteCredential(String id) throws UserDataException {
        repository.delete(Credentials.builder().loginId(id).build());
        return "Login Id "+id+" Deleted Successfully.";
    }


}
