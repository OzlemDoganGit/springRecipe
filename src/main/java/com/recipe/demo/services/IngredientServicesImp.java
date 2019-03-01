package com.recipe.demo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.recipe.demo.model.Ingredient;
import com.recipe.demo.repository.IngredientRepository;
@Service
public class IngredientServicesImp implements IngredientServices {

	private IngredientRepository ingredientRepo;
	@Autowired
	public IngredientServicesImp(IngredientRepository ingredientRepo) {
		this.ingredientRepo = ingredientRepo;
	}
	@Override
	public <S extends Ingredient> S save(S entity) {
		// TODO Auto-generated method stub
		return ingredientRepo.save(entity);
	}
	@Override
	public <S extends Ingredient> Iterable<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return ingredientRepo.saveAll(entities);
	}
	@Override
	public Optional<Ingredient> findById(Long id) {
		// TODO Auto-generated method stub
		return ingredientRepo.findById(id);
	}
	@Override
	public boolean existsById(Long id) {
		// TODO Auto-generated method stub
		return ingredientRepo.existsById(id);
	}
	@Override
	public Iterable<Ingredient> findAll() {
		// TODO Auto-generated method stub
		return ingredientRepo.findAll();
	}
	@Override
	public Iterable<Ingredient> findAllById(Iterable<Long> ids) {
		// TODO Auto-generated method stub
		return ingredientRepo.findAllById(ids);
	}
	@Override
	public long count() {
		// TODO Auto-generated method stub
		return ingredientRepo.count();
	}
	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		ingredientRepo.deleteById(id);
		
	}
	@Override
	public void delete(Ingredient entity) {
		// TODO Auto-generated method stub
		ingredientRepo.delete(entity);
		
	}
	@Override
	public void deleteAll(Iterable<? extends Ingredient> entities) {
		// TODO Auto-generated method stub
		ingredientRepo.deleteAll(entities);
		
		
	}
	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		ingredientRepo.deleteAll();
		
	}

}
