package com.wsh.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long cityId;

    private String cityTitle;

    private LocalDateTime lastUpdate = LocalDateTime.now();

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "country_id")
    private Country country;

    @Setter(AccessLevel.PRIVATE)
    @OneToMany(mappedBy = "city")
    private List<Address> addresses = new ArrayList<>();

    public City(String cityTitle) {
        this.cityTitle = cityTitle;
    }

    public void addAddress(Address address) {
        addresses.add(address);
        address.setCity(this);
    }
}
