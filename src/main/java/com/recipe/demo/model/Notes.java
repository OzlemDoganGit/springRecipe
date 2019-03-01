package com.recipe.demo.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToOne;

@Entity
public class Notes extends BaseEntity{

	@Lob
	private String recipeNotes;
	
	@OneToOne(fetch= FetchType.EAGER, mappedBy="notes")
	//Provides bi-directional mapping (Needs to address the variable in the recipe class)
	//mappedBy usage ????????????????????
	private Recipe recipe;
	
	public Notes() {
	}
	
	public Notes(String recipeNotes) {

		this.recipeNotes = recipeNotes;
	}

	public String getNotes() {
		return recipeNotes;
	}

	public void setNotes(String notes) {
		this.recipeNotes = notes;
	}

	public Recipe getRecipe() {
		return recipe;
	}

	public void setRecipe(Recipe recipe) {
		this.recipe = recipe;
	}

	@Override
	public String toString() {
		return "Notes [notes=" + recipeNotes + ", recipe=" + recipe + "]";
	}	

}
