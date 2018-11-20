package com.sgu.clothingshop.controller;

import com.sgu.clothingshop.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

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
                           @RequestParam("phone") String phone,
                           HttpServletRequest request) {
        String temp = customerService.register(username, address, email, name, password, phone, request);
        return temp;
    }

}
