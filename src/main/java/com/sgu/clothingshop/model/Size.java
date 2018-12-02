package com.sgu.clothingshop.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

/**
 * Size entity.
 *
 * @author Tien Le
 */
@Entity(name = "Size")
@Getter
@Setter
public class Size {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(name = "size")
    private String size;

    @OneToMany(mappedBy = "size")
    private List<ProductSize> productSizes;

    @OneToMany(mappedBy = "size")
    private List<OrderDetail> orderDetails;
}
