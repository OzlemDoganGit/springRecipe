package com.recipe.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.recipe.demo.services.RecipeServices;

@Controller
public class RecipeController {
	
	private final RecipeServices recipeService;
	
	@Autowired
	public RecipeController(RecipeServices recipeService) {
		this.recipeService = recipeService;
	}
	
	@RequestMapping({"/recipe"})
	public String getCategoryPage()
	{
		return "recipe/index";
	}

	@RequestMapping({"/recipe/list"})
	public String getRecipeList(Model theModel)
	{
		theModel.addAttribute("recipeList", recipeService.getRecipes());
		return "recipe/list";
	}
}
