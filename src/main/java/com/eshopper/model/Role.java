package com.eshopper.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Role {
    ROLE_USER("user"),
    ROLE_MODERATOR("moderator"),
    ROLE_ADMIN("admin");

    private String name;
}

