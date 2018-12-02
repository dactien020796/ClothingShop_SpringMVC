package com.sgu.clothingshop.service;

import com.sgu.clothingshop.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class ShoppingCartService {

    @Autowired
    private ProductService productService;

    @Autowired
    private SizeService sizeService;

    private List<Item> cart = new ArrayList<>();

    public void add(Long id, Long sizeId, Integer qty, HttpSession session) {
        if (session.getAttribute("cart") == null) {
            cart.add(new Item(productService.get(id), sizeService.get(sizeId), qty));
        } else {
            cart = (List<Item>) session.getAttribute("cart");
            int index = isExisting(id, sizeId);
            if (index == -1)
                cart.add(new Item(productService.get(id), sizeService.get(sizeId), qty));
            else {
                int quantity = cart.get(index).getQuantity() + qty;
                cart.get(index).setQuantity(quantity);
            }
        }
        session.setAttribute("cart", cart);
    }

    public void update(Long id, Long sizeId, Integer newQuantity, HttpSession session) {
        int index = isExisting(id, sizeId);
        if (index != -1) {
            cart.get(index).setQuantity(newQuantity);
            session.setAttribute("cart", cart);
        }
    }

    public void remove(Long id, Long sizeId, HttpSession session) {
        int index = isExisting(id, sizeId);
        if (index != -1) {
            cart.remove(index);
        }
        session.setAttribute("cart", cart);
    }

    public void clear(HttpSession session) {
        cart.clear();
        session.setAttribute("cart", null);
    }

    public Collection<Item> getItems() {
        return cart;
    }

    public Item getItem(Long productId) {
        for (Item item : getItems()) {
            if (item.getProduct().getId() == productId) {
                return item;
            }
        }
        return null;
    }

    public int getCount() {
        int total =0 ;
        for(Item item : getItems()) {
            total += item.getQuantity();
        }
        return total;
    }

    public int getAmount() {
        int total =0 ;
        for(Item item : getItems()) {
            total += item.getQuantity() * item.getProduct().getPrice();
        }
        return total;
    }

    private int isExisting(Long id, Long sizeId) {
        for (int i = 0; i < cart.size(); i++) {
            if (cart.get(i).getProduct().getId() == id && cart.get(i).getSize().getId() == sizeId) {
                return i;
            }
        }
        return -1;
    }
}
