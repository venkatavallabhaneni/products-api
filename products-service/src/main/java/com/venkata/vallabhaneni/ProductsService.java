package com.venkata.vallabhaneni;

import java.util.Optional;

import com.venkata.vallabhaneni.domain.Product;

public interface ProductsService extends BaseService<Product,Long> {
	
	public Optional<Product> findByName(String name);

}
