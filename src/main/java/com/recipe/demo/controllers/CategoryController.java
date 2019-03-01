package com.recipe.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CategoryController {
	
	@RequestMapping({"/category"})
	public String getCategoryPage()
	{
		return "category/index";
	}

}
