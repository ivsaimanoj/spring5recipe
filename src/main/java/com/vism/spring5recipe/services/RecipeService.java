package com.vism.spring5recipe.services;

import java.util.Set;

import com.vism.spring5recipe.domain.Recipe;

public interface RecipeService {
	
	Set<Recipe> getRecipes();
}
