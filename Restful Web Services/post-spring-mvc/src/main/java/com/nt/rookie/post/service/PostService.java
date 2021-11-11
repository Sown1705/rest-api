package com.nt.rookie.post.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Service;

import com.nt.rookie.post.data.PostRepository;
import com.nt.rookie.post.domain.Post;

@Service
public class PostService {

	private PostRepository postRepository;

	@Autowired
	public PostService(PostRepository postRepository) {
		this.postRepository = postRepository;
	}

	public List<Post> getAllPosts() {
		return postRepository.findAll();
	}

	public List<Post> search(String searchTerm) {
		// TODO Auto-generated method stub
		System.out.println(searchTerm);
		return getAllPosts().stream().filter(p -> p.getTitle().toLowerCase().contains(searchTerm))
				.collect(Collectors.toList());
	}

	public Optional<Post> searchById(int id) {
		return postRepository.findById(id);
	}

	public Post savePost(Post newPost) {
		return postRepository.save(newPost);
	}

	public void deletePost(Integer id) {
		postRepository.deleteById(id);
	}

}
