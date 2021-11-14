package com.eshopper.mapper;


import com.eshopper.model.Post;
import com.eshopper.model.Product;
import com.eshopper.payload.request.CreatePostRequest;
import com.eshopper.payload.request.CreateProductRequest;
import com.eshopper.payload.response.PostResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PostMapper {

    List<PostResponse> map(List<Post> posts);

    Post map(CreatePostRequest post);

    PostResponse map(Post post);

    Product map(CreateProductRequest value);
}
