package com.eshopper.repository;

import com.eshopper.model.Post;
import com.eshopper.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findAllByPost(final Post post);
}
