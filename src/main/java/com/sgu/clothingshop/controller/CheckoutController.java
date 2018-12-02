package com.sgu.clothingshop.controller;

import com.sgu.clothingshop.model.Customer;
import com.sgu.clothingshop.model.Order;
import com.sgu.clothingshop.service.ConfigurationService;
import com.sgu.clothingshop.service.OrderService;
import com.sgu.clothingshop.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.Date;

@Controller
@RequestMapping("/check-out")
public class CheckoutController {

    @Autowired
    private ShoppingCartService shoppingCartService;

    @Autowired
    private ConfigurationService configurationService;

    @Autowired
    private OrderService orderService;

    @GetMapping
    public ModelAndView checkOut(HttpSession session) {
        ModelAndView modelAndView = new ModelAndView("check-out");
        modelAndView = calculateTotal(modelAndView, session);
        return modelAndView;
    }

    @PostMapping
    @ResponseBody
    public String submit(@RequestParam("name") String name,
                         @RequestParam("email") String email,
                         @RequestParam("address") String address,
                         @RequestParam("phone") String phone,
                         @RequestParam("total") Long total,
                         HttpSession session) {
        Order order = new Order();
        order.setName(name);
        order.setEmail(email);
        order.setAddress(address);
        order.setPhoneNumber(phone);
        order.setTotal(total);
        order.setSubmittedDate(new Date());
        order.setCustomer((Customer) session.getAttribute("customer"));
        try {
            orderService.purchase(order, shoppingCartService.getItems());
            shoppingCartService.clear(session);
            return "Order success";
        }
        catch (Exception e) {
            return "Error when submit order";
        }
    }

    public ModelAndView calculateTotal(ModelAndView modelAndView, HttpSession session) {
        Integer notionalPrice = shoppingCartService.getAmount();
        Integer discountPercent = 0;
        Long discount = Long.valueOf(0);
        Long total = Long.valueOf(shoppingCartService.getAmount());
        Customer customer = (Customer) session.getAttribute("customer");
        if (customer != null && customer.getIsVIP()) {
            discountPercent = configurationService.getVipPercentDiscount();
        }

        if (discountPercent != 0) {
            discount = Long.valueOf(notionalPrice * (discountPercent / 100));
        }

        if (discount != 0) {
            total = notionalPrice - discount;
        }

        modelAndView.addObject("notionalPrice", notionalPrice);
        modelAndView.addObject("discount", discount);
        modelAndView.addObject("total", total);
        return modelAndView;
    }
}
