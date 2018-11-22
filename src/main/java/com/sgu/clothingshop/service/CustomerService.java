package com.sgu.clothingshop.service;

import com.sgu.clothingshop.model.Customer;
import com.sgu.clothingshop.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

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
            customer.setPassword(passwordEncryption(password));
            customer.setPhoneNumber(phone);
            customer.setIsVIP(false);
            customerRepository.save(customer);
            return "Register success";
        } catch (Exception e) {
            return "Register failed";
        }
    }

    public String signIn(String email, String password,
                           HttpSession httpSession) {
        if (customerRepository.findCustomerByEmail(email) != null) {
            Customer customer = customerRepository.findCustomerByEmail(email);
            customer.setPassword(passwordEncryption(password));
            if (customer.getPassword().equals(passwordEncryption(password))) {
                httpSession.setAttribute("customer", customer);
                return "Sign In success";
            }
            return "Wrong password";
        }
        return "Email does not exist. Please sign up!";
    }

    //MD5 encryption
    private String passwordEncryption(String password) {
        String generatedPassword = null;
        try {
            // Create MessageDigest instance for MD5
            MessageDigest md = MessageDigest.getInstance("MD5");
            //Add password bytes to digest
            md.update(password.getBytes());
            //Get the hash's bytes
            byte[] bytes = md.digest();
            //This bytes[] has bytes in decimal format;
            //Convert it to hexadecimal format
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < bytes.length; i++) {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            //Get complete hashed password in hex format
            generatedPassword = sb.toString();
        } catch (NoSuchAlgorithmException e) {
            generatedPassword = "";
            e.printStackTrace();
        }
        return generatedPassword;
    }


}
