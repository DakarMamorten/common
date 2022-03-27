package com.wsh.controller.calculator;

import com.wsh.domain.Calculator;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * @author "Vladyslav Paun"
 */
@Controller
@RequestMapping("/calculator")
public class WebCalculatorController {

    @GetMapping(value = "/web")
    public String getCalculator() {
        return "/calculator/main";
    }

    @PostMapping(value = "/web")
    public String doCalculator(Calculator calculator,
                               RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("result",
                                             calculator.calc());
        return "redirect:/calculator/web";
    }

}
