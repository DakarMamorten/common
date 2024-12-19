package com.wsh.controller.inventory;

import com.wsh.service.InventoryService;
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
@RequestMapping("/inventory/list")
@RequiredArgsConstructor
public class InventoryListController {

    private final InventoryService inventoryService;

    @GetMapping
    public String list(
            final Model model,
            @PageableDefault(value = 10, page = 0, sort = "inventoryId") Pageable pageable) {
        model.addAttribute("inventories", inventoryService.findAllInventories(pageable));
        return "inventory/list";
    }
}
