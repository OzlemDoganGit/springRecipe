package com.recipe.demo.services;

import java.util.Optional;
import com.recipe.demo.model.BaseEntity;
import com.recipe.demo.model.Category;
import com.recipe.demo.model.Recipe;

public interface CrudService <T, ID>{

	<S extends T> S save(S entity);
	<S extends T> Iterable<S> saveAll(Iterable<S> entities);
	T findById(ID id);
	boolean existsById(ID id);
	Iterable<T> findAll();
	Iterable<T> findAllById(Iterable<ID> ids);
	long count();
	void deleteById(ID id);
	void delete(T entity);
	void deleteAll(Iterable<? extends T> entities);
	void deleteAll();
}
