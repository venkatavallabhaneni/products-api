package com.venkata.vallabhaneni;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.venkata.vallabhaneni.domain.Product;

public interface ProductsDao extends CrudRepository<Product, Number>{
	
	public Optional<Product> findByName(String name);

}
