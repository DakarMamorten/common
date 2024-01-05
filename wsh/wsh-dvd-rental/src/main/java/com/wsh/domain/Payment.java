package com.wsh.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long paymentId;
    private Double amount;
    private LocalDateTime paymentDate = LocalDateTime.now();
    private LocalDateTime lastUpdate = LocalDateTime.now();

    public Payment(Double amount) {
        this.amount = amount;
    }
}
