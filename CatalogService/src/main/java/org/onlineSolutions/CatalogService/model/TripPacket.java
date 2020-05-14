package org.onlineSolutions.CatalogService.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;

@Document(collection = "trip")
public class TripPacket implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private String id;
	private String name;

	@JsonFormat(pattern = "dd-MM-yyyy")
	private Date start;

	@JsonFormat(pattern = "dd-MM-yyyy")
	private Date end_trip;
	private float price;
	private List<Object> optional;

	public TripPacket(String id, String name, Date start, Date end_trip, float price) {
		super();
		this.id = id;
		this.name = name;
		this.start = start;
		this.end_trip = end_trip;
		this.price = price;
	}

	public TripPacket() {

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}
	
	public Date getEnd_trip() {
		return this.end_trip;
	}
	
	public void setEnd_trip(Date end_trip) {
		this.end_trip = end_trip;
	}
	public List<Object> getOptionals() {
		return this.optional;
	}

	public void setOptionals(List<Object> optional) {
		this.optional = optional;
	}

	public void addOptional(String optional) {
		
	}

	@Override
	public String toString() {
		return "TripPacket [id=" + id + ", name=" + name + ", start=" + start + ", end_trip=" + end_trip + ", price="
				+ price + ", optional=" + optional + "]";
	}

	
}
