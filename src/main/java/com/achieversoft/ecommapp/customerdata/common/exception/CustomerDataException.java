package com.achieversoft.ecommapp.customerdata.common.exception;

import lombok.Data;

/**
 * The type Customer data exception.
 */
@Data
public class CustomerDataException extends RuntimeException{

    private String taskName;
    /**
     * Instantiates a new Customer data exception.
     *
     * @param message the message
     */
    public CustomerDataException(String message){
        super(message);
    }

    public CustomerDataException(String message,String taskName){
        super(message);
        this.taskName=taskName;
    }
}
