package com.eshopper.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "carts")
@Getter
@NoArgsConstructor
public class Cart extends DateAudit {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;



//    @ManyToMany(fetch = FetchType.EAGER)
//    @JoinTable(
//            name = "cart_orders",
//            joinColumns = @JoinColumn(name = "cart_id"),
//            inverseJoinColumns = @JoinColumn(name = "order_id")
//    )
//    @Setter
//    private Set<Order> orders;
}
