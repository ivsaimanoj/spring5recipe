package com.vism.spring5recipe.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.vism.spring5recipe.domain.Category;

public interface CategoryRepository extends CrudRepository<Category, Long>{
	
	Optional<Category> findByDescription(String desc);
}
