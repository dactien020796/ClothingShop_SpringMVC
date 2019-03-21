package com.sgu.clothingshop.controller.admin;

import com.sgu.clothingshop.model.Product;
import com.sgu.clothingshop.model.ProductModel;
import com.sgu.clothingshop.service.BrandService;
import com.sgu.clothingshop.service.CategoryService;
import com.sgu.clothingshop.service.ProductService;
import com.sgu.clothingshop.service.SizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Controller
@RequestMapping("/admin/products")
public class ProductManagementController {

    private static final String PRODUCT_IMAGE_PATH = "/images";

    @Autowired
    private ServletContext app;

    @Autowired
    private ProductService productService;

    @Autowired
    private BrandService brandService;

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public ModelAndView getAll() {
        ModelAndView modelAndView = new ModelAndView("admin-product");
        modelAndView.addObject("products", productService.getAll());
        modelAndView.addObject("brands", brandService.getAll());
        modelAndView.addObject("categories", categoryService.getAllSubCategory(false));
        return modelAndView;
    }

    @PostMapping
    @ResponseBody
    public String createProduct(@ModelAttribute ProductModel productModel) {
        try {
            if (productModel.getId() == null) {
                Product product = convertToProduct(productModel);
                product.setImage1(uploadImage(productModel.getImages(), 0));
                product.setImage2(uploadImage(productModel.getImages(), 1));
                product.setImage3(uploadImage(productModel.getImages(), 2));
                product.setImage4(uploadImage(productModel.getImages(), 3));
                productService.create(product);
            } else {
                Product modifiedProduct = this.updateProduct(productModel);
                productService.update(modifiedProduct);
            }
            return "Success";
        } catch (Exception e) {
            return "Error when save product";
        }
    }

    private Product convertToProduct(ProductModel productModel) {
        Product product = new Product();
        product.setName(productModel.getName());
        product.setDescription(productModel.getDescription());
        product.setPrice(productModel.getPrice());
        product.setBrand(brandService.get(productModel.getBrand()));
        product.setCategory(categoryService.get(productModel.getCategory()));
        product.setIsDeleted(false);
        return product;
    }

    private String uploadImage(MultipartFile[] images, Integer index) throws IOException {
        String path = String.format("%s/%s.png", PRODUCT_IMAGE_PATH, UUID.randomUUID());
        String uploadFilePath = app.getRealPath(path);
        images[index].transferTo(new File(uploadFilePath));
        return path;
    }

    private Product updateProduct(ProductModel productModel) {
        Product existedProduct = productService.get(productModel.getId());
        existedProduct.setName(productModel.getName());
        existedProduct.setDescription(productModel.getDescription());
        existedProduct.setPrice(productModel.getPrice());
        existedProduct.setBrand(brandService.get(productModel.getBrand()));
        existedProduct.setCategory(categoryService.get(productModel.getCategory()));
        return existedProduct;
    }
}
