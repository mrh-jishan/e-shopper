package com.eshopper.payload.request;

import lombok.Data;

@Data
public class CreateProductRequest {
    private String name;
    private String description;
    private double maxPrice;
    private double minPrice;
}
