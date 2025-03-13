package com.achieversoft.ecommapp.customerdata.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

/**
 * The type CustomerProductMapping.
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerProductMapping {
    private String customerId;
    private String productId;
}
