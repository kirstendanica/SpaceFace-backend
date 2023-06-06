package com.spaceface.postsAPI.repository;

import com.spaceface.postsAPI.repository.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Integer> {
}