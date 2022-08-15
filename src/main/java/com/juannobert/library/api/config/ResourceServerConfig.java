package com.juannobert.library.api.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter{

	@Autowired
	private Environment env;
	
	@Autowired
	private JwtTokenStore tokenStore;
	
	
	public static final String[] SYSTEM = {"/h2-console/**","/oauth/token"};
	
	public static final String[] PUBLIC = {"/books/**"};
	
	public static final String[] OPERATOR_OR_ADMIN = {"/loans/**","/books/**","/authors/**"};
	
	public static final String[] OPERATOR_GET = {"/users/**"};
	
	
	@Override
	public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
		resources.tokenStore(tokenStore);
	}
	

	@Override
	public void configure(HttpSecurity http) throws Exception {
		if(Arrays.asList(env.getActiveProfiles()).contains("test")) { 
			http.headers().frameOptions().disable(); 
		}
		http.authorizeRequests()
		.antMatchers(SYSTEM).permitAll()
		.antMatchers(HttpMethod.GET,PUBLIC).permitAll()
		.antMatchers(HttpMethod.GET, OPERATOR_OR_ADMIN).authenticated()
		.antMatchers(OPERATOR_OR_ADMIN).hasAnyRole("OPERATOR", "ADMIN") 
		.antMatchers(HttpMethod.GET,OPERATOR_GET).hasAnyRole("OPERATOR")
		.anyRequest().hasAnyRole("ADMIN");

	}
	
	
	
	
	
	
}
