package com.eshopper.payload.response;

import com.eshopper.model.PostStatus;
import lombok.Data;

import java.time.Instant;
import java.util.List;

@Data
public class PostResponse {
    private long userId;
    private List<ProductResponse> products;
    private String name;
    private String description;
    private PostStatus status;
    private Instant expiryDate;
}
