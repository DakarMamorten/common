package com.wsh.controller.country;


import com.wsh.service.CountryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/country")
@RequiredArgsConstructor
public class CountryEditController {
    private final CountryService countryService;

    @PostMapping("/update")
    public String update(final Long countryId, final String countryTitle){
        countryService.update(countryId,countryTitle);
        return "redirect:/country/list";
    }
}
