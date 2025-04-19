package com.achieversoft.ecommapp.userdata.common.exception;

import lombok.Data;

/**
 * The type User data exception.
 */
@Data
public class UserDataException extends RuntimeException{

    private String taskName;
    /**
     * Instantiates a new User data exception.
     *
     * @param message the message
     */
    public UserDataException(String message){
        super(message);
    }

    public UserDataException(String message,String taskName){
        super(message);
        this.taskName=taskName;
    }
}
