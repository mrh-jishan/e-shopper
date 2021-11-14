package com.eshopper.service;

import com.eshopper.mapper.PostMapper;
import com.eshopper.model.Post;
import com.eshopper.model.User;
import com.eshopper.payload.request.CreatePostRequest;
import com.eshopper.payload.response.PostResponse;
import com.eshopper.repository.PostRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class PostService {

    private final PostRepository postRepository;
    private final PostMapper postMapper;


    public List<PostResponse> index(final User user) {
        List<Post> posts = postRepository.findAllByUser(user);
        return postMapper.map(posts);
    }

    public PostResponse create(CreatePostRequest request) {
        Post post = postMapper.map(request);
        Post save = postRepository.save(post);
        return postMapper.map(save);
    }

}
