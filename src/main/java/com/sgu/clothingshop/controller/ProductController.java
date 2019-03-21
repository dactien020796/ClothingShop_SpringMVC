package com.sgu.clothingshop.controller;

import com.sgu.clothingshop.model.Product;
import com.sgu.clothingshop.model.ProductSize;
import com.sgu.clothingshop.model.Size;
import com.sgu.clothingshop.service.BrandService;
import com.sgu.clothingshop.service.CategoryService;
import com.sgu.clothingshop.service.ProductService;
import com.sgu.clothingshop.service.ProductSizeService;
import com.sgu.clothingshop.service.SizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private BrandService brandService;

    @Autowired
    private CategoryService categoryService;

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
        modelAndView.addObject("title", "Product Detail");
        return modelAndView;
    }

    @GetMapping("search")
    @ResponseBody
    public Iterable<Product> findByName(@RequestParam("name") String name) {
        return productService.findByName(name);
    }

    @GetMapping("by-brand")
    public ModelAndView getByBrand(@RequestParam("brandId") Long brandId) {
        ModelAndView modelAndView = new ModelAndView("home");
        modelAndView.addObject("products", productService.findByBrand(brandId));
        modelAndView.addObject("title", String.format("Products of %s", brandService.get(brandId).getName()));
        return modelAndView;
    }

    @GetMapping("by-category")
    public ModelAndView getByCategory(@RequestParam("categoryId") Long categoryId) {
        ModelAndView modelAndView = new ModelAndView("home");
        modelAndView.addObject("products", productService.findByCategory(categoryId));
        modelAndView.addObject("title", String.format("%s Products", categoryService.get(categoryId).getName()));
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
