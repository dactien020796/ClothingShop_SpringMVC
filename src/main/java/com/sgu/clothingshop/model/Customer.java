package com.sgu.clothingshop.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

/**
 * Customer entity.
 *
 * @author Tien Le
 */
@Entity(name = "Customer")
@Getter
@Setter
public class Customer {

    @Id
    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

    @Column(name = "email")
    private String email;

    @Column(name = "phoneNumber")
    private String phoneNumber;

    @Column(name = "isVIP")
    private Boolean isVIP = false;

    @OneToMany(mappedBy = "customer")
    private List<Order> orders;
}
