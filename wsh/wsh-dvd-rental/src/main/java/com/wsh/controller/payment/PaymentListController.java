package com.wsh.controller.payment;

import com.wsh.domain.Payment;
import com.wsh.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/payment")
@RequiredArgsConstructor
public class PaymentListController {
    private final PaymentService paymentService;

    @GetMapping("/list")
    public String list( final Model model,
                               @RequestParam(value = "page", required = false, defaultValue = "0") int page,
                               @PageableDefault(value = 10, page = 0, sort = "paymentId") Pageable pageable) {
        model.addAttribute("payments", paymentService.findAll(pageable));

        return "payment/list";
    }
}
