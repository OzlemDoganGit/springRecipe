package com.recipe.demo.bootstrap;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.recipe.demo.model.Category;
import com.recipe.demo.model.Ingredient;
import com.recipe.demo.model.Notes;
import com.recipe.demo.model.Recipe;
import com.recipe.demo.model.UnitMeasure;
import com.recipe.demo.model.enumaration.Diffuculty;
import com.recipe.demo.services.CategoryServices;
import com.recipe.demo.services.IngredientServices;
import com.recipe.demo.services.NotesServices;
import com.recipe.demo.services.RecipeServices;
import com.recipe.demo.services.UnitMeasureServices;



@Component
public class DataLoader implements ApplicationListener<ContextRefreshedEvent>{
	
	private final RecipeServices recipeService;
	private final IngredientServices ingredientService;
	private final CategoryServices categoryServices;
	private final UnitMeasureServices unitMeasureServices;
	private final NotesServices notesService;
	
	Logger bootstapLogger = Logger.getLogger(DataLoader.class.getName());
	
	@Autowired
	public DataLoader(RecipeServices recipeService, IngredientServices ingredientService,
			CategoryServices categoryServices, UnitMeasureServices unitMeasureServices, NotesServices notesService) {
		this.recipeService = recipeService;
		this.ingredientService = ingredientService;
		this.categoryServices = categoryServices;
		this.unitMeasureServices = unitMeasureServices;
		this.notesService = notesService;
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		recipeService.saveAll(getRecipes());
		 recipeService.findAll().iterator().forEachRemaining((e) ->
		{
			bootstapLogger.log(Level.INFO, e.toString());
		});
    }

    private List<Recipe> getRecipes() {

    	List<Recipe> recipes = new ArrayList<>(2);
    	Recipe guocomoleRecipe = new Recipe();
    	Recipe saltyChickenRecipe = new Recipe();
    	
    	//Constants
		Byte[] guocomoleImage = {0,0,25,19};
		guocomoleRecipe.setDescription("perfect Guacomole");
		guocomoleRecipe.setCookTime(0);
		guocomoleRecipe.setDiffuculty(Diffuculty.EASY);
		guocomoleRecipe.setDirections("long to write");
		guocomoleRecipe.setPrepTime(10);
		guocomoleRecipe.setImage(guocomoleImage);
		guocomoleRecipe.setSource("simply recipe");
		guocomoleRecipe.setUrl("www.simplyercipe.com");
		
		Byte[] saltyChickenImage = {0,0,25,19};
		saltyChickenRecipe.setDescription("SaltyChicken");
		saltyChickenRecipe.setCookTime(1);
		saltyChickenRecipe.setDiffuculty(Diffuculty.HARD);
		saltyChickenRecipe.setDirections("Add Salt");
		saltyChickenRecipe.setPrepTime(15);
		saltyChickenRecipe.setImage(saltyChickenImage);
		saltyChickenRecipe.setSource("Chicken time");
		saltyChickenRecipe.setUrl("www.simplyercipe.com");
		
		///////////////////////////////////////////////////////
		//Notes
		Notes chickenNotes = new Notes();
		chickenNotes.setNotes("too much salty, be carefull");
		chickenNotes.setRecipe(saltyChickenRecipe);
		
		Notes guacomoloNotes = new Notes();
		guacomoloNotes.setNotes("useful recipe");
		guacomoloNotes.setRecipe(guocomoleRecipe);
		
		
		Notes savedSaltyChickenNotes = notesService.save( chickenNotes);		
		Notes savedGuacomoloNotes  = notesService.save(guacomoloNotes);
		
		guocomoleRecipe.setNotes(savedGuacomoloNotes);
		saltyChickenRecipe.setNotes(savedSaltyChickenNotes);
		Category vegan = new Category();
		vegan.setCategoryName("vegan");
		Category snack = new Category();
		snack.setCategoryName("snack");
		Category dinner = new Category();
		dinner.setCategoryName("dinner");
		Category savedVeganCategory = categoryServices.save(vegan );		
		Category savedSnackCategory = categoryServices.save(snack);				
		Category savedDinnerCategory = categoryServices.save(dinner);
					
		guocomoleRecipe.addCategory(savedVeganCategory);
		guocomoleRecipe.addCategory(savedSnackCategory);
		saltyChickenRecipe.addCategory(savedDinnerCategory);
		
		//Get UnitMeasures from DB
        Optional<UnitMeasure> tableSpoonUomOptional = unitMeasureServices.findByUom("Tablespoon");
        if(!tableSpoonUomOptional.isPresent()){
            throw new RuntimeException("Expected UOM Not Found");
        } 
		Optional<UnitMeasure> pinchOptional = unitMeasureServices.findByUom("Pinch");

		if (!pinchOptional.isPresent())
		{
			throw new RuntimeException("Expected UOM Not Found");
		}
		
		Ingredient savedAvacado = ingredientService.save(
				new Ingredient("avacado", BigDecimal.valueOf(0L), tableSpoonUomOptional.get()));
		Ingredient savedSalt = ingredientService.save(
				new Ingredient("salt", BigDecimal.valueOf(0L), pinchOptional.get()));

		guocomoleRecipe.addIngredient(savedAvacado);
		guocomoleRecipe.addIngredient(savedSalt);
		
		saltyChickenRecipe.addIngredient(savedSalt);
		
		recipes.add(recipeService.save(guocomoleRecipe));
		recipes.add(recipeService.save(saltyChickenRecipe));
		
		return recipes;
	}






}
