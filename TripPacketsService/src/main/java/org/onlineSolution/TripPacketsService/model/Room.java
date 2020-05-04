package org.onlineSolution.TripPacketsService.model;

import java.io.Serializable;

import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class Room extends Optional implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String name;
	private String location;
	private String city;
	private float price;
	
	public Room(String name, String location, String city, float price) {
		super();
		this.name = name;
		this.location = location;
		this.city = city;
		this.setPrice(price);
	}
	
	public Room() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
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
