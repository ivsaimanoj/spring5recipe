package com.vism.spring5recipe.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.vism.spring5recipe.domain.UnitOfMeasure;

public interface UnitOfMeasureRepository extends CrudRepository<UnitOfMeasure, Long> {

	Optional<UnitOfMeasure> findByDescription(String desc);
}
