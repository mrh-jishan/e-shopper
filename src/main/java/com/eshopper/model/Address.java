package com.eshopper.model;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "addresses")
@Getter
@NoArgsConstructor
public class Address extends DateAudit {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @NotBlank
    @Column
    private String address1;

    @Column
    private String address2;

    @Column
    private String address3;

    @NotBlank
    @Column
    private String city;

    @NotBlank
    @Column
    private String state;

    @NotBlank
    @Column
    private String country;

    @NotBlank
    @Column(name = "postal_code")
    private String postalCode;

    public Address(User user,
                   String address1,
                   String address2,
                   String address3,
                   String city,
                   String state,
                   String country,
                   String postalCode) {
        this.user = user;
        this.address1 = address1;
        this.address2 = address2;
        this.address3 = address3;
        this.city = city;
        this.state = state;
        this.country = country;
        this.postalCode = postalCode;
    }
}
