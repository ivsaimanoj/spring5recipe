package com.vism.spring5recipe.controllers;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.vism.spring5recipe.domain.Category;
import com.vism.spring5recipe.domain.UnitOfMeasure;
import com.vism.spring5recipe.repositories.CategoryRepository;
import com.vism.spring5recipe.repositories.UnitOfMeasureRepository;

@Controller
public class IndexController {

	private CategoryRepository categoryRepository;
	private UnitOfMeasureRepository unitOfMeasureRepository;

	public IndexController(CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
		super();
		this.categoryRepository = categoryRepository;
		this.unitOfMeasureRepository = unitOfMeasureRepository;
	}

	@RequestMapping({ "", "/", "/index" })
	public String getIndexPage() {
		Optional<Category> catOptional = categoryRepository.findByDescription("American");
		Optional<UnitOfMeasure> uomOptional = unitOfMeasureRepository.findByDescription("Pinch");

		System.out.println("Category Id is :" + catOptional.get().getId());
		System.out.println("Unit of Measure Id is :" + uomOptional.get().getId());

		return "index";
	}

}
