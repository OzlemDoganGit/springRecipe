package com.recipe.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.recipe.demo.model.Notes;

public interface NotesRepository extends CrudRepository<Notes, Long> {

}
