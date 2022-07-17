package com.wsh.controller.address;

import com.wsh.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/address")
public class AddressEditController {
    private final AddressService addressService;

    @PostMapping("/update")
    public String update(final Long addressId, final String address, final String address2, final String district, final Long cityId, final String postalCode, final String phone){
        addressService.update(addressId,address,address2,district,cityId,postalCode,phone);
        return "redirect:/address/list";
    }
}
