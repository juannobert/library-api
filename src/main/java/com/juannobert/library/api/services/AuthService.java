package com.juannobert.library.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.juannobert.library.api.entities.User;
import com.juannobert.library.api.repositories.UserRepository;
import com.juannobert.library.api.services.exceptions.UnauthorizedException;

@Service
public class AuthService {
 
	@Autowired
	private UserRepository repository;
	
	@Transactional(readOnly = true)
	public User authenticated() {
		try {
		String username = SecurityContextHolder.getContext().getAuthentication().getName();
		User user = repository.findByEmail(username);
		return user;
		}catch(Exception e) {
			throw new UnauthorizedException("Invalid user");
		}
	}
	
	public boolean isOnlyClient() {
		User user = authenticated();
		if(!user.hasRole("ROLE_OPERATOR") & !user.hasRole("ROLE_ADMIN")) 
			return true;
		
		return false;
	}
	
}
