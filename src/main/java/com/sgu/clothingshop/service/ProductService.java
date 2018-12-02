package com.sgu.clothingshop.service;

import com.sgu.clothingshop.model.Product;
import com.sgu.clothingshop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService implements BasicCrudService<Product, Long> {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Iterable<Product> getAll() {
        return productRepository.findAll();
    }

    @Override
    public Product get(Long id) {
        return productRepository.getOne(id);
    }

    @Override
    public Product create(Product object) {
        return productRepository.save(object);
    }

    @Override
    public void delete(Product object) {
        object.setIsDeleted(true);
        productRepository.save(object);
    }

    @Override
    public Product update(Product object) {
        return productRepository.save(object);
    }

    public Iterable<Product> getAllAvailabel() {
        return productRepository.findAllByIsDeleted(false);
    }

    public Iterable<Product> findByBrand(Long brandId) {
        return productRepository.findAllByBrandIdAndIsDeleted(brandId, false);
    }

    public Iterable<Product> findByCategory(Long categoryId) {
        return productRepository.findAllByCategoryIdAndIsDeleted(categoryId, false);
    }
}
