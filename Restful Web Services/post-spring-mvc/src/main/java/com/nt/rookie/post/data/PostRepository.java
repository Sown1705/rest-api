package com.nt.rookie.post.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nt.rookie.post.domain.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {

}
