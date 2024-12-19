package com.wsh.controller.store;

import com.wsh.service.StoreService;
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
@RequestMapping("/store/list")
@RequiredArgsConstructor
public class StoreListController {

    private final StoreService storeService;

    @GetMapping
    public String list(
            final Model model,
            @PageableDefault(value = 10, page = 0, sort = "storeId") Pageable pageable) {
        model.addAttribute("stores", storeService.findAllStores(pageable));
        return "store/list";
    }
}
