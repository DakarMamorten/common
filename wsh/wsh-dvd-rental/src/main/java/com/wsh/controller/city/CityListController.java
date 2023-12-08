package com.wsh.controller.city;

import com.wsh.service.CityService;
import com.wsh.service.CountryService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
/**
 *@author "Vladyslav Paun"
 */
@Controller
@RequestMapping("/city")
@RequiredArgsConstructor
public class CityListController {
    private final CityService cityService;
    private final CountryService countryService;

    @GetMapping("/list")
    public String list(Model model,
                           @RequestParam(value = "page", required = false, defaultValue = "0") int page,
                           @PageableDefault(value = 10, page = 0, sort = "cityId") Pageable pageable) {
        model.addAttribute("cities", cityService.findAll(pageable));
        model.addAttribute("countries", countryService.findAll());
        return "city/list";
    }
}
