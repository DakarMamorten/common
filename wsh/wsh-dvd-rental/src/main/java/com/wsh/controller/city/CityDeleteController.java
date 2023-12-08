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
public class CityDeleteController {
    private final CityService cityService;
    @PostMapping("/delete")
    public String delete(final Long cityId){
        cityService.delete(cityId);
        return "redirect:/city/list";
    }
}
