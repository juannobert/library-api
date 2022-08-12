package com.juannobert.library.api.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import com.juannobert.library.api.entities.Book;
import com.juannobert.library.api.entities.Category;

public class BookDTO implements Serializable{
	private static final long serialVersionUID = 1L;

	private Long id;

	private String name;

	private String publishingCompany;

	private Long authorId;

	private Set<CategoryDTO> categories = new HashSet<>();

	public BookDTO() {
	}
	public BookDTO(Long id, String name, String publishingCompany, Long authorId) {
		this.id = id;
		this.name = name;
		this.publishingCompany = publishingCompany;
		this.authorId = authorId;
	}
	
	public BookDTO(Book entity) {
		this.id = entity.getId();
		this.name = entity.getName();
		this.publishingCompany = entity.getPublishingCompany();
		this.authorId = entity.getAuthor().getId();
	}
	
	public BookDTO(Book entity,Set<Category> categories) {
		this(entity);
		categories.stream()
			.forEach(cat -> this.categories.add(new CategoryDTO(cat)));
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

	public String getPublishingCompany() {
		return publishingCompany;
	}

	public void setPublishingCompany(String publishingCompany) {
		this.publishingCompany = publishingCompany;
	}

	public Long getAuthorId() {
		return authorId;
	}

	public void setAuthorId(Long authorId) {
		this.authorId = authorId;
	}

	public Set<CategoryDTO> getCategories() {
		return categories;
	}
	
	
	
	

}
