package com.wsh.controller.payment;

import com.wsh.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.beans.Transient;

@Controller
@RequiredArgsConstructor
@RequestMapping("/payment")
public class PaymentEditController {
    private final PaymentService paymentService;

    @PostMapping("/update")
    public String update(final @RequestParam("paymentId") Long paymentID,final @RequestParam Double amount){
        paymentService.update(paymentID,amount);
        return "redirect:/payment/list";
    }
}