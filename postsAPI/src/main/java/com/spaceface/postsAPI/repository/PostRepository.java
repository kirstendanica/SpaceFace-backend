package com.spaceface.postsAPI.repository;

import com.spaceface.postsAPI.repository.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

// This will be AUTO IMPLEMENTED by Spring into a Bean called itemRepository
// CRUD refers Create, Read, Update, Delete
public interface PostRepository extends JpaRepository<Post, Integer> {
}