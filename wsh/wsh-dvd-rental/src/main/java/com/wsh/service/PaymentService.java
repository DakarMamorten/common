package com.wsh.service;

import com.wsh.domain.Payment;
import com.wsh.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class PaymentService {
    private final PaymentRepository paymentRepository;

    public List<Payment> findAll(){
        return paymentRepository.findAll();
    }

    public Page<Payment> findAll(final Pageable pageable) {
        return paymentRepository.findAll(pageable);
    }

    public void delete(final Long paymentId){
        paymentRepository.deleteById(paymentId);
    }

    public Payment add(final Double amount){
        Payment payment = new Payment(amount);
        return paymentRepository.save(payment);
    }

    public void update(final Long paymentId, final Double amount){
        paymentRepository.findById(paymentId).ifPresent(p -> p.setAmount(amount));
    }
}