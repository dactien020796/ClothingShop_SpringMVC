package com.sgu.clothingshop.controller;

import com.sgu.clothingshop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/{id}")
    public ModelAndView getDetail(@PathVariable(value = "id") Long id) {
        ModelAndView modelAndView = new ModelAndView("product-detail");
        modelAndView.addObject("product", productService.get(id));
        return modelAndView;
    }
}
