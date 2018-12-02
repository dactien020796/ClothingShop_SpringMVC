package com.sgu.clothingshop.service;

import com.sgu.clothingshop.model.ProductSize;
import com.sgu.clothingshop.repository.ProductSizeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductSizeService implements BasicCrudService<ProductSize, Long> {

    @Autowired
    private ProductSizeRepository productSizeRepository;

    @Override
    public Iterable<ProductSize> getAll() {
        return productSizeRepository.findAll();
    }

    @Override
    public ProductSize get(Long id) {
        return productSizeRepository.getOne(id);
    }

    @Override
    public ProductSize create(ProductSize object) {
        return productSizeRepository.save(object);
    }

    @Override
    public void delete(ProductSize object) {

    }

    @Override
    public ProductSize update(ProductSize object) {
        return productSizeRepository.save(object);
    }
}
