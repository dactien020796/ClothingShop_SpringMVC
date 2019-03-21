package com.sgu.clothingshop.controller.admin;

import com.sgu.clothingshop.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @GetMapping("/login")
    public ModelAndView login() {
        return new ModelAndView("admin-login");
    }

    @PostMapping("/login")
    @ResponseBody
    public String submitLogin(@RequestParam("username") String username,
                              @RequestParam("password") String password,
                              HttpSession session) {
        return adminService.login(username, password, session);
    }

    @GetMapping
    public ModelAndView hello() {
        return new ModelAndView("admin-test");
    }
}
