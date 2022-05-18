package com.wsh.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CityCode {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String code;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "admin_code_id")
    private AdminCode adminCode;

    public CityCode(String code, AdminCode adminCode) {
        this.code = code;
        this.adminCode = adminCode;
    }
}
