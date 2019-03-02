package com.recipe.demo.services;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.recipe.demo.model.Ingredient;
import com.recipe.demo.model.UnitMeasure;
import com.recipe.demo.repository.UnitMeasureRepository;

@Service
@Primary
public class UnitMeasureServiceImpl implements UnitMeasureServices {
	
	private UnitMeasureRepository unitMeasureRepo;
	
	@Autowired
	public UnitMeasureServiceImpl(UnitMeasureRepository unitMeasureRepo) {
		this.unitMeasureRepo = unitMeasureRepo;
	}

	@Override
	public <S extends UnitMeasure> S save(S entity) {
		// TODO Auto-generated method stub
		return unitMeasureRepo.save(entity);
	}

	@Override
	public <S extends UnitMeasure> Iterable<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return unitMeasureRepo.saveAll(entities);
	}

	@Override
	public UnitMeasure findById(Long id) {
		// TODO Auto-generated method stub
		return unitMeasureRepo.findById(id).get();
	}

	@Override
	public boolean existsById(Long id) {
		// TODO Auto-generated method stub
		return unitMeasureRepo.existsById(id);
	}

	@Override
	public Iterable<UnitMeasure> findAll() {
		// TODO Auto-generated method stub
		return unitMeasureRepo.findAll();
	}

	@Override
	public Iterable<UnitMeasure> findAllById(Iterable<Long> ids) {
		// TODO Auto-generated method stub
		return unitMeasureRepo.findAllById(ids);
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return unitMeasureRepo.count();
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		unitMeasureRepo.deleteById(id);
		
	}

	@Override
	public void delete(UnitMeasure entity) {
		// TODO Auto-generated method stub
		unitMeasureRepo.delete(entity);
		
	}

	@Override
	public void deleteAll(Iterable<? extends UnitMeasure> entities) {
		// TODO Auto-generated method stub
		unitMeasureRepo.deleteAll(entities);
		
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		unitMeasureRepo.deleteAll();
		
	}

	@Override
	public Optional<UnitMeasure> findByUom(String string) {
		// TODO Auto-generated method stub
		return unitMeasureRepo.findByUom(string);
	}


}
