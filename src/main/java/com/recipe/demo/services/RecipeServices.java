package com.recipe.demo.services;

import java.util.Set;
import com.recipe.demo.model.Recipe;

public interface RecipeServices extends CrudService<Recipe, Long>{
	
	Set <Recipe> getRecipes();
	Recipe findById(Long l);

}
