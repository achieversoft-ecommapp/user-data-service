package com.achieversoft.ecommapp.dataservices.customerdata.repository;


import com.achieversoft.ecommapp.dataservices.customerdata.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The interface Customer repository.
 */
@Repository
public interface CustomerRepository extends JpaRepository<Customer, String> {


}
