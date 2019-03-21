package com.sgu.clothingshop.service;

import com.sgu.clothingshop.model.Admin;
import com.sgu.clothingshop.repository.AdminRepository;
import com.sgu.clothingshop.util.PasswordUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

import static com.sgu.clothingshop.constant.SessionAttribute.SESSION_ADMIN;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    public String login(String username, String password, HttpSession session) {
        Admin admin = adminRepository.findTopByUsername(username);
        if (admin != null) {
            admin.setPassword(PasswordUtils.encrypt(password));
            if (admin.getPassword().equals(PasswordUtils.encrypt(password))) {
                session.setAttribute(SESSION_ADMIN, admin);
                return "Sign In Success";
            }
            return "Wrong password";
        }
        return "Email does not exist!";
    }
}
