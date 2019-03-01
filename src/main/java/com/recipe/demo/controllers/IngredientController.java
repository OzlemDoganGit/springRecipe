package com.recipe.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IngredientController {
	
	@RequestMapping({"/ingredient"})
	public String getCategoryPage()
	{
		return "ingredient/index";
	}

}
