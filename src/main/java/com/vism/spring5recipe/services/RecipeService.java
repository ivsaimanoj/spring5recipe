package com.vism.spring5recipe.services;

import java.util.Set;

import com.vism.spring5recipe.domain.Recipe;
import com.vism.spring5recipe.exceptions.NotFoundException;

public interface RecipeService {
	
	Set<Recipe> getRecipes();
	
	Recipe findById(Long l) throws NotFoundException;
}
