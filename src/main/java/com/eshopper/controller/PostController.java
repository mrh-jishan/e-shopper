package com.eshopper.controller;

import com.eshopper.model.User;
import com.eshopper.payload.request.CreatePostRequest;
import com.eshopper.payload.response.PostResponse;
import com.eshopper.service.PostService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@RequestMapping("/v1/posts")
@RestController
@Validated
@AllArgsConstructor
public class PostController {

    private final PostService postService;

    @GetMapping(path = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<PostResponse> index(Principal  user) {
//         "Public Content.";
        System.out.println("user"+ user.toString());
//        final User user = (User) principal;
        return postService.index((User) user);

    }

    @PostMapping(path = "/", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public PostResponse create(@Valid @RequestBody CreatePostRequest request) {
//        return "Public Content.";
        return postService.create(request);
    }
}
