package org.onlineSolution.TripPacketsService.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Purchase implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private int trip_pack_id;
	private int user_id;
	
	public Purchase(int id, int trip_pack_id, int user_id) {
		super();
		this.id = id;
		this.trip_pack_id = trip_pack_id;
		this.user_id = user_id;
	}
	
	public Purchase() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTrip_pack_id() {
		return trip_pack_id;
	}

	public void setTrip_pack_id(int trip_pack_id) {
		this.trip_pack_id = trip_pack_id;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	
	
	
	
}
