package com.wsh.controller.country;

import com.wsh.service.CountryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/country")
@RequiredArgsConstructor
public class CountryDeleteController {
    private final CountryService countryService;

    @PostMapping("/delete")
    public String delete(final Long countryId){
        countryService.delete(countryId);
        return "redirect:/country/list";
    }
}
