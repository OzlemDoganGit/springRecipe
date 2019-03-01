package com.recipe.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.recipe.demo.model.Category;

public interface CategoryRepository extends CrudRepository <Category, Long>{

}
