package com.recipe.demo.controllers;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;

import com.recipe.demo.model.Recipe;
import com.recipe.demo.services.RecipeServices;

public class RecipeControllerTest {
	
	RecipeController recipeController;
	
	@Mock
	RecipeServices recipeService;
	@Mock
	Model theModel;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		recipeController = new RecipeController(recipeService);
	}

	public void testMockMVC() throws Exception{
		MockMvc mockMVC = MockMvcBuilders.standaloneSetup(recipeController).build();
		mockMVC.perform(get("/")).andExpect(status().isOk()).andExpect(view().name("recipe/list"));
	}
	@Test
	public void testGetCategoryPage() {
		String viewName = recipeController.getCategoryPage();
		assertEquals("recipe/index", viewName);
	}

	@Test
	public void testGetRecipeList() {
		
		Set<Recipe> recipes = new HashSet<>();
		recipes.add(new Recipe());
		Recipe recipe = new Recipe();
		recipe.setId(1L);
		recipes.add(recipe);
		
		when(recipeService.getRecipes()).thenReturn(recipes);
		
		ArgumentCaptor<Set <Recipe> > argumentCaptor = ArgumentCaptor.forClass(Set.class);
		
		String viewName = recipeController.getRecipeList(theModel);
		assertEquals("recipe/list", viewName);
		verify(recipeService, times(1)).getRecipes();
		verify(theModel, times(1)).addAttribute(eq("recipeList"), argumentCaptor.capture());
		Set <Recipe> setInController = argumentCaptor.getValue();
		assertEquals(2, setInController.size());
	}
	
	@Test
	public void testGetRecipe() throws Exception {
		Recipe recipe = new Recipe();
		MockMvc mockMVC = MockMvcBuilders.standaloneSetup(recipeController).build();
		recipe.setId(1L);
		when(recipeService.findById(anyLong())).thenReturn(recipe);
		
		mockMVC.perform(get("/recipe/show/1"))
        .andExpect(status().isOk())
        .andExpect(view().name("recipe/show"));
	
	}

}
