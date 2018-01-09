package com.vism.spring5recipe.services;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.vism.spring5recipe.domain.Recipe;
import com.vism.spring5recipe.exceptions.NotFoundException;
import com.vism.spring5recipe.repositories.RecipeRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class RecipeServiceImpl implements RecipeService {

	private final RecipeRepository recipeRepository;

	public RecipeServiceImpl(RecipeRepository recipeRepository) {
		log.info("Inside RecipeServiceImpl..");
		this.recipeRepository = recipeRepository;
	}

	@Override
	public Set<Recipe> getRecipes() {
		// TODO Auto-generated method stub
		Set<Recipe> set = new HashSet<>();
		this.recipeRepository.findAll().iterator().forEachRemaining(set::add);
		return set;
	}

	@Override
	public Recipe findById(Long l) throws NotFoundException {
		
		Optional<Recipe> recipeOptional = recipeRepository.findById(l);
		
		if (!recipeOptional.isPresent()) {
			throw new NotFoundException("Recipe Not found for ID value = " + l.toString());
		}
		return recipeOptional.get();
	}

}
