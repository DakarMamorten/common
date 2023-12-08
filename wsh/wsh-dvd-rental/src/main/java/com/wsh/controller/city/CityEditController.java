package com.wsh.controller.city;

import com.wsh.service.CityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 *@author "Vladyslav Paun"
 */
@Controller
@RequestMapping("/city")
@RequiredArgsConstructor
public class CityEditController {
    private final CityService cityService;

    @PostMapping("/update")
    public String update(final Long cityId, final String cityTitle,final Long countryId){
        cityService.update(cityId,cityTitle,countryId);
        return "redirect:/city/list";
    }
}
