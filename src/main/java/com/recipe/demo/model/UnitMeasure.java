package com.recipe.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UnitMeasure extends BaseEntity{
	
	private String uom;
	
	//@OneToOne(fetch=FetchType.EAGER, mappedBy= "unitMeasure")
	//private Ingredient ingredient;

	public UnitMeasure() {

	}

	public UnitMeasure( String uom, Ingredient ingredient) {

		this.uom = uom;
		//this.ingredient = ingredient;
	}

	public String getUom() {
		return uom;
	}

	public void setUom(String uom) {
		this.uom = uom;
	}

	/*
	public Ingredient getIngredient() {
		return ingredient;
	}

	public void setIngredient(Ingredient ingredient) {
		this.ingredient = ingredient;
	}
	 
	@Override
	public String toString() {
		return "UnitMeasure [uom=" + uom + ", ingredient=" + ingredient + "]";
	}
	*/

}
