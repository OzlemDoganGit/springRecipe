package com.recipe.demo.repository;


import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.recipe.demo.model.UnitMeasure;

public interface UnitMeasureRepository extends CrudRepository<UnitMeasure, Long> {

	Optional<UnitMeasure> findByUom(String string);


}
