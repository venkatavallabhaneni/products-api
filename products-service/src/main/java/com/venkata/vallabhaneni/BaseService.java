package com.venkata.vallabhaneni;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

@Transactional
public interface BaseService<T, ID> {

	public List<T> findAll();

	public Optional<T> findById(ID id);

	public T persist(T t);

	public void delete(T t);

}
