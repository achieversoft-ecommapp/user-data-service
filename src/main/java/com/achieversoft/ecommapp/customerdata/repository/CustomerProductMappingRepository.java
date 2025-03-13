package com.achieversoft.ecommapp.customerdata.repository;


import com.achieversoft.ecommapp.customerdata.entity.Customer;
import com.achieversoft.ecommapp.customerdata.entity.CustomerProductMapping;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The interface Customer repository.
 */
@Repository
public interface CustomerProductMappingRepository extends JpaRepository<CustomerProductMapping, String> {


}
