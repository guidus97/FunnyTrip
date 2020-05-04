package org.onlineSolution.TripPacketsService.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@JsonTypeInfo(use = Id.NAME, include = As.PROPERTY, visible = true, property = "type")
@JsonSubTypes({ @JsonSubTypes.Type(value = Room.class, name = "Room"),
		@JsonSubTypes.Type(value = Board.class, name = "Board") })
public abstract class Optional implements Serializable {
	
	
	private static final long serialVersionUID = 1L;

	@javax.persistence.Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@ManyToOne
	@JoinColumn(referencedColumnName = "id")
	@JsonIgnore
	protected TripPacket trip;
	
	public Optional() {
		
	}
}
