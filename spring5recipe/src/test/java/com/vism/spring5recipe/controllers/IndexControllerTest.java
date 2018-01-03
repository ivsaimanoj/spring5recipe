package com.vism.spring5recipe.controllers;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
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
import org.springframework.test.web.servlet.MockMvcBuilderSupport;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;

import com.vism.spring5recipe.domain.Recipe;
import com.vism.spring5recipe.services.RecipeService;

public class IndexControllerTest {

	IndexController indexController;

	@Mock
	Model model;

	@Mock
	RecipeService recipeService;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		indexController = new IndexController(recipeService);
	}
	
	@Test
	public void testMockMVC() throws Exception {
		MockMvc mockMvc = MockMvcBuilders.standaloneSetup(indexController).build();
		mockMvc.perform(MockMvcRequestBuilders.get("/"))
				.andExpect(status().isOk())
				.andExpect(view().name("index"));
	}

	@Test
	public void getIndexPageTest() {
		
		//given
		Set<Recipe> recipes = new HashSet<>();
		Recipe r1 = new Recipe();
		r1.setId(1l);
		Recipe r2 = new Recipe();
		r2.setId(2l);
		
		recipes.add(r1);
		recipes.add(r2);
		
		when(recipeService.getRecipes()).thenReturn(recipes);
		ArgumentCaptor<Set<Recipe>> argCaptor = ArgumentCaptor.forClass(Set.class);
		
		//when 
		String viewName = indexController.getIndexPage(model);
		
		//then
		assertEquals("index", viewName);
		verify(recipeService, times(1)).getRecipes();
//		verify(model, times(1)).addAttribute("recipes", recipeService.getRecipes());
//		verify(model, times(1)).addAttribute("recipes", anySet());
		verify(model, times(1)).addAttribute(eq("recipes"), argCaptor.capture());
		Set<Recipe> outputSet = argCaptor.getValue();
		assertEquals(recipes.size(), outputSet.size());
	}

}
