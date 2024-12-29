package com.achieversoft.ecommapp.dataservices.customerdata.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

/**
 * The type Customer.
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Customer {
    @Id
    private String customerId;

    private String customerName;
    private Date customerDob;
    private String customerMobile;
    private String customerEmail;
    private String customerAddr;
}
