package com.sgu.clothingshop.controller;

import com.sgu.clothingshop.model.Product;
import com.sgu.clothingshop.model.ProductSize;
import com.sgu.clothingshop.model.Size;
import com.sgu.clothingshop.service.CategoryService;
import com.sgu.clothingshop.service.ProductService;
import com.sgu.clothingshop.service.ProductSizeService;
import com.sgu.clothingshop.service.SizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/{id}")
    public ModelAndView getDetail(@PathVariable(value = "id") Long id) {
        Product existedProduct = productService.get(id);
        if (existedProduct == null) {
            return new ModelAndView("404");
        }
        ModelAndView modelAndView = new ModelAndView("product-detail");
        modelAndView.addObject("product", existedProduct);
        modelAndView.addObject("sizes", getAllSize(existedProduct));
        modelAndView.addObject("brand", existedProduct.getBrand());
        return modelAndView;
    }

    private List<Size> getAllSize(Product product) {
        List<Size> sizeList = new ArrayList<>();
        for (ProductSize productSize : product.getProductSizes()) {
            sizeList.add(productSize.getSize());
        }
        return sizeList;
    }
}
