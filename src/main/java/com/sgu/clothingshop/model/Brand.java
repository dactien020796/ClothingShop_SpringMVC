package com.sgu.clothingshop.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

/**
 * Brand entity.
 *
 * @author Tien Le
 */
@Entity(name = "Brand")
@Getter
@Setter
public class Brand {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "isDeleted")
    private Boolean isDeleted;

    @OneToMany(mappedBy = "brand")
    private List<Product> products = new ArrayList<>();
}
