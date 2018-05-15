package com.venkata.vallabhaneni;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductsControllr {

	@RequestMapping("/")
	public String index() {
		return "Greetings from Spring Boot!";
	}

}
