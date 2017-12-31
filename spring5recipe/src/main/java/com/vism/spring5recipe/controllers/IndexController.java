package com.vism.spring5recipe.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.vism.spring5recipe.services.RecipeService;

@Controller
public class IndexController {

	// private CategoryRepository categoryRepository;
	// private UnitOfMeasureRepository unitOfMeasureRepository;
	//
	// public IndexController(CategoryRepository categoryRepository,
	// UnitOfMeasureRepository unitOfMeasureRepository) {
	// super();
	// this.categoryRepository = categoryRepository;
	// this.unitOfMeasureRepository = unitOfMeasureRepository;
	// }
	//
	// @RequestMapping({ "", "/", "/index" })
	// public String getIndexPage() {
	// Optional<Category> catOptional =
	// categoryRepository.findByDescription("American");
	// Optional<UnitOfMeasure> uomOptional =
	// unitOfMeasureRepository.findByDescription("Pinch");
	//
	// System.out.println("Category Id is :" + catOptional.get().getId());
	// System.out.println("Unit of Measure Id is :" + uomOptional.get().getId());
	//
	// return "index";
	// }

	private final RecipeService recipeService;

	public IndexController(RecipeService recipeService) {
		this.recipeService = recipeService;
	}
	
	@RequestMapping({"", "/", "/index"})
	public String getIndexPage(Model model) {
		model.addAttribute("recipes", this.recipeService.getRecipes());
		return "index";
	}

}
