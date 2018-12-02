package com.sgu.clothingshop.service;

import com.sgu.clothingshop.model.Item;
import com.sgu.clothingshop.model.Order;
import com.sgu.clothingshop.model.OrderDetail;
import com.sgu.clothingshop.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
public class OrderService implements BasicCrudService<Order, Long> {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderDetailService orderDetailService;

    @Override
    public Iterable<Order> getAll() {
        return orderRepository.findAll();
    }

    @Override
    public Order get(Long id) {
        return orderRepository.getOne(id);
    }

    @Override
    public Order create(Order object) {
        return orderRepository.save(object);
    }

    @Override
    public void delete(Order object) {
        return;
    }

    @Override
    public Order update(Order object) {
        return orderRepository.save(object);
    }

    public void purchase(Order order, Collection<Item> cart) {
        create(order);
        for (Item item : cart) {
            OrderDetail orderDetail = new OrderDetail();
            orderDetail.setOrder(order);
            orderDetail.setProduct(item.getProduct());
            orderDetail.setQuantity(item.getQuantity());
            orderDetail.setPrice(item.getProduct().getPrice());
            orderDetail.setSize(item.getSize());
            orderDetailService.create(orderDetail);
        }
    }
}
