package com.vism.spring5recipe.domain;

import static org.junit.Assert.assertEquals;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.vism.spring5recipe.repositories.UnitOfMeasureRepository;

@RunWith(SpringRunner.class)
@DataJpaTest // creates an embeddd data and allows us to use JPA 
public class UnitOfMeasureIT {

	@Autowired
	UnitOfMeasureRepository uomRepo;
	
	@Before
	public void setUp() throws Exception {
	}

	@Test
//	@DirtiesContext --> this will reload the spring context
	public void findByDescriptionTest() {
		Optional<UnitOfMeasure> uomOptional = uomRepo.findByDescription("Teaspoon");
		assertEquals("Teaspoon", uomOptional.get().getDescription());
	}

	
	@Test
	public void findByDescriptionTest2() {
		Optional<UnitOfMeasure> uomOptional = uomRepo.findByDescription("Cup");
		assertEquals("Cup", uomOptional.get().getDescription());
	}

}
