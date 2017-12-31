package com.vism.spring5recipe.repositories;

import org.springframework.data.repository.CrudRepository;

import com.vism.spring5recipe.domain.Category;

public interface CategoryRepository extends CrudRepository<Category, Long>{

}
