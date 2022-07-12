package com.wsh.controller.city;

import com.wsh.service.CityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/city")
@RequiredArgsConstructor
public class CityAddController {
    private final CityService cityService;

    @PostMapping("/add")
    public String add(final String cityTitle,final Long countryId){
        cityService.add(cityTitle,countryId);
        return "redirect:/city/list";
    }
}
