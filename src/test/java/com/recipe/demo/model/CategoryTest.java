/**
 * 
 */
package com.recipe.demo.model;

import static org.junit.Assert.assertEquals;

import java.util.HashSet;
import java.util.Set;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author ozlem
 *
 */
public class CategoryTest {
	
	Category category;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		
		category = new Category();
	}



	/**
	 * Test method for {@link com.recipe.demo.model.Category#getCategoryName()}.
	 */
	@Test
	public void testGetCategoryName() {
		String categoryName = category.getCategoryName();
	}

	/**
	 * Test method for {@link com.recipe.demo.model.Category#setCategoryName(java.lang.String)}.
	 */
	@Test
	public void testSetCategoryName() {
		category.setCategoryName("categoryType");
	}

	/**
	 * Test method for {@link com.recipe.demo.model.Category#getRecipes()}.
	 */
	@Test
	public void testGetRecipes() {
		Set <Recipe> recipes = new HashSet<>();
		recipes.add(new Recipe());
		
		assertEquals(1, recipes.size());
	}

	/**
	 * Test method for {@link com.recipe.demo.model.BaseEntity#getId()}.
	 */
	@Test
	public void testGetId() {
		Long idValue = 4L;
		category.setId(idValue);
		
		assertEquals(idValue, category.getId());
	}

}
