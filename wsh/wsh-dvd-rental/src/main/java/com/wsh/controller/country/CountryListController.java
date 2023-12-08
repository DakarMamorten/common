package com.wsh.controller.country;

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
@RequestMapping("/country")
@RequiredArgsConstructor
public class CountryListController {
    private final CountryService countryService;

    @GetMapping("/list")
    public String list(Model model,
        @RequestParam(value = "page", required = false, defaultValue = "0") int page,
        @PageableDefault(value = 10, page = 0, sort = "countryId") Pageable pageable) {
        model.addAttribute("countries", countryService.findAll(pageable));
    return "country/list";
    }
}
