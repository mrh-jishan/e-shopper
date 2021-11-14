package com.eshopper.mapper;

import com.eshopper.model.Product;
import com.eshopper.payload.request.CreateProductRequest;
import com.eshopper.payload.response.ProductResponse;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    List<ProductResponse> map(List<Product> products);

    Product map(CreateProductRequest product);

    ProductResponse map(Product product);
}
