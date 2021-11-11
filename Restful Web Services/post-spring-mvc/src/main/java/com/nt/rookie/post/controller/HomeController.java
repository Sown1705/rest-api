package com.nt.rookie.post.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.nt.rookie.post.domain.Post;
import com.nt.rookie.post.service.PostService;

@Controller
public class HomeController {

	private PostService postService;

	@Autowired
	public HomeController(PostService postService) {
		this.postService = postService;
	}

	@GetMapping("home")
	public ModelAndView getHome(@RequestParam(name = "searchTerm", required = false) String searchTerm) {
		ModelAndView modelAndView = new ModelAndView("home");
		List<Post> result = postService.search(searchTerm);
		modelAndView.addObject("posts", result);
		System.out.println(result);
		return modelAndView;
	}

	@GetMapping("postdetails")
	public ModelAndView getPostDetail(@RequestParam(name = "id") String id) {
		ModelAndView modelAndView = new ModelAndView("postDetail");
		modelAndView.addObject("post", postService.searchById(Integer.parseInt(id)));
		return modelAndView;
	}

	@GetMapping("postedit")
	public ModelAndView getPostEdit(@RequestParam(name = "id") String id) {
		ModelAndView modelAndView = new ModelAndView("postEdit");
		modelAndView.addObject("post", postService.searchById(Integer.parseInt(id)));
		return modelAndView;
	}

	@PostMapping("postupdate")
	public ModelAndView postPostUpdate(@ModelAttribute("post") @Valid Post post, BindingResult result) {
		ModelAndView modelAndView = new ModelAndView();
		if (result.hasErrors()) {
			modelAndView.setViewName("postEdit");
			modelAndView.addObject("post", post);
			return modelAndView;
		} else {
			postService.savePost(post);
			modelAndView.setViewName("redirect:home");
		}

		return modelAndView;
	}

	// RESTful API
	@PostMapping("create")
	public void createPost(@RequestBody @Valid Post newPost) {
		postService.savePost(newPost);
	}

	@GetMapping("api")
	public List<Post> getPost() {
		return postService.search("");
	}
}
