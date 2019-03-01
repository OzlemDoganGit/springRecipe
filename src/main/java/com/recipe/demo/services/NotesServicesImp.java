package com.recipe.demo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.recipe.demo.model.Ingredient;
import com.recipe.demo.model.Notes;
import com.recipe.demo.repository.NotesRepository;
import com.recipe.demo.repository.RecipeRepository;

@Service
public class NotesServicesImp implements NotesServices {
	
	private final NotesRepository notesRepository;
	private final RecipeRepository recipeRepository;

	@Autowired
	public NotesServicesImp(NotesRepository notesRepository, RecipeRepository recipeRepository) {
		this.notesRepository = notesRepository;
		this.recipeRepository = recipeRepository;
	}

	@Override
	public <S extends Notes> S save(S entity) {
		if (recipeRepository.save(entity.getRecipe()).getId()!= null)
		{
			return notesRepository.save(entity);
		}
		else {
			throw new RuntimeException("Bidirectional One-to-One Relation Inconsistency");
		}
		
	}

	@Override
	public <S extends Notes> Iterable<S> saveAll(Iterable<S> entities) {
		// TODO Auto-generated method stub
		return notesRepository.saveAll(entities);
	}

	@Override
	public Optional<Notes> findById(Long id) {
		// TODO Auto-generated method stub
		return notesRepository.findById(id);
	}

	@Override
	public boolean existsById(Long id) {
		// TODO Auto-generated method stub
		return notesRepository.existsById(id);
	}

	@Override
	public Iterable<Notes> findAll() {
		// TODO Auto-generated method stub
		return notesRepository.findAll();
	}

	@Override
	public Iterable<Notes> findAllById(Iterable<Long> ids) {
		// TODO Auto-generated method stub
		return notesRepository.findAllById(ids);
	}

	@Override
	public long count() {
		// TODO Auto-generated method stub
		return notesRepository.count();
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		notesRepository.deleteById(id);
		
	}

	@Override
	public void delete(Notes entity) {
		// TODO Auto-generated method stub
		notesRepository.delete(entity);
		
	}

	@Override
	public void deleteAll(Iterable<? extends Notes> entities) {
		// TODO Auto-generated method stub
		notesRepository.deleteAll(entities);
		
	}

	@Override
	public void deleteAll() {
		// TODO Auto-generated method stub
		notesRepository.deleteAll();
		
	}


	
}
