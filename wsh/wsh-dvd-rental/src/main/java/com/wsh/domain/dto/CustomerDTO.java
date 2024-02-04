package com.wsh.domain.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class CustomerDTO {
    private Long customerId;
    private String firstName;
    private String lastName;
    private String email;
    private boolean active;
    private String address;
    private String address2;
    private String district;
    private String postalCode;
    private String cityTitle;
    private LocalDateTime lastUpdate;
    private BigDecimal amount;

    public CustomerDTO(Long customerId, String firstName, String lastName, String email, boolean active, String address, String address2, String district, String postalCode, String cityTitle, LocalDateTime lastUpdate,BigDecimal amount) {
        this.customerId = customerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.active = active;
        this.address = address;
        this.address2 = address2;
        this.district = district;
        this.postalCode = postalCode;
        this.cityTitle = cityTitle;
        this.lastUpdate = lastUpdate;
        this.amount = amount;
    }
}
