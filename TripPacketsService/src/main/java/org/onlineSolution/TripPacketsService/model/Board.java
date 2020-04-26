package org.onlineSolution.TripPacketsService.model;

import java.io.Serializable;

import javax.persistence.Entity;


@Entity
public class Board extends Optional implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	private float price;
	
	public Board(int id, float price) {
		super();
		this.price = price;
	}
	
	public Board() {
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}
	
	
}
