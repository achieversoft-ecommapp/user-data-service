package com.achieversoft.ecommapp.customerdata.repository;


import com.achieversoft.ecommapp.customerdata.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The interface Customer repository.
 */
@Repository
public interface CustomerRepository extends JpaRepository<Customer, String> {


}
