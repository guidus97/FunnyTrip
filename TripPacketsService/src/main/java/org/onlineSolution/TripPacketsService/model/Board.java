package org.onlineSolution.TripPacketsService.model;

import java.io.Serializable;

import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;


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
	
	@JsonIgnore
	public TripPacket getPacket() {
		return super.trip;
	}
	
	public void setPacket(TripPacket packet) {
		super.trip = packet;
	}
	
	
}
