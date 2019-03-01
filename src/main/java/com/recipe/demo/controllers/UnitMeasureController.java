package com.recipe.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UnitMeasureController {
	
	@RequestMapping({"/unitMeasure"})
	public String getCategoryPage()
	{
		return "unitMeasure/index";
	}

}
