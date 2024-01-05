package com.wsh.repository;

import com.wsh.domain.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 *@author "Vladyslav Paun"
 */
public interface PaymentRepository extends JpaRepository<Payment,Long> {
}
