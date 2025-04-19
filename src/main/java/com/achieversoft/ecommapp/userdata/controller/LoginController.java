package com.achieversoft.ecommapp.userdata.controller;

import com.achieversoft.ecommapp.commonapplibrary.response.MonoResponseHelper;
import com.achieversoft.ecommapp.userdata.common.exception.UserDataException;
import com.achieversoft.ecommapp.userdata.entity.Credentials;
import com.achieversoft.ecommapp.userdata.service.LoginService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
import static com.achieversoft.ecommapp.userdata.common.constants.UserDataConstants.DEL_ALL_CREDENTIAL;
import static com.achieversoft.ecommapp.userdata.common.constants.UserDataConstants.DEL_CREDENTIAL_BY_ID;
import static com.achieversoft.ecommapp.userdata.common.constants.UserDataConstants.GET_ALL_CREDENTIAL_DETAILS;
import static com.achieversoft.ecommapp.userdata.common.constants.UserDataConstants.GET_CREDENTIAL_BY_ID;
import static com.achieversoft.ecommapp.userdata.common.constants.UserDataConstants.SERVICE_NAME;
import static com.achieversoft.ecommapp.userdata.common.constants.UserDataConstants.UPDATE_CREDENTIAL_DETAILS;


/**
 * The type Login controller.
 */
@RestController
@RequestMapping("/api/login")
@Slf4j
@RequiredArgsConstructor
public class LoginController {

    private final LoginService service;

    /**
     * Get user by id response entity.
     *
     * @param id the id
     * @return the response entity
     */
    @GetMapping("/details/{id}")
    @Operation(description = "Get user by id")
    public Object getCredentialById(@PathVariable String id){
        try{
            return MonoResponseHelper.buildAPIResponse(Boolean.TRUE,HTTP_STATUS_CODE_200,SUCCESS_STATUS_MESSAGE,
                    service.getCredentialById(id),GET_CREDENTIAL_BY_ID,SUCCESS_STAUS,SERVICE_NAME);
        }catch (Exception e){
            throw new UserDataException(e.getMessage(),GET_CREDENTIAL_BY_ID);
        }
    }

    /**
     * Get users response entity.
     *
     * @return the response entity
     */
    @GetMapping("/details/all")
    public Object getCredentials(){
        try{
            return MonoResponseHelper.buildAPIResponse(Boolean.TRUE,HTTP_STATUS_CODE_200,SUCCESS_STATUS_MESSAGE,
                                     service.getCredentialDetails(),GET_ALL_CREDENTIAL_DETAILS,SUCCESS_STAUS,SERVICE_NAME);
        }catch (Exception e){
            throw new UserDataException(e.getMessage(),GET_ALL_CREDENTIAL_DETAILS);
        }
    }

    /**
     * Save or update user response entity.
     *
     * @param list the list
     * @return the response entity
     */
    @PutMapping("/details/updt")
    public Object saveOrUpdateCredential(@RequestBody List<Credentials> list){
        try{
            return MonoResponseHelper.buildAPIResponse(Boolean.TRUE,HTTP_STATUS_CODE_200,SUCCESS_STATUS_MESSAGE,
                    service.saveOrUpdateCredential(list),UPDATE_CREDENTIAL_DETAILS,SUCCESS_STAUS,SERVICE_NAME);

        }catch (Exception e){
            throw new UserDataException(e.getMessage(),UPDATE_CREDENTIAL_DETAILS);
        }

    }

    /**
     * Delete user response entity.
     *
     * @param id the id
     * @return the response entity
     */
    @PostMapping("/details/dlt/{id}")
    public Object deleteCredential(@PathVariable String id){
        try{
            return MonoResponseHelper.buildAPIResponse(Boolean.TRUE,HTTP_STATUS_CODE_200,SUCCESS_STATUS_MESSAGE,
                    service.deleteCredential(id),DEL_CREDENTIAL_BY_ID,SUCCESS_STAUS,SERVICE_NAME);
        }catch (Exception e){
            throw new UserDataException(e.getMessage(),DEL_CREDENTIAL_BY_ID);
        }

    }

    /**
     * Delete all user response entity.
     *
     * @return the response entity
     */
    @PostMapping("/details/dlt/all")
    public Object deleteAllCredential(){
        try{
            return MonoResponseHelper.buildAPIResponse(Boolean.TRUE,HTTP_STATUS_CODE_200,SUCCESS_STATUS_MESSAGE,
                    service.deleteAllCredential(),DEL_ALL_CREDENTIAL,SUCCESS_STAUS,SERVICE_NAME);
        }catch (Exception e){
            throw new UserDataException(e.getMessage(),DEL_ALL_CREDENTIAL);
        }

    }



}
