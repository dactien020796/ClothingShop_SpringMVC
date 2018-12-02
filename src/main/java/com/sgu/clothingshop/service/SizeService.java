package com.sgu.clothingshop.service;

import com.sgu.clothingshop.model.Size;
import com.sgu.clothingshop.repository.SizeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SizeService implements BasicCrudService<Size, Long> {

    @Autowired
    private SizeRepository sizeRepository;

    @Override
    public Iterable<Size> getAll() {
        return sizeRepository.findAll();
    }

    @Override
    public Size get(Long id) {
        return sizeRepository.getOne(id);
    }

    @Override
    public Size create(Size object) {
        return sizeRepository.save(object);
    }

    @Override
    public void delete(Size object) {

    }

    @Override
    public Size update(Size object) {
        return sizeRepository.save(object);
    }
}
