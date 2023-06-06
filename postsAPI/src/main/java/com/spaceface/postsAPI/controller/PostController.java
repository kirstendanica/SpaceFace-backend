package com.spaceface.postsAPI.controller;

import com.spaceface.postsAPI.repository.entity.Post;
import com.spaceface.postsAPI.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/post")
public class PostController {
    @Autowired
    private PostService postService;

    @GetMapping
    public Iterable<Post> getPosts() {
        return postService.all();
    }

    @PostMapping
    public Post createPost(@RequestBody Post newPost) {
        return postService.save(newPost);
    }

    @GetMapping("/{id}")
    public Optional<Post> getPostById(@PathVariable int id) {
        return postService.findById(id);
    }

    @PutMapping("/{id}")
    public Post updatePost(@RequestBody Post updatedPost, @PathVariable int id) {
        return postService.findById(id)
                .map(post -> {
                    post.setTitle(updatedPost.getTitle());
                    post.setContent(updatedPost.getContent());
                    post.setAuthor(updatedPost.getAuthor());
                    return postService.save(post);
                })
                .orElseGet(() -> {
                    updatedPost.setId(id);
                    return postService.save(updatedPost);
                });
    }

    @DeleteMapping("/{id}")
    public void deletePost(@PathVariable int id) {
        postService.delete(id);
    }
}