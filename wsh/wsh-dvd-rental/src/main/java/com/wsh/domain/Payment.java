package com.wsh.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long paymentId;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
    private Double amount;
    private LocalDateTime paymentDate= LocalDateTime.now();
    private LocalDateTime lastUpdateDate = LocalDateTime.now();
}
