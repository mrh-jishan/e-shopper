package com.eshopper.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.Instant;
import java.util.List;

@Entity
@Table(name = "posts")
@Getter
@NoArgsConstructor
public class Post extends DateAudit {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(
            mappedBy = "post",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.EAGER
    )
    private List<Product> products;

    @OneToOne(mappedBy = "post",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            optional = false)
    private Order order;

    @Column(nullable = false)
    @Size(max = 150, min = 10)
    private String name;

    @Column(nullable = false)
    @Size(max = 512, min = 120)
    private String description;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private PostStatus status;

    @Column(name = "expiry_date", nullable = false)
    private Instant expiryDate;


}
