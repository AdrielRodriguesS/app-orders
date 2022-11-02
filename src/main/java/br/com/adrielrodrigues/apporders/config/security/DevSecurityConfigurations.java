package br.com.adrielrodrigues.apporders.config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Profile("dev")
@Configuration
@EnableWebSecurity
public class DevSecurityConfigurations {
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/**").permitAll()
		.and().csrf().disable();
		http.headers().frameOptions().disable(); // to show h2-console
		
		return http.build();
	}
}
