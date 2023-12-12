package com.wsh.controller.address;

import com.wsh.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 *@author "Vladyslav Paun"
 */
@Controller
@RequestMapping("/address")
@RequiredArgsConstructor
public class AddressAddController {
    private final AddressService addressService;

    @PostMapping("/add")
    public String add(final String address, final String address2, final String district, final Long cityId, final String postalCode, final String phone) {
        addressService.add(address, address2, district, cityId, postalCode, phone);
        return "redirect:/address/list";
    }
}
