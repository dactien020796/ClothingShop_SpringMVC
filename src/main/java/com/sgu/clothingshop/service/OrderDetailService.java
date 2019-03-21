package com.sgu.clothingshop.service;

import com.sgu.clothingshop.model.OrderDetail;
import com.sgu.clothingshop.repository.OrderDetailRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderDetailService implements BasicCrudService<OrderDetail, Long> {

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    /*@Autowired
    private SessionFactory factory;*/

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

    /*public Iterable<Object[]> revenueByMonth() {
        return orderDetailRepository.revenueByMonth();
    }*/

    /*public List<Object[]> revenueBySanPham() {
        String hql = "SELECT d.sanPham.ten, SUM(d.donGia*d.soLuong*(1-d.khuyenMai)), "
                + "SUM(d.soLuong), MIN(d.donGia), MAX(d.donGia), AVG(d.donGia) "
                + "FROM CTHoaDon d GROUP BY d.sanPham.ten";
        Session session = factory.getCurrentSession();
        Query query = session.createQuery(hql);
        List<Object[]> list = query.list();
        return list;
    }*/
}
