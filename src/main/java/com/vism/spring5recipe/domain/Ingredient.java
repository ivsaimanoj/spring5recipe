package com.vism.spring5recipe.domain;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(exclude= {"recipe"})
@Entity
public class Ingredient {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String description;
	private BigDecimal amount;

	@OneToOne(fetch = FetchType.EAGER)
	private UnitOfMeasure measure;

	@ManyToOne
	private Recipe recipe;

	public Ingredient() {
		
	}
	
	public Ingredient(String description, BigDecimal amount, UnitOfMeasure measure) {
		super();
		this.description = description;
		this.amount = amount;
		this.measure = measure;
	}
	
	public Ingredient(String description, BigDecimal amount, UnitOfMeasure measure, Recipe recipe) {
		super();
		this.description = description;
		this.amount = amount;
		this.measure = measure;
		this.recipe = recipe;
	}

}
