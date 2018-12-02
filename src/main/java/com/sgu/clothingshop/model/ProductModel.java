package com.sgu.clothingshop.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Getter
@Setter
public class ProductModel {

    private Long id;

    private String name;

    private String description;

    private Long price;

    private MultipartFile[] images;

    private Long category;

    private Long brand;
}
