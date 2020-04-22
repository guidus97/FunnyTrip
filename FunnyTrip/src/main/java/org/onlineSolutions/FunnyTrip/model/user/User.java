package org.onlineSolutions.FunnyTrip.model.user;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@Entity
@Table(name = "\"User\"")
@ApiModel(description = "Describe User model")
public class User implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@ApiModelProperty(notes = "The id of the user")
	private int id;
	
	@ApiModelProperty(notes = "The username used for login")
	private String username;
	
	@ApiModelProperty(notes = "The password used for login")
	private String password;
	
	@ApiModelProperty(notes = "The firstname of the user")
	private String name;
	
	@ApiModelProperty(notes = "The lastname of the user")
	private String lastName;
	
	@ApiModelProperty(notes = "The email of the user")
	private String email;
	
	@ApiModelProperty(notes = "Specify if the user is active")
	private boolean active;

	@ApiModelProperty(notes = "Specify the role of the user")
	private String roles;
	
	public User() {
	
	}

	public User(int id, String userName, String password, String name, String lastName, String email, boolean active,
			String roles) {
		super();
		this.id = id;
		this.username = userName;
		this.password = password;
		this.name = name;
		this.lastName = lastName;
		this.email = email;
		this.active = active;
		this.roles = roles;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return username;
	}

	public void setUserName(String userName) {
		this.username = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}

}
