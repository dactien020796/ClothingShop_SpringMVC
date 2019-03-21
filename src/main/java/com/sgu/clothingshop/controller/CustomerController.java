package com.sgu.clothingshop.controller;

import com.sgu.clothingshop.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

import static com.sgu.clothingshop.constant.SessionAttribute.SESSION_CUSTOMER;

@Controller
@RequestMapping("/account")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    // Register
    @ResponseBody
    @RequestMapping(value = "register", produces = "application/x-www-form-urlencoded;charset=UTF-8")
    public String register(@RequestParam("username") String username,
                           @RequestParam("address") String address,
                           @RequestParam("email") String email,
                           @RequestParam("name") String name,
                           @RequestParam("password") String password,
                           @RequestParam("phone") String phone) {
        String temp = customerService.register(username, address, email, name, password, phone);
        return temp;
    }

    // Sign In
    @ResponseBody
    @RequestMapping(value = "login", produces = "application/x-www-form-urlencoded;charset=UTF-8")
    public String login(@RequestParam("customerEmail") String email,
                        @RequestParam("customerPassword") String password,
                        HttpSession httpSession) {
        String temp = customerService.signIn(email, password, httpSession);
        return temp;
    }

    // Edit
    @RequestMapping("edit")
    public ModelAndView edit(HttpSession httpSession) {
        ModelAndView modelAndView = new ModelAndView("customer-detail");
        modelAndView.addObject("customer", httpSession.getAttribute(SESSION_CUSTOMER));
        return modelAndView;
    }
}
