package com.wsh.controller.store;

import com.wsh.service.StoreService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/store")
@RequiredArgsConstructor
public class StoreAddController {

    private final StoreService storeService;

    @PostMapping("/add")
    public String add(
            final @RequestParam("managerStaffId") Long managerStaffId,
            final @RequestParam("addressId") Long addressId
    ) {
        storeService.addStore(managerStaffId, addressId);
        return "redirect:/store/list";
    }
}
