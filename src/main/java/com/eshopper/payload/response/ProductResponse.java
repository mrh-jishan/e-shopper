package com.eshopper.payload.response;

import lombok.Data;

@Data
public class ProductResponse {

    private long id;
    private String name;
    private String description;
    private double maxPrice;
    private double minPrice;
}
