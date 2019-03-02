package com.recipe.demo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.recipe.demo.model.Category;
import com.recipe.demo.repository.CategoryRepository;

@Service
public class CategoryServicesImp implements CategoryServices{
	
	private CategoryRepository categoryRepository;
	
	@Autowired
	public CategoryServicesImp(CategoryRepository categoryRepository) {
		this.categoryRepository = categoryRepository;
	}

	@Override
	public <S extends Category> S save(S entity) {
		// TODO Auto-generated method stub
		return categoryRepository.save(entity);
	}

	@Override
	public <S extends Category> Iterable<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return categoryRepository.saveAll(entities);
	}

	@Override
	public Category findById(Long id) {
		// TODO Auto-generated method stub
		return categoryRepository.findById(id).get();
	}

	@Override
	public boolean existsById(Long id) {
		// TODO Auto-generated method stub
		return categoryRepository.existsById(id);
	}

	@Override
	public Iterable<Category> findAll() {
		// TODO Auto-generated method stub
		return categoryRepository.findAll();
	}

	@Override
	public Iterable<Category> findAllById(Iterable<Long> ids) {
		// TODO Auto-generated method stub
		return categoryRepository.findAllById(ids);
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return categoryRepository.count();
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		categoryRepository.deleteById(id);
		
	}

	@Override
	public void delete(Category entity) {
		// TODO Auto-generated method stub
		categoryRepository.delete(entity);
		
	}

	@Override
	public void deleteAll(Iterable<? extends Category> entities) {
		// TODO Auto-generated method stub
		categoryRepository.deleteAll(entities);		
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		categoryRepository.deleteAll();	
	}



}
