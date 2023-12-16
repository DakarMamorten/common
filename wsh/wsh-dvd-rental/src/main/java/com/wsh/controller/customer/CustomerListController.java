package com.wsh.controller.customer;

import com.wsh.service.AddressService;
import com.wsh.service.CityService;
import com.wsh.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *@author "Vladyslav Paun"
 */
@Controller
@RequiredArgsConstructor
@RequestMapping("/customers")
public class CustomerListController {
    private final CustomerService customerService;
    private final AddressService addressService;

    @GetMapping("/list")
    public String list(Model model,
                        @RequestParam(value = "page", required = false, defaultValue = "0") int page,
                        @PageableDefault(value = 10, page = 0, sort = "customerId") Pageable pageable) {
        model.addAttribute("customers", customerService.findAll(pageable));
        model.addAttribute("addresses", addressService.findAll());
        return "customer/list";

    }

}
