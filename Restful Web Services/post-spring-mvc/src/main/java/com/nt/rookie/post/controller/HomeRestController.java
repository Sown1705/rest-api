package com.nt.rookie.post.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.nt.rookie.post.domain.Author;
import com.nt.rookie.post.service.AuthorService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.nt.rookie.post.domain.Post;
import com.nt.rookie.post.service.PostService;

@RestController
public class HomeRestController {
	private PostService postService;
	private AuthorService authorService;

	@Autowired
	public HomeRestController(PostService postService, AuthorService authorService) {
		this.postService = postService;
		this.authorService = authorService;
	}

	@GetMapping("/posts")
	public List<Post> searchPostByTitle(@RequestParam(name = "searchTerm", defaultValue = "") String searchTerm) {
		if (searchTerm == "") {
			return postService.getAllPosts();
		}
		return postService.search(searchTerm);
	}

	@GetMapping("/post/{id}")
	public Optional<Post> getPostDetail(@PathVariable(name = "id") String id) {
		return postService.searchById(Integer.parseInt(id));
	}

	@GetMapping("/post-getall")
	public List<Post> getAllPost() {
		return postService.getAllPosts();
	}
	@PostMapping("/post/create")
	public void createPost(@RequestBody @Valid Post newPost) {
		postService.savePost(newPost);
	}

	@PostMapping("/post/update")
	public void updatePost(@RequestBody @Valid Post updatePost) {
		postService.savePost(updatePost);
	}

	@DeleteMapping("/post/delete/{id}")
	public void deletePost(@PathVariable(name = "id") String id) {
		System.out.println("id"+ Integer.parseInt(id));
		 postService.deletePost(Integer.parseInt(id));
	}

	//author
	@PostMapping( "/authenticate")
	public String login(@RequestParam(name = "username", defaultValue = "") String username, @RequestParam(name = "password", defaultValue = "") String password) {
		List<Author> authorList = authorService.getAllAuthor();
		JSONObject jo = new JSONObject();
		authorList.stream()
				.filter(a->a.getUsername().toLowerCase().equals(username.toLowerCase()) && a.getPassword().equals(password))
				.map(a->{
					jo.put("username",a.getUsername());
					jo.put("password",a.getPassword());
					jo.put("added",a.getAdded());
					jo.put("email",a.getEmail());
					jo.put("birthdate",a.getBirthdate());
					jo.put("first_name",a.getFirstName());
					jo.put("last_name",a.getLastName());
					return jo;
				}).collect(Collectors.toList());

		System.out.println("hihi ---- "+ jo);

		return jo.toString();
	}
}
