package com.sgu.clothingshop.service;

import com.sgu.clothingshop.model.Customer;
import com.sgu.clothingshop.repository.CustomerRepository;
import com.sgu.clothingshop.util.PasswordUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

import static com.sgu.clothingshop.constant.SessionAttribute.SESSION_CUSTOMER;

@Service
public class CustomerService implements BasicCrudService<Customer, String> {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Iterable<Customer> getAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer get(String id) {
        return customerRepository.getOne(id);
    }

    @Override
    public Customer create(Customer object) {
        return customerRepository.save(object);
    }

    @Override
    public void delete(Customer object) {
        return;
    }

    @Override
    public Customer update(Customer object) {
        return customerRepository.save(object);
    }

    public String register(String username, String address, String email, String name, String password, String phone) {
        if (customerRepository.findCustomerByEmail(email) != null) {
            return "Email has been used! Please choose another email";
        }
        try {
            Customer customer = new Customer();
            customer.setUsername(username);
            customer.setAddress(address);
            customer.setEmail(email);
            customer.setName(name);
            customer.setPassword(PasswordUtils.encrypt(password));
            customer.setPhoneNumber(phone);
            customer.setIsVIP(false);
            customerRepository.save(customer);
            return "Register success";
        } catch (Exception e) {
            return "Register failed";
        }
    }
    public String signIn(String email, String password, HttpSession httpSession) {
        if (customerRepository.findCustomerByEmail(email) != null) {
            Customer customer = customerRepository.findCustomerByEmail(email);
            customer.setPassword(PasswordUtils.encrypt(password));
            if (customer.getPassword().equals(PasswordUtils.encrypt(password))) {
                httpSession.setAttribute(SESSION_CUSTOMER, customer);
                return "Sign In Success";
            }
            return "Wrong password";
        }
        return "Email does not exist. Please sign up!";
    }
}
