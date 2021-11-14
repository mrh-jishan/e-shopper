package com.eshopper.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "products")
@Getter
@NoArgsConstructor
public class Product extends DateAudit {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne(fetch = FetchType.EAGER)
    private Post post;

    @Column
    private String name;

    @Column
    private String description;

    @Column(name = "max_price")
    private double maxPrice;

    @Column(name = "min_price")
    private double minPrice;

}
