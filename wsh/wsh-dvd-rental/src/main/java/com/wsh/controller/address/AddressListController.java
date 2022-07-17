package com.wsh.controller.address;

import com.wsh.service.AddressService;
import com.wsh.service.CityService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
@RequestMapping("/address")
public class AddressListController {
    private final AddressService addressService;
    private final CityService cityService;

    @GetMapping("/list")
    public String list(Model model,
                        @RequestParam(value = "page", required = false, defaultValue = "0") int page,
                        @PageableDefault(value = 10, page = 0, sort = "addressId") Pageable pageable) {
        model.addAttribute("addresses", addressService.findAll(pageable));
        model.addAttribute("cities", cityService.findAll());
        return "address/list";

    }

}