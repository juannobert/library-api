package com.juannobert.library.api.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.juannobert.library.api.dto.AuthorDTO;
import com.juannobert.library.api.entities.Author;
import com.juannobert.library.api.repositories.AuthorRepository;

@Service
public class AuthorService {
	
	@Autowired
	private AuthorRepository repository;
	
	
	@Transactional(readOnly = true)
	public Page<AuthorDTO> findAllPaged(Pageable pageable) {
		Page<Author> page = repository.findAll(pageable);
		return page.map(x -> new AuthorDTO(x));
	}
	
	
	
	
	
	
	
	
}
