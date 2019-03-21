package com.sgu.clothingshop.controller;

import com.sgu.clothingshop.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

import static com.sgu.clothingshop.constant.SessionAttribute.SESSION_CART;

@Controller
@RequestMapping("/cart")
public class ShoppingCartController {

    @Autowired
    private ShoppingCartService shoppingCartService;

    @ResponseBody
    @GetMapping("add")
    public String add(@RequestParam("id") Long id,
                      @RequestParam("sizeId") Long sizeId,
                      @RequestParam("qty") Integer qty,
                      HttpSession session) {
        shoppingCartService.add(id, sizeId, qty, session);
        return String.format("%d", shoppingCartService.getCount());
    }

    @ResponseBody
    @GetMapping("update")
    public String update(@RequestParam("id") Long id,
                         @RequestParam("sizeId") Long sizeId,
                         @RequestParam("qty") Integer qty,
                         HttpSession session) {
        shoppingCartService.update(id, sizeId, qty, session);
        return String.format("%d", shoppingCartService.getCount());
    }

    @ResponseBody
    @GetMapping("remove")
    public String remove(@RequestParam("id") Long id,
                         @RequestParam("sizeId") Long sizeId,
                         HttpSession session) {
        shoppingCartService.remove(id, sizeId, session);
        return "Product removed from cart";
    }

    @ResponseBody
    @GetMapping("clear")
    public String clear(HttpSession session) {
        shoppingCartService.clear(session);
        return "Removed all products in cart";
    }

    @ResponseBody
    @GetMapping("get-amount")
    public int getAmount() {
        return shoppingCartService.getAmount();
    }

    @ResponseBody
    @GetMapping("get-count")
    public int getCount() {
        return shoppingCartService.getCount();
    }

    @GetMapping("view")
    public ModelAndView viewCart(HttpSession session) {
        ModelAndView modelAndView = new ModelAndView("cart-detail");
        modelAndView.addObject("items", session.getAttribute(SESSION_CART));
        return modelAndView;
    }
}
