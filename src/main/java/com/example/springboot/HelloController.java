package com.example.springboot;

import com.example.springboot.model.HelloPara;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@GetMapping("/")
	public String index() {
		return "Hello World!";
	}

	@PostMapping("/helloPost")
	public String testPost(@Validated @RequestBody HelloPara student) {
		return "s";
	}
}
