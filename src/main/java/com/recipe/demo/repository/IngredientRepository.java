package com.recipe.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.recipe.demo.model.Ingredient;

public interface IngredientRepository extends CrudRepository<Ingredient, Long> {

}
