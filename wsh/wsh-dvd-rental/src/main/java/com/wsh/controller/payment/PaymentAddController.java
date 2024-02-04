package com.wsh.controller.payment;

import com.wsh.repository.PaymentRepository;
import com.wsh.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

@Controller
@RequiredArgsConstructor
@RequestMapping("payment")
public class PaymentAddController {
    private final PaymentService paymentService;
    @PostMapping("/add")
    public String add( @RequestParam("paymentAmount") final BigDecimal amount){
        paymentService.add(amount);
        return "redirect:/payment/list";
    }
}
