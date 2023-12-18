package com.wsh.controller.customer;

import com.wsh.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/customer")
@RequiredArgsConstructor
public class CustomerDeleteController {
    private final CustomerService customerService;

    @PostMapping("/delete")
    public String delete(@RequestParam("customerId" ) final  Long customerId){
        customerService.delete(customerId);
        return "redirect:/customers/list";
    }
}
