package com.spaceface.postsAPI.service;
import com.spaceface.postsAPI.repository.entity.Post;
import com.spaceface.postsAPI.repository.PostRepository;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {
    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public Post save(Post post) {
        return postRepository.save(post);
    }

    public void delete(int postId) {
        postRepository.deleteById(postId);
    }

    public List<Post> all() {
        return postRepository.findAll();
    }

    public Optional<Post> findById(int postId) {
        return postRepository.findById(postId);
    }
}