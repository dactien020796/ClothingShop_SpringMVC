package com.sgu.clothingshop.controller.admin;

import com.sgu.clothingshop.model.Brand;
import com.sgu.clothingshop.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/admin/brands")
public class BrandManagementController {

    @Autowired
    private BrandService brandService;

    @GetMapping
    public ModelAndView brand() {
        ModelAndView modelAndView = new ModelAndView("admin-brand");
        modelAndView.addObject("brands", brandService.getAll());
        return modelAndView ;
    }

    @PostMapping
    @ResponseBody
    public String saveBrand(@RequestBody Brand brand) {
        try {
            if (brand.getId() == null) {
                brandService.create(brand);
            } else {
                brandService.update(brand);
            }
            return "Success";
        } catch (Exception e) {
            return "Error when save brand";
        }
    }

    @PostMapping("/delete")
    @ResponseBody
    public String deleteBrand(@RequestBody Brand brand) {
        try {
            brandService.delete(brand);
            return "Success";
        } catch (Exception e) {
            return "Error when delete brand";
        }
    }
}
