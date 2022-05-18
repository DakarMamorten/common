package com.example.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AdminCode {
    @Id
    @GeneratedValue
    private String id;

    private String code;

    private String title;
    private String titleUa;

    @OneToMany
    private Set<CityCode> codes;
}
