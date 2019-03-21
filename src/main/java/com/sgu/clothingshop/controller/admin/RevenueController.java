package com.sgu.clothingshop.controller.admin;

import com.sgu.clothingshop.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("admin/revenue")
public class RevenueController {

    @Autowired
    private OrderDetailService orderDetailService;

    /*@ResponseBody
    @GetMapping("by-month")
    public Iterable<Object[]> byMonth() {
        return orderDetailService.revenueBySanPham();
    }*/
}
