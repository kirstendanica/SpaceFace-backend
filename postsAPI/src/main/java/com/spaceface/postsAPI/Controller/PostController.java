package com.spaceface.postsAPI.Controller;

import java.util.Optional;
import com.spaceface.postsAPI.repository.PostRepository;
import com.spaceface.postsAPI.repository.entity.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/post")
public class PostController {

    final PostRepository postRepository;

    @Autowired
    public PostController(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @GetMapping
    public Iterable<Post> getPosts() {
        return postRepository.findAll();
    }

    @PostMapping
    public Post createPost(@RequestBody Post newPost) {
        return postRepository.save(newPost);
    }

    @PutMapping("/{id}")
    public Post updatePost(@PathVariable Integer id, @RequestBody Post updatedPost) {
        return postRepository.findById(id)
                .map(post -> {
                    post.setTitle(updatedPost.getTitle());
                    post.setContent(updatedPost.getContent());
                    return postRepository.save(post);
                })
                .orElseGet(() -> {
                    updatedPost.setId(id);
                    return postRepository.save(updatedPost);
                });
    }

    @DeleteMapping("/{id}")
    public void deletePost(@PathVariable Integer id) {
        postRepository.deleteById(id);
    }

    @GetMapping("/{id}")
    public Optional<Post> getPost(@PathVariable Integer id) {
        return postRepository.findById(id);
    }
}