package com.vism.spring5recipe.bootstrap;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.vism.spring5recipe.domain.Category;
import com.vism.spring5recipe.domain.Difficulty;
import com.vism.spring5recipe.domain.Ingredient;
import com.vism.spring5recipe.domain.Notes;
import com.vism.spring5recipe.domain.Recipe;
import com.vism.spring5recipe.domain.UnitOfMeasure;
import com.vism.spring5recipe.repositories.CategoryRepository;
import com.vism.spring5recipe.repositories.RecipeRepository;
import com.vism.spring5recipe.repositories.UnitOfMeasureRepository;

@Component
public class RecipeBootstrap implements ApplicationListener<ContextRefreshedEvent>{

	private final CategoryRepository categoryRepository;
	private final RecipeRepository recipeRepository;
	private final UnitOfMeasureRepository uoMeasureRepository;
	
	public RecipeBootstrap(CategoryRepository categoryRepository, RecipeRepository recipeRepository,
			UnitOfMeasureRepository uoMeasureRepository) {
		super();
		this.categoryRepository = categoryRepository;
		this.recipeRepository = recipeRepository;
		this.uoMeasureRepository = uoMeasureRepository;
	}
	
	private List<Recipe> getRecipes() {
		List<Recipe> recipesList = new ArrayList<>();
		
		// get UOMs
		Optional<UnitOfMeasure> eachUOMOptinal = uoMeasureRepository.findByDescription("Each");
		if(!eachUOMOptinal.isPresent()) {
			throw new RuntimeException("Expected UOM not found");
		}
		Optional<UnitOfMeasure> tableSpoonUOMOptinal = uoMeasureRepository.findByDescription("Tablespoon");
		if(!tableSpoonUOMOptinal.isPresent()) {
			throw new RuntimeException("Expected UOM not found");
		}
		Optional<UnitOfMeasure> teaspoonUOMOptinal = uoMeasureRepository.findByDescription("Teaspoon");
		if(!teaspoonUOMOptinal.isPresent()) {
			throw new RuntimeException("Expected UOM not found");
		}
		Optional<UnitOfMeasure> dashUOMOptinal = uoMeasureRepository.findByDescription("Dash");
		if(!dashUOMOptinal.isPresent()) {
			throw new RuntimeException("Expected UOM not found");
		}
		Optional<UnitOfMeasure> cupUOMOptinal = uoMeasureRepository.findByDescription("Cup");
		if(!cupUOMOptinal.isPresent()) {
			throw new RuntimeException("Expected UOM not found");
		}
		Optional<UnitOfMeasure> pinchUOMOptinal = uoMeasureRepository.findByDescription("Pinch");
		if(!pinchUOMOptinal.isPresent()) {
			throw new RuntimeException("Expected UOM not found");
		}
		Optional<UnitOfMeasure> pintUOMOptinal = uoMeasureRepository.findByDescription("Pint");
		if(!pintUOMOptinal.isPresent()) {
			throw new RuntimeException("Expected UOM not found");
		}
		
		// get optionals
		UnitOfMeasure eachUOM = eachUOMOptinal.get();
		UnitOfMeasure tablespoonUOM = tableSpoonUOMOptinal.get();
		UnitOfMeasure teaspoonUOM = teaspoonUOMOptinal.get();
		UnitOfMeasure dashUOM = dashUOMOptinal.get();
		UnitOfMeasure cupUOM = cupUOMOptinal.get();
		UnitOfMeasure pinchUOM = pinchUOMOptinal.get();
		UnitOfMeasure pintUOM = pintUOMOptinal.get();
		
		// get categories
		Optional<Category> americanCategoryOptional = categoryRepository.findByDescription("American");
		if (!americanCategoryOptional.isPresent()) {
			throw new RuntimeException("EXpected Category not found");
		}
		Optional<Category> mexicanCategoryOptional = categoryRepository.findByDescription("Mexican");
		if (!mexicanCategoryOptional.isPresent()) {
			throw new RuntimeException("EXpected Category not found");
		}
		
		// get optionals
		Category americaCategory = americanCategoryOptional.get();
		Category mexicanCategory = mexicanCategoryOptional.get();
		
		// create recipes
		
		Recipe guacRecipe = new Recipe();
		guacRecipe.setDescription("Perfect GuacRecipe");
		guacRecipe.setPrepTime(10);
		guacRecipe.setCookTime(0);
		guacRecipe.setDifficulty(Difficulty.EASY);
		guacRecipe.setDirections("MethodShow Photos\n" + 
				"1 Cut avocado, remove flesh: Cut the avocados in half. Remove seed. Score the inside of the avocado with a blunt knife and scoop out the flesh with a spoon. (See How to Cut and Peel an Avocado.) Place in a bowl.\n" + 
				"\n" + 
				"2 Mash with a fork: Using a fork, roughly mash the avocado. (Don't overdo it! The guacamole should be a little chunky.)\n" + 
				"\n" + 
				"3 Add salt, lime juice, and the rest: Sprinkle with salt and lime (or lemon) juice. The acid in the lime juice will provide some balance to the richness of the avocado and will help delay the avocados from turning brown.\n" + 
				"\n" + 
				"Add the chopped onion, cilantro, black pepper, and chiles. Chili peppers vary individually in their hotness. So, start with a half of one chili pepper and add to the guacamole to your desired degree of hotness.\n" + 
				"\n" + 
				"Remember that much of this is done to taste because of the variability in the fresh ingredients. Start with this recipe and adjust to your taste.\n" + 
				"\n" + 
				"4 Cover with plastic and chill to store: Place plastic wrap on the surface of the guacamole cover it and to prevent air reaching it. (The oxygen in the air causes oxidation which will turn the guacamole brown.) Refrigerate until ready to serve.\n" + 
				"\n" + 
				"Chilling tomatoes hurts their flavor, so if you want to add chopped tomato to your guacamole, add it just before serving.\n" + 
				"\n" + 
				"\n" + 
				"\n" + 
				"Read more: http://www.simplyrecipes.com/recipes/perfect_guacamole/#ixzz53T2vZTZ0");
		Notes guacNotes = new Notes();
		guacNotes.setRecipe(guacRecipe);
		guacNotes.setRecipeNotes("Variations\n" + 
				"\n" + 
				"For a very quick guacamole just take a 1/4 cup of salsa and mix it in with your mashed avocados.\n" + 
				"\n" + 
				"Feel free to experiment! One classic Mexican guacamole has pomegranate seeds and chunks of peaches in it (a Diana Kennedy favorite). Try guacamole with added pineapple, mango, or strawberries (see our Strawberry Guacamole).\n" + 
				"\n" + 
				"The simplest version of guacamole is just mashed avocados with salt. Don't let the lack of availability of other ingredients stop you from making guacamole.\n" + 
				"\n" + 
				"To extend a limited supply of avocados, add either sour cream or cottage cheese to your guacamole dip. Purists may be horrified, but so what? It tastes great.\n" + 
				"\n" + 
				"For a deviled egg version with guacamole, try our Guacamole Deviled Eggs!\n" + 
				"\n" + 
				"\n" + 
				"\n" + 
				"Read more: http://www.simplyrecipes.com/recipes/perfect_guacamole/#ixzz53T386GqJ");
		guacRecipe.setNotes(guacNotes);
		
		guacRecipe.getIngredients().add(new Ingredient("ripe avocados", new BigDecimal(2), eachUOM));
		guacRecipe.getIngredients().add(new Ingredient("kosher salt", new BigDecimal("0.5"), teaspoonUOM));
		guacRecipe.getIngredients().add(new Ingredient("fresh lime juice", new BigDecimal(2), tablespoonUOM));
		guacRecipe.getIngredients().add(new Ingredient("minced green onoin ", new BigDecimal(2), eachUOM));
		guacRecipe.getIngredients().add(new Ingredient("chillies", new BigDecimal(2), eachUOM));
		guacRecipe.getIngredients().add(new Ingredient("cilantros", new BigDecimal(2), tablespoonUOM));
		guacRecipe.getIngredients().add(new Ingredient("ripe tomoate, chopped", new BigDecimal("0.5"), eachUOM));
		
		guacRecipe.getCategories().add(americaCategory);
		guacRecipe.getCategories().add(mexicanCategory);
		
		Recipe tacoRecipe = new Recipe();
		tacoRecipe.setDescription("Spicy grill taco");
		tacoRecipe.setPrepTime(20);
		tacoRecipe.setCookTime(15);
		tacoRecipe.setDifficulty(Difficulty.MODERATE);
		tacoRecipe.setDirections("1 Prepare a gas or charcoal grill for medium-high, direct heat.\n" + 
				"\n" + 
				"2 Make the marinade and coat the chicken: In a large bowl, stir together the chili powder, oregano, cumin, sugar, salt, garlic and orange zest. Stir in the orange juice and olive oil to make a loose paste. Add the chicken to the bowl and toss to coat all over.\n" + 
				"\n" + 
				"Set aside to marinate while the grill heats and you prepare the rest of the toppings.\n" + 
				"\n" + 
				"3 Grill the chicken: Grill the chicken for 3 to 4 minutes per side, or until a thermometer inserted into the thickest part of the meat registers 165F. Transfer to a plate and rest for 5 minutes.\n" + 
				"\n" + 
				"4 Warm the tortillas: Place each tortilla on the grill or on a hot, dry skillet over medium-high heat. As soon as you see pockets of the air start to puff up in the tortilla, turn it with tongs and heat for a few seconds on the other side.\n" + 
				"\n" + 
				"Wrap warmed tortillas in a tea towel to keep them warm until serving.\n" + 
				"\n" + 
				"5 Assemble the tacos: Slice the chicken into strips. On each tortilla, place a small handful of arugula. Top with chicken slices, sliced avocado, radishes, tomatoes, and onion slices. Drizzle with the thinned sour cream. Serve with lime wedges.\n" + 
				"\n" + 
				"\n" + 
				"\n" + 
				"Read more: http://www.simplyrecipes.com/recipes/spicy_grilled_chicken_tacos/#ixzz53T4RFsLf");
		Notes tacoNotes = new Notes();
		tacoNotes.setRecipe(tacoRecipe);
		tacoNotes.setRecipeNotes("Look for ancho chile powder with the Mexican ingredients at your grocery store, on buy it online. (If you can't find ancho chili powder, you replace the ancho chili, the oregano, and the cumin with 2 1/2 tablespoons regular chili powder, though the flavor won't be quite the same.)\n" + 
				"\n" + 
				"Read more: http://www.simplyrecipes.com/recipes/spicy_grilled_chicken_tacos/#ixzz53T4ZwuZV");
		tacoRecipe.setNotes(tacoNotes);
		
		tacoRecipe.getIngredients().add(new Ingredient("ancho chilli powder", new BigDecimal(2), tablespoonUOM));
		tacoRecipe.getIngredients().add(new Ingredient("dired oregano", new BigDecimal(1), eachUOM));
		tacoRecipe.getIngredients().add(new Ingredient("dried cumin", new BigDecimal(2), teaspoonUOM));
		tacoRecipe.getIngredients().add(new Ingredient("sugar", new BigDecimal(2), tablespoonUOM));
		tacoRecipe.getIngredients().add(new Ingredient("garlic", new BigDecimal(2), eachUOM));
		tacoRecipe.getIngredients().add(new Ingredient("cherry tomatoes", new BigDecimal(2), eachUOM));
		tacoRecipe.getIngredients().add(new Ingredient("cut lime wedges", new BigDecimal(4), eachUOM));
		
		tacoRecipe.getCategories().add(americaCategory);
		tacoRecipe.getCategories().add(mexicanCategory);
		
		
		recipesList.add(guacRecipe);
		recipesList.add(tacoRecipe);
		
		return recipesList;
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent arg0) {
		// TODO Auto-generated method stub
		recipeRepository.saveAll(getRecipes());
		
	}
	
}











