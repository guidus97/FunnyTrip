package org.onlineSolutions.FunnyTrip.config.security;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.AuthenticationEntryPoint;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService cuds;

	@Autowired
	private JwtTokenProvider jwtTokenProvider;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(cuds).passwordEncoder(getPasswordEncoder());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.cors().and().csrf().disable().authorizeRequests()
				.antMatchers("/**/signIn/*", "/api/auth/login", "/api/auth/registerUser", "/login", "/swagger-ui").permitAll()
				.antMatchers("/api/user/services/**").hasAuthority("USER")
				.antMatchers("/api/admin/services/**").hasAuthority("ADMIN")
				.antMatchers("/api/account/**").hasAnyAuthority("USER", "ADMIN").antMatchers("/api/admin/privileges/**").hasAuthority("ADMIN")
				.anyRequest().authenticated().and().apply(new JwtConfigurer(jwtTokenProvider))
				.and().csrf().disable().exceptionHandling().authenticationEntryPoint(unauthorizedEntryPoint());

	}

	@Override
	public void configure(WebSecurity web) throws Exception {

		web.ignoring().antMatchers("/*/").antMatchers("/eureka/**").antMatchers(HttpMethod.OPTIONS, "/**")
				.antMatchers("/swagger-ui.html").antMatchers("/swagger-resources/**").antMatchers("/webjars/**")
				.antMatchers("/v2/api-docs");
	}

	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public AuthenticationEntryPoint unauthorizedEntryPoint() {
		return (request, response, authException) -> response.sendError(HttpServletResponse.SC_UNAUTHORIZED,
				"Unauthorized");
	}

	@Override
	protected UserDetailsService userDetailsService() {
		return cuds;
	}

	@Override
	@Bean
	protected AuthenticationManager authenticationManager() throws Exception {
		return super.authenticationManager();
	}

}
