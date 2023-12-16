package com.wsh.controller.customer;

import com.wsh.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/customers")
@RequiredArgsConstructor
public class CustomerAddController {
    private final CustomerService customerService;
    @PostMapping("/add")
    public String add(final String firstName, final String lastName, final String email, final Long addressId){
        customerService.add(firstName,lastName,email,addressId);
        return "redirect:/customers/list";
    }
}
