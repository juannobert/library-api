package com.juannobert.library.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.juannobert.library.api.dto.UserDTO;
import com.juannobert.library.api.entities.User;
import com.juannobert.library.api.repositories.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	@Transactional(readOnly = true)
	public Page<UserDTO> findAllPaged(Pageable pageable) {
		Page<User> page = repository.findAll(pageable);
		return page.map(x -> new UserDTO(x));
	}
	
}
