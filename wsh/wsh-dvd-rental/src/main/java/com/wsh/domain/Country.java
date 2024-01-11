package com.wsh.domain;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
/**
 *@author "Vladyslav Paun"
 */
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long countryId;
    private String countryTitle;
    private LocalDateTime lastDate = LocalDateTime.now();
    @Setter(AccessLevel.PRIVATE)
    @OneToMany(mappedBy = "country")
    private List<City> cities = new ArrayList<>();
    public Country(String countryTitle) {
        this.countryTitle = countryTitle;
    }
    public void addCity(City city) {
        cities.add(city);
        city.setCountry(this);
    }
}
