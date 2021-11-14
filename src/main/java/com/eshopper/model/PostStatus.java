package com.eshopper.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum PostStatus {
    EXPIRED(-2),
    DRAFT(-1),
    CREATED(0),
    OFFERED(1),
    ACCEPTED(2),
    ORDERED(3),
    PAID(4),
    COMPLETED(5);

    private int code;
}
