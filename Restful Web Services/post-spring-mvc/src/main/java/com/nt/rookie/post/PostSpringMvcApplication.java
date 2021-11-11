package com.nt.rookie.post;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"com.nt.rookie.post"})
@EntityScan("com.nt.rookie.post.domain")
@EnableJpaRepositories("com.nt.rookie.post.data")
public class PostSpringMvcApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(PostSpringMvcApplication.class, args);

	}

}
