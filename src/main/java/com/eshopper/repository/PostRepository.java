package com.eshopper.repository;

import com.eshopper.model.Post;
import com.eshopper.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findAllByUser(final User user);
}
