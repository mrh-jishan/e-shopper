package com.eshopper.payload.request;

import com.eshopper.model.PostStatus;
import lombok.*;

import java.time.Instant;
import java.util.List;

@Data
public class CreatePostRequest {

    private long userId;
    private List<CreateProductRequest> products;
    private String name;
    private String description;
    private PostStatus status;
    private Instant expiryDate;
}
