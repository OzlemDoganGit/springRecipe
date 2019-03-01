package com.recipe.demo.controllers;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.MockitoAnnotations;

public class IndexControllerTest {
	
	IndexController indexController;



	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		indexController = new IndexController();
	}

	@Test
	public void testGetIndexPage() {
		String viewName = indexController.getIndexPage();
		assertEquals("index", viewName);
	}

}
