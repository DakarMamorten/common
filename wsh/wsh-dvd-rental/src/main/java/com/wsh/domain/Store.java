package com.wsh.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * @author "Vladyslav Paun"
 */
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "store_id")
    private Long storeId;

    @Column(name = "manager_staff_id", nullable = false)
    private Long managerStaffId;

    @Column(name = "address_id", nullable = false)
    private Long addressId;

    @Column(name = "last_update", nullable = false)
    private LocalDateTime lastUpdate;
}
