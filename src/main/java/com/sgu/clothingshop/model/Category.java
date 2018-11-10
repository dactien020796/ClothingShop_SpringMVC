package com.sgu.clothingshop.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import java.util.ArrayList;
import java.util.List;

/**
 * Category entity.
 *
 * @author Tien Le
 */
@Entity(name = "Category")
@Getter
@Setter
public class Category {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "isDeleted")
    private Boolean isDeleted;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_category_id")
    private Category parentCategory;

    @OneToOne(mappedBy = "parentCategory", fetch = FetchType.LAZY)
    private Category childCategory;

    @OneToMany(mappedBy = "category")
    private List<Product> products = new ArrayList<>();
}
