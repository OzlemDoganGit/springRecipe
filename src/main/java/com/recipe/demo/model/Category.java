package com.recipe.demo.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;

import lombok.Data;
@Data
@Entity
public class Category extends BaseEntity {

	private String categoryName;

	@ManyToMany (mappedBy="categories")
	private Set<Recipe> recipes = new HashSet<>();

	public Category() {
	}

	public Category(String categoryName) {
		this.categoryName = categoryName;

	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public Set<Recipe> getRecipes() {
		return recipes;
	}

	public void setRecipes(Set<Recipe> recipes) {
		this.recipes = recipes;
	}
	

	public void addRecipe(Recipe recipe) {
		this.getRecipes().add(recipe);
		//this.getRecipes().iterator().forEachRemaining(e ->{
			//e.getCategories().add(this);
		//});
	}

}
