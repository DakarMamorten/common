package com.wsh.domain.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class PaymentDTO {
    private Long paymentId;
    private BigDecimal amount;
    private LocalDateTime paymentDate;
    private LocalDateTime lastUpdate;
    private Long customerId;

    public PaymentDTO(Long paymentId, BigDecimal amount, LocalDateTime paymentDate, LocalDateTime lastUpdate, Long customerId) {
        this.paymentId = paymentId;
        this.amount = amount;
        this.paymentDate = paymentDate;
        this.lastUpdate = lastUpdate;
        this.customerId = customerId;
    }
}

