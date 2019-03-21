package com.sgu.clothingshop.controller.admin;

import com.sgu.clothingshop.model.Order;
import com.sgu.clothingshop.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admin/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping
    public ModelAndView getAll() {
        ModelAndView modelAndView = new ModelAndView("admin-order");
        return modelAndView;
    }

    @GetMapping("all")
    @ResponseBody
    public Iterable<Order> all() {
        Iterable<Order> orders = orderService.getAll();
        return orders;
    }
}
