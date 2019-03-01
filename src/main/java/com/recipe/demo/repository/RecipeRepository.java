package com.recipe.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.recipe.demo.model.Recipe;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {


}
