package com.venkata.vallabhaneni;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.venkata.vallabhaneni.ProductsDao;
import com.venkata.vallabhaneni.domain.Product;

@Service
public class ProductsServiceImpl implements ProductsService {

	@Autowired
	private ProductsDao productsDao;

	@Override
	public List<Product> findAll() {
		return (List<Product>) productsDao.findAll();

	}

	@Override
	public Optional<Product> findById(Long id) {
		return productsDao.findById(id);

	}

	@Override
	public Product persist(Product aProduct) {
		if (aProduct == null) {
			throw new IllegalArgumentException();
		}
		return productsDao.save(aProduct);
	}

	@Override
	public void delete(Product aProduct) {
		productsDao.delete(aProduct);
	}

	@Override
	public Optional<Product> findByName(String name) {
		return productsDao.findByName(name);
	}

}
