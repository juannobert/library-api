package com.juannobert.library.api.dto;

import java.io.Serializable;

import com.juannobert.library.api.entities.Author;

public class AuthorDTO implements Serializable{

	private static final long serialVersionUID = 1L;

	private Long id;

	private String name;
	
	public AuthorDTO() {
	}

	
	
	public AuthorDTO(Long id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public AuthorDTO(Author entity) {
		this.id = entity.getId();
		this.name = entity.getName();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
