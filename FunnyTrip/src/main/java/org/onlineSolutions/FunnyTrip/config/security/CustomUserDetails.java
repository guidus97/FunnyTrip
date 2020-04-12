package org.onlineSolutions.FunnyTrip.config.security;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.onlineSolutions.FunnyTrip.model.user.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@SuppressWarnings(value = "unused")
public class CustomUserDetails implements UserDetails {
	
	private static final long serialVersionUID = -8555835966254114988L;
	
	private int id;
	private String name;
	private String lastname;
	private String username;
	private String password;
	private String email;
	private List<GrantedAuthority> roles;
	private boolean active;
	
	public CustomUserDetails(User user) {
		
		this.id = user.getId();
		this.name = user.getName();
		this.lastname = user.getLastName();
		this.username = user.getUserName();
		this.password = user.getPassword();
		this.email = user.getEmail();
		this.roles = Arrays.asList((new SimpleGrantedAuthority(user.getRoles())));
		this.active = user.isActive();
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return roles;
	}

	@Override
	public String getPassword() {
		return this.password;
	}

	@Override
	public String getUsername() {
		return this.username;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

}
