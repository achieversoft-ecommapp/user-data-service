package com.achieversoft.ecommapp.customerdata.service;

import com.achieversoft.ecommapp.customerdata.common.exception.CustomerDataException;
import com.achieversoft.ecommapp.customerdata.entity.Customer;
import com.achieversoft.ecommapp.customerdata.entity.CustomerProductMapping;
import com.achieversoft.ecommapp.customerdata.repository.CustomerProductMappingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.achieversoft.ecommapp.customerdata.repository.CustomerRepository;

import java.util.List;
import java.util.stream.Collectors;

/**
 * The type Customer service.
 */
@Service
public class CustomerService {

    @Autowired
    private CustomerRepository repository;
    @Autowired
    private CustomerProductMappingRepository mappingRepository;

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

    /**
     *
     * @param id
     * @return
     * @throws CustomerDataException
     */
    public List<CustomerProductMapping> getProductsForCustomer(String id) throws CustomerDataException {
        return mappingRepository.findAll().stream()
                .filter(data->id.equalsIgnoreCase(data.getCustomerId()))
                .collect(Collectors.toList());
    }

    /**
     *
     * @param id
     * @return
     * @throws CustomerDataException
     */
    public List<CustomerProductMapping> getCustomersForProduct(String id) throws CustomerDataException {
        return mappingRepository.findAll().stream()
                .filter(data->id.equalsIgnoreCase(data.getProductId()))
                .collect(Collectors.toList());
    }


}
