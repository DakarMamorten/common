package com.wsh.controller.customer;

import com.wsh.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author "Vladyslav Paun"
 */
@Controller
@RequestMapping("/customer")
@RequiredArgsConstructor
public class CustomerEditController {
    private final CustomerService customerService;
    @PostMapping("/update")
    public String update(@RequestParam final Long customerId,
                         @RequestParam final String firstName,
                         @RequestParam final String lastName,
                         @RequestParam final String email ){
        customerService.update(customerId,firstName,lastName,email);
        return "redirect:/customers/list";
    }
}
