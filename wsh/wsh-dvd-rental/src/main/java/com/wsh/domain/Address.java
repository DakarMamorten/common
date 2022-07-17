package com.wsh.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long addressId;
    private String address;
    private String address2;
    private String district;
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "city_id")
    private City city;
    private String postalCode;
    private String phone;
    private LocalDateTime lastUpdate = LocalDateTime.now();

    public Address(String address, String address2, String district, String postalCode, String phone) {
        this.address = address;
        this.address2 = address2;
        this.district = district;
        this.postalCode = postalCode;
        this.phone = phone;
    }


}
