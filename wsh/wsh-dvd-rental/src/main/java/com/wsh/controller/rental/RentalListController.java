package com.wsh.controller.rental;

import com.wsh.service.RentalService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author "Vladyslav Paun"
 */
@Controller
@RequestMapping("/rental/list")
@RequiredArgsConstructor
public class RentalListController {

    private final RentalService rentalService;

    @GetMapping
    public String list(
            final Model model,
            @PageableDefault(value = 10, page = 0, sort = "rentalId") Pageable pageable) {
        model.addAttribute("rentals", rentalService.findAllInventories(pageable));
        return "rental/list";
    }
}
