package com.eshopper.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@Entity
@Table(name = "roles")
@NoArgsConstructor
@Getter
public class Roles implements GrantedAuthority {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 20, unique = true)
    @Enumerated(EnumType.STRING)
    private Role name;

    @Override
    public String getAuthority() {
        return this.name.name();
    }
}
