package com.achieversoft.ecommapp.customerdata.service;

import com.achieversoft.ecommapp.customerdata.common.exception.CustomerDataException;
import com.achieversoft.ecommapp.customerdata.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.achieversoft.ecommapp.customerdata.repository.CustomerRepository;

import java.util.List;

/**
 * The type Customer service.
 */
@Service
public class CustomerService {

    @Autowired
    private CustomerRepository repository;

    /**
     * Gets customer by id.
     *
     * @param id the id
     * @return the customer by id
     * @throws CustomerDataException the customer data exception
     */
    public Customer getCustomerById(String id) throws CustomerDataException {
        return repository.findById(id).get();
    }

    /**
     * Gets customers.
     *
     * @return the customers
     * @throws CustomerDataException the customer data exception
     */
    public List<Customer> getCustomers() throws CustomerDataException {
        return repository.findAll();
    }

    /**
     * Save customer string.
     *
     * @param list the list
     * @return the string
     * @throws CustomerDataException the customer data exception
     */
    public String saveCustomer(List<Customer> list) throws CustomerDataException {
        int count=repository.saveAll(list).size();
        return "Saved "+count+" Records";
    }

    /**
     * Save or update customer string.
     *
     * @param list the list
     * @return the string
     * @throws CustomerDataException the customer data exception
     */
    public String saveOrUpdateCustomer(List<Customer> list) throws CustomerDataException {
        int count=repository.saveAll(list).size();
        return "Updated "+count+" Records";
    }

    /**
     * Delete all customer string.
     *
     * @return the string
     * @throws CustomerDataException the customer data exception
     */
    public String deleteAllCustomer() throws CustomerDataException {
        repository.deleteAll();
        return "All Records Deleted Successfully.";
    }

    /**
     * Delete customer string.
     *
     * @param id the id
     * @return the string
     * @throws CustomerDataException the customer data exception
     */
    public String deleteCustomer(String id) throws CustomerDataException {
        repository.delete(Customer.builder().customerId(id).build());
        return "Customer Id "+id+" Deleted Successfully.";
    }


}
