package com.vism.spring5recipe.repositories;

import org.springframework.data.repository.CrudRepository;

import com.vism.spring5recipe.domain.Recipe;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {
	
}
