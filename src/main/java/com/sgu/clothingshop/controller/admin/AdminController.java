package com.sgu.clothingshop.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @GetMapping("/login")
    public ModelAndView login() {
        return new ModelAndView("admin-login");
    }

    @GetMapping
    public ModelAndView hello() {
        return new ModelAndView("admin-test");
    }
}
