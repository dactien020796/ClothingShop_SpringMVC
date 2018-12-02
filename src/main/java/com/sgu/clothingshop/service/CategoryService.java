package com.sgu.clothingshop.service;

import com.sgu.clothingshop.model.Category;
import com.sgu.clothingshop.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService implements BasicCrudService<Category, Long> {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Iterable<Category> getAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category get(Long id) {
        return categoryRepository.getOne(id);
    }

    @Override
    public Category create(Category object) {
        return categoryRepository.save(object);
    }

    @Override
    public void delete(Category object) {
        object.setIsDeleted(true);
        categoryRepository.save(object);
    }

    @Override
    public Category update(Category object) {
        return categoryRepository.save(object);
    }

    public Iterable<Category> getAllSubCategory(Boolean isDeleted) {
        return categoryRepository.findAllByIsDeletedAndParentCategoryIsNotNull(isDeleted);
    }
}
