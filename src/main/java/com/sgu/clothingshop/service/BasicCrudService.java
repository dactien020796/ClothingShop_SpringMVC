package com.sgu.clothingshop.service;

public interface BasicCrudService<T, IdType> {

    Iterable<T> getAll();

    T get(IdType id);

    T create(T object);

    void delete(T object);

    T update(T object);
}
