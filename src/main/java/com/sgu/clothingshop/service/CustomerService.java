package com.sgu.clothingshop.service;

import com.sgu.clothingshop.model.Customer;
import com.sgu.clothingshop.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
public class CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    public String register(String username, String address, String email, String name, String password,
                           String phone, HttpServletRequest request) {
        if (customerRepository.findCustomerByEmail(email) != null) {
            return "Email has been used! Please choose another email";
        }
        try {
            Customer customer = new Customer();
            customer.setUsername(username);
            customer.setAddress(address);
            customer.setEmail(email);
            customer.setName(name);
            customer.setPassword(password);
            customer.setPhoneNumber(phone);
            customer.setIsVIP(false);
            customerRepository.save(customer);
            return "Register success";
        } catch (Exception e) {
            return "Register failed";
        }
    }

}
