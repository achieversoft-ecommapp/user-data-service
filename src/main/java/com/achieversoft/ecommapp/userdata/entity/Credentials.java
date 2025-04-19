package com.achieversoft.ecommapp.userdata.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Date;

/**
 * The type User.
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Credentials implements Serializable {
    @Id
    private String loginId;
    private String userId;
    private String password;
    private String role;
    private String verifToken;
    private Date expireDate;
    private String isEnabled;
    private String isLocked;

}
