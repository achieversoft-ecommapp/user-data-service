package com.achieversoft.ecommapp.userdata.service;

import com.achieversoft.ecommapp.userdata.common.exception.UserDataException;
import com.achieversoft.ecommapp.userdata.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.achieversoft.ecommapp.userdata.repository.UserRepository;

import java.util.List;

/**
 * The type User service.
 */
@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    /**
     * Gets user by id.
     *
     * @param id the id
     * @return the user by id
     * @throws UserDataException the user data exception
     */
    public Users getUserById(String id) throws UserDataException {
        return repository.findById(id).get();
    }

    /**
     * Gets users.
     *
     * @return the users
     * @throws UserDataException the user data exception
     */
    public List<Users> getUsers() throws UserDataException {
        return repository.findAll();
    }

    /**
     * Save or update user string.
     *
     * @param list the list
     * @return the string
     * @throws UserDataException the user data exception
     */
    public String saveOrUpdateUser(List<Users> list) throws UserDataException {
        int count=repository.saveAll(list).size();
        return "Updated "+count+" Records";
    }

    /**
     * Delete all user string.
     *
     * @return the string
     * @throws UserDataException the user data exception
     */
    public String deleteAllUser() throws UserDataException {
        repository.deleteAll();
        return "All Records Deleted Successfully.";
    }

    /**
     * Delete user string.
     *
     * @param id the id
     * @return the string
     * @throws UserDataException the user data exception
     */
    public String deleteUser(String id) throws UserDataException {
        repository.delete(Users.builder().userId(id).build());
        return "User Id "+id+" Deleted Successfully.";
    }


}
