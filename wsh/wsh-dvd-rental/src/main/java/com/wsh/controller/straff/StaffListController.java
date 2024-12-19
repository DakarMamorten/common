package com.wsh.controller.straff;

import com.wsh.domain.Staff;
import com.wsh.service.StaffService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author "Vladyslav Paun"
 */
@Controller
@RequestMapping("/staff")
@RequiredArgsConstructor
public class StaffListController {

    private final StaffService staffService;


    @GetMapping
    @RequestMapping("/list")
    public String list(
            final Model model,
            @PageableDefault(value = 10, page = 0, sort = "staffId") Pageable pageable) {
        model.addAttribute("staff", staffService.findAllStaff(pageable));
        return "staff/list";
    }

    @GetMapping("/list2")
    public String listStaff(Model model, @RequestParam(defaultValue = "0") int page) {
        Page<Staff> staffPage = staffService.getStaffPage(page);
        model.addAttribute("staff", staffPage.getContent());
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", staffPage.getTotalPages());
        return "staff/list";
    }
}
