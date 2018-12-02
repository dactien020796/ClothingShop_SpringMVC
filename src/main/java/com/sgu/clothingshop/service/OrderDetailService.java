package com.sgu.clothingshop.service;

import com.sgu.clothingshop.model.OrderDetail;
import com.sgu.clothingshop.repository.OrderDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderDetailService implements BasicCrudService<OrderDetail, Long> {

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Override
    public Iterable<OrderDetail> getAll() {
        return orderDetailRepository.findAll();
    }

    @Override
    public OrderDetail get(Long id) {
        return orderDetailRepository.getOne(id);
    }

    @Override
    public OrderDetail create(OrderDetail object) {
        return orderDetailRepository.save(object);
    }

    @Override
    public void delete(OrderDetail object) {
        return;
    }

    @Override
    public OrderDetail update(OrderDetail object) {
        return orderDetailRepository.save(object);
    }
}
