package com.recipe.demo.services;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.recipe.demo.model.Recipe;
import com.recipe.demo.repository.RecipeRepository;

@Service
public class RecipeServicesImp implements RecipeServices {
	
	Logger recipeLogService = Logger.getLogger(RecipeServicesImp.class.getName());
	
	private final RecipeRepository recipeRepository;
	
	@Autowired
	public RecipeServicesImp(RecipeRepository recipeRepository) {
		this.recipeRepository = recipeRepository;
	}

	@Override
	public <S extends Recipe> S save(S entity) {
		recipeLogService.log(Level.INFO, "Inside Recipe Service save method..");
		return recipeRepository.save(entity);
	}

	@Override
	public <S extends Recipe> Iterable<S> saveAll(Iterable<S> entities) {
		recipeLogService.log(Level.INFO, "Inside Recipe Service saveAll method..");
		return recipeRepository.saveAll(entities);
	}

	@Override
	public Recipe findById(Long id) {
		recipeLogService.log(Level.INFO, "Inside Recipe Service findById method.."); 
		Optional <Recipe> recipeOptional = 	recipeRepository.findById(id);
		if (!recipeOptional.isPresent())
		{
			throw new RuntimeException("Recipe Not Found");
		}
		
		return recipeOptional.get();
	}

	@Override
	public boolean existsById(Long id) {
		recipeLogService.log(Level.INFO, "Inside Recipe Service findById method..");
		return recipeRepository.existsById(id);
	}

	@Override
	public Iterable<Recipe> findAll() {
		recipeLogService.log(Level.INFO, "Inside Recipe Service findAll method..");
		return recipeRepository.findAll();
	}

	@Override
	public Iterable<Recipe> findAllById(Iterable<Long> ids) {
		// TODO Auto-generated method stub
		return recipeRepository.findAllById(ids);
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return recipeRepository.count();
	}

	@Override
	public void deleteById(Long id) {
		recipeRepository.deleteById(id);		
	}

	@Override
	public void delete(Recipe entity) {
		recipeRepository.delete(entity);
		
	}

	@Override
	public void deleteAll(Iterable<? extends Recipe> entities) {
		recipeRepository.deleteAll(entities);
		
	}

	@Override
	public void deleteAll() {
		recipeRepository.deleteAll();	
	}
	
	@Override
	public Set<Recipe> getRecipes() {
        Set <Recipe> recipeSet = new HashSet<>();
        
        System.err.println("OZLEM"+ "HashSet --RecipeSET");
        Iterable <Recipe> recipeItr = findAll();
        recipeItr.iterator().forEachRemaining(recipeSet::add);  
        System.err.println("Outside while loop");
 
        return recipeSet;
	}
	
}