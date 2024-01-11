package com.wsh.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
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
}
