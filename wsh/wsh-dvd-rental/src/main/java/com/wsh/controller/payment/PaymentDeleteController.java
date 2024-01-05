package com.wsh.controller.payment;

import com.wsh.repository.PaymentRepository;
import com.wsh.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/payment")
@RequiredArgsConstructor
public class PaymentDeleteController {
    private final PaymentService paymentService;
    @PostMapping("/delete")
    public String delete(final @RequestParam("paymentId") Long paymentId){
        paymentService.delete(paymentId);
        return "redirect:/payment/list";
    }
}
