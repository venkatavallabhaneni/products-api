package com.venkata.vallabhaneni.controller;

import java.util.List;
import java.util.Optional;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.venkata.vallabhaneni.ProductsService;
import com.venkata.vallabhaneni.domain.Product;

@RestController
@RequestMapping(value = "/products")
public class ProductsController {

	@Autowired
	private ProductsService productService;

	@GetMapping(value = "/{name}", headers = "Accept=application/json", produces = "application/json")
	@ResponseBody
	public Product getProductByName(@PathParam(value = "name") String name) {
		Optional<Product> aProduct = productService.findByName(name);

		if (aProduct.isPresent()) {
			return aProduct.get();
		}
		return null;
	}

	@GetMapping(headers = "Accept=application/json", produces = "application/json")
	@ResponseBody
	public List<Product> getAll() {
		return productService.findAll();
	}

	@PostMapping(headers = "Accept=application/json", produces = "application/json")
	@ResponseBody
	public Product create(@RequestBody Product aProduct) {
		return productService.persist(aProduct);
	}

	@PutMapping(headers = "Accept=application/json", produces = "application/json")
	@ResponseBody
	public Product update(@RequestBody Product aProduct) {
		return productService.persist(aProduct);
	}

	@DeleteMapping(value = "/{id}", headers = "Accept=application/json", produces = "application/json")
	public void delete(@PathParam(value = "id") Long id) {

		Product product = new Product();
		// product.setId(id);
		productService.delete(product);

	}

}
