package com.wsh.controller.payment;

import com.wsh.repository.PaymentRepository;
import com.wsh.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("payment")
public class PaymentAddController {
    private final PaymentService paymentService;
    @PostMapping("/add")
    public String add(final Double amount){
        paymentService.add(amount);
        return "redirect:/payment/list";
    }
}
