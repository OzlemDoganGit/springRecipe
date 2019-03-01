package com.recipe.demo.services;

import java.util.Optional;

import com.recipe.demo.model.UnitMeasure;

public interface UnitMeasureServices extends CrudService<UnitMeasure, Long>{

	Optional<UnitMeasure> findByUom(String string);

}
