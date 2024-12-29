package com.achieversoft.ecommapp.dataservices.customerdata.controller;

import com.achieversoft.ecommapp.commonapplibrary.response.MonoResponseHelper;
import com.achieversoft.ecommapp.dataservices.customerdata.common.exception.CustomerDataException;
import com.achieversoft.ecommapp.dataservices.customerdata.entity.Customer;
import com.achieversoft.ecommapp.dataservices.customerdata.service.CustomerService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.achieversoft.ecommapp.commonapplibrary.constants.GlobalConstants.HTTP_STATUS_CODE_200;
import static com.achieversoft.ecommapp.commonapplibrary.constants.GlobalConstants.SUCCESS_STATUS_MESSAGE;
import static com.achieversoft.ecommapp.commonapplibrary.constants.GlobalConstants.SUCCESS_STAUS;
import static com.achieversoft.ecommapp.dataservices.customerdata.common.constants.CustomerDataConstants.DEL_ALL_CUST_DETAILS;
import static com.achieversoft.ecommapp.dataservices.customerdata.common.constants.CustomerDataConstants.DEL_CUST_DETAILS_BY_ID;
import static com.achieversoft.ecommapp.dataservices.customerdata.common.constants.CustomerDataConstants.GET_ALL_CUST_DETAILS;
import static com.achieversoft.ecommapp.dataservices.customerdata.common.constants.CustomerDataConstants.GET_CUST_DETAILS_BY_ID;
import static com.achieversoft.ecommapp.dataservices.customerdata.common.constants.CustomerDataConstants.SAVE_CUST_DETAILS;
import static com.achieversoft.ecommapp.dataservices.customerdata.common.constants.CustomerDataConstants.SERVICE_NAME;
import static com.achieversoft.ecommapp.dataservices.customerdata.common.constants.CustomerDataConstants.UPDATE_CUST_DETAILS;


/**
 * The type Customer controller.
 */
@RestController
@RequestMapping("/customer")
@Slf4j
public class CustomerController {

    @Autowired
    private CustomerService service;

    /**
     * Get customer by id response entity.
     *
     * @param id the id
     * @return the response entity
     */
    @GetMapping("/details/{id}")
    @Operation(description = "Get customer by id")
    public Object getCustomerById(@PathVariable String id){
        try{
            return MonoResponseHelper.buildAPIResponse(Boolean.TRUE,HTTP_STATUS_CODE_200,SUCCESS_STATUS_MESSAGE,
                    service.getCustomerById(id),GET_CUST_DETAILS_BY_ID,SUCCESS_STAUS,SERVICE_NAME);
        }catch (Exception e){
            throw new CustomerDataException(e.getMessage(),GET_CUST_DETAILS_BY_ID);
        }
    }

    /**
     * Get customers response entity.
     *
     * @return the response entity
     */
    @GetMapping("/details/all")
    public Object getCustomers(){
        try{
            return MonoResponseHelper.buildAPIResponse(Boolean.TRUE,HTTP_STATUS_CODE_200,SUCCESS_STATUS_MESSAGE,
                                     service.getCustomers(),GET_ALL_CUST_DETAILS,SUCCESS_STAUS,SERVICE_NAME);
        }catch (Exception e){
            throw new CustomerDataException(e.getMessage(),GET_ALL_CUST_DETAILS);
        }
    }

    /**
     * Save customer response entity.
     *
     * @param list the list
     * @return the response entity
     */
    @PostMapping("/details")
    public Object saveCustomer(@RequestBody List<Customer> list){
        try{
            return MonoResponseHelper.buildAPIResponse(Boolean.TRUE,HTTP_STATUS_CODE_200,SUCCESS_STATUS_MESSAGE,
                    service.saveCustomer(list),SAVE_CUST_DETAILS,SUCCESS_STAUS,SERVICE_NAME);

        }catch (Exception e){
            throw new CustomerDataException(e.getMessage(),SAVE_CUST_DETAILS);
        }

    }

    /**
     * Save or update customer response entity.
     *
     * @param list the list
     * @return the response entity
     */
    @PutMapping("/details")
    public Object saveOrUpdateCustomer(@RequestBody List<Customer> list){
        try{
            return MonoResponseHelper.buildAPIResponse(Boolean.TRUE,HTTP_STATUS_CODE_200,SUCCESS_STATUS_MESSAGE,
                    service.saveOrUpdateCustomer(list),UPDATE_CUST_DETAILS,SUCCESS_STAUS,SERVICE_NAME);

        }catch (Exception e){
            throw new CustomerDataException(e.getMessage(),UPDATE_CUST_DETAILS);
        }

    }

    /**
     * Delete customer response entity.
     *
     * @param id the id
     * @return the response entity
     */
    @PostMapping("/details/delete/{id}")
    public Object deleteCustomer(@PathVariable String id){
        try{
            return MonoResponseHelper.buildAPIResponse(Boolean.TRUE,HTTP_STATUS_CODE_200,SUCCESS_STATUS_MESSAGE,
                    service.deleteCustomer(id),DEL_CUST_DETAILS_BY_ID,SUCCESS_STAUS,SERVICE_NAME);
        }catch (Exception e){
            throw new CustomerDataException(e.getMessage(),DEL_CUST_DETAILS_BY_ID);
        }

    }

    /**
     * Delete all customer response entity.
     *
     * @return the response entity
     */
    @PostMapping("/details/delete/all")
    public Object deleteAllCustomer(){
        try{
            return MonoResponseHelper.buildAPIResponse(Boolean.TRUE,HTTP_STATUS_CODE_200,SUCCESS_STATUS_MESSAGE,
                    service.deleteAllCustomer(),DEL_ALL_CUST_DETAILS,SUCCESS_STAUS,SERVICE_NAME);
        }catch (Exception e){
            throw new CustomerDataException(e.getMessage(),DEL_ALL_CUST_DETAILS);
        }

    }




}
