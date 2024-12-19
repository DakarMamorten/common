package com.wsh.controller.straff;

import com.wsh.service.StaffService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author "Vladyslav Paun"
 */
@Controller
@RequestMapping("/staff")
@RequiredArgsConstructor
public class StaffAddController {

    private final StaffService staffService;

    @PostMapping("/add")
    public String addStaff(@RequestParam("firstName") String firstName,
                           @RequestParam("lastName") String lastName,
                           @RequestParam("addressId") Long addressId,
                           @RequestParam("email") String email,
                           @RequestParam("storeId") Long storeId,
                           @RequestParam("active") Boolean active,
                           @RequestParam("username") String username,
                           @RequestParam("password") String password) {

        staffService.addStaff(firstName, lastName, addressId, email, storeId, active, username, password);

        return "redirect:/staff/list";
    }
}
