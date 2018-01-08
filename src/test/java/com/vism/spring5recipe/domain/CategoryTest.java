/**
 * 
 */
package com.vism.spring5recipe.domain;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

/**
 * @author illendv
 *
 */
public class CategoryTest {
	
	Category category;
	

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		category = new Category();
	}

	@Test
	public void getId() throws Exception {
		Long idvalu = 4L;
		category.setId(idvalu);
		assertEquals(idvalu, category.getId());
	}
	
	@Test
	public void getDescription() throws Exception {
		
	}

	
	
}
