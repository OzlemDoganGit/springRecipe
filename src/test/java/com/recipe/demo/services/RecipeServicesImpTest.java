package com.recipe.demo.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.mockito.MockitoAnnotations;

import com.recipe.demo.model.Recipe;
import com.recipe.demo.repository.RecipeRepository;

public class RecipeServicesImpTest {
	
	RecipeServicesImp recipeServiceImp;
	
	@Mock
	RecipeRepository recipeRepository;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		recipeServiceImp = new RecipeServicesImp(recipeRepository);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetRecipes() {
		
		Recipe recipe = new Recipe();
		HashSet<Recipe> recipesData = new HashSet<>();
		recipesData.add(recipe);
		
		when(recipeServiceImp.getRecipes()).thenReturn(recipesData);
		Set<Recipe> recipes = recipeServiceImp.getRecipes();
		assertEquals(recipes.size(), 1);
		verify(recipeRepository, times(1)).findAll();
	}
	
	@Test
	public void testFindById() {
		
		Recipe recipe = new Recipe();
		recipe.setId(1L);
		Optional <Recipe> recipeOptional = Optional.of(recipe);
		when(recipeRepository.findById(anyLong())).thenReturn(recipeOptional);
		
		Recipe returnedRecipe = recipeServiceImp.findById(1L);
		
		assertNotNull(returnedRecipe);
		verify(recipeRepository, times(1)).findById(anyLong());
	}

}
