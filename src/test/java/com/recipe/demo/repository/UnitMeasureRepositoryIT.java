package com.recipe.demo.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

import com.recipe.demo.model.UnitMeasure;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UnitMeasureRepositoryIT {
	
	@Autowired
	UnitMeasureRepository unitMeasureRepo;

	@Before
	public void setUp() throws Exception {
	}

	@Test
	//@DirtiesContext
	public void testFindByUom() {
		Optional<UnitMeasure> uomOptional = unitMeasureRepo.findByUom("Cup");
		assertEquals("Cup", uomOptional.get().getUom());
	}
	
	@Test
	public void testFindByUomCup() {
		Optional<UnitMeasure> uomOptional = unitMeasureRepo.findByUom("Cup");
		assertEquals("Cup", uomOptional.get().getUom());
	}

}
