package com.app.gestionStock.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author mohamed
 *
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private DataSource dataSource;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// BCryptPasswordEncoder bcrpt = getBcrptPass();
		/*-	auth.inMemoryAuthentication().withUser("admin").password(bcrpt.encode("123")).roles("ADMIN", "USER");
			auth.inMemoryAuthentication().withUser("user").password(bcrpt.encode("123")).roles("USER");
			auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder());*/
		// System.out.println(bcrpt.encode("12345"));
		auth.jdbcAuthentication().dataSource(dataSource)
				.usersByUsernameQuery(
						"select username as principal, password as credentials, true from users where username = ?")
				.authoritiesByUsernameQuery(
						"select username as principal, role as role from roles_users  where username = ?")
				.rolePrefix("ROLE_").passwordEncoder(getBcrptPass());
	}

	@Bean
	BCryptPasswordEncoder getBcrptPass() {
		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.csrf().disable().authorizeRequests().antMatchers("/*").access("hasRole('ROLE_USER')").and().formLogin()
				.loginPage("/login").permitAll().defaultSuccessUrl("/home", true);

		http.csrf().disable().authorizeRequests().antMatchers("/admin/*").access("hasRole('ROLE_ADMIN')").and()
				.formLogin().loginPage("/login").permitAll().defaultSuccessUrl("/home", true);

		// http.formLogin().loginPage("/login");
		// http.authorizeRequests().anyRequest().authenticated();
		/*-http.authorizeRequests().antMatchers("/*").hasRole("USER");
		http.authorizeRequests().antMatchers("/admin/*").hasRole("ADMIN");*/
		http.csrf().disable().exceptionHandling().accessDeniedPage("/403");
	}

	/*-@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("admin").password("123").roles("ADMIN", "USER");
		auth.inMemoryAuthentication().withUser("user").password("123").roles("USER");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		/*-	http.formLogin();
			http.authorizeRequests().antMatchers("/home", "/").hasRole("USER");
			http.authorizeRequests().antMatchers("/delivery", "/stock").hasRole("ADMIN");*/

	/*-http
		.authorizeRequests()
			.antMatchers("/", "/home","/layout").permitAll()
			.anyRequest().authenticated()
			.and()
		.formLogin()
			.loginPage("/login")
			.permitAll()
			.and()
		.logout()
			.permitAll();*/
//	}

	/*-@Bean
	@Override
	public UserDetailsService userDetailsService() {
		UserDetails user =
			 User.withDefaultPasswordEncoder()
				.username("user")
				.password("password")
				.roles("USER")
				.build();
	
		return new InMemoryUserDetailsManager(user);
	}*/
}