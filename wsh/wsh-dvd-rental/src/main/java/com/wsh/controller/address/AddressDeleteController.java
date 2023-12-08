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
@RequiredArgsConstructor
@RequestMapping("/address")
public class AddressDeleteController {
    private final AddressService addressService;

    @PostMapping("/delete")
    public String delete(final Long addressId) {
        addressService.delete(addressId);
        return "redirect:/address/list";
    }
}
