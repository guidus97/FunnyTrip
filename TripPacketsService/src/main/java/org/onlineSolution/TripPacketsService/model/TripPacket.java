package org.onlineSolution.TripPacketsService.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class TripPacket implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	
	@Temporal(TemporalType.DATE)
	@JsonFormat(pattern = "dd-MM-yyyy")
	private Date start;
	
	@Temporal(TemporalType.DATE)
	@JsonFormat(pattern = "dd-MM-yyyy")
	private Date end_trip;
	
	private float price;
	
	@OneToMany(mappedBy = "trip", cascade = CascadeType.ALL)
	private List<Optional> optional;

	public TripPacket(int id, String name, Date start, Date end, float price) {
		super();
		this.id = id;
		this.name = name;
		this.start = start;
		this.end_trip = end;
		this.price = price;
	}
	
	public TripPacket() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getStart() {
		return start;
	}

	public void setStart(Date start) {
		this.start = start;
	}

	public Date getEnd() {
		return end_trip;
	}

	public void setEnd(Date end) {
		this.end_trip = end;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public List<Optional> getOptional() {
		return optional;
	}

	public void setOptional(List<Optional> optional) {
		this.optional = optional;
	}
	
	public void addOptional(Optional optional) {
		
		this.optional.add(optional);
	}
	
	
}
