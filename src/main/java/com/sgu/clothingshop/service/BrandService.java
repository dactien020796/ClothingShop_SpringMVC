package com.sgu.clothingshop.service;

import com.sgu.clothingshop.model.Brand;
import com.sgu.clothingshop.repository.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BrandService implements BasicCrudService<Brand, Long> {

    @Autowired
    private BrandRepository brandRepository;

    @Override
    public Iterable<Brand> getAll() {
        return brandRepository.findAll();
    }

    @Override
    public Brand get(Long id) {
        return brandRepository.getOne(id);
    }

    @Override
    public Brand create(Brand object) {
        return brandRepository.save(object);
    }

    @Override
    public void delete(Brand object) {
        object.setIsDeleted(true);
        brandRepository.save(object);
    }

    @Override
    public Brand update(Brand object) {
        return brandRepository.save(object);
    }
}
