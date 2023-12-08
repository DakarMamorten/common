package com.wsh.controller.country;

import com.wsh.service.CountryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 *@author "Vladyslav Paun"
 */
@Controller
@RequestMapping("/country")
@RequiredArgsConstructor
public class CountryAddController {
    private final CountryService countryService;

    @PostMapping("/add")
    public String add(final String countryTitle){
        countryService.add(countryTitle);
        return "redirect:/country/list";
    }
}
