package com.achieversoft.ecommapp.userdata.repository;


import com.achieversoft.ecommapp.userdata.entity.Credentials;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The interface User repository.
 */
@Repository
public interface CredentialRepository extends JpaRepository<Credentials, String> {


}
