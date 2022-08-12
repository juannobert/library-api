package com.juannobert.library.api.services;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.juannobert.library.api.dto.CategoryDTO;
import com.juannobert.library.api.entities.Category;
import com.juannobert.library.api.repositories.CategoryRepository;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository repository;
	
	
	@Transactional(readOnly = true)
	public Page<CategoryDTO> findAllPaged(Pageable pageable) {
		Page<Category> page = repository.findAll(pageable);
		return page.map(x -> new CategoryDTO(x));
	}
	
	@Transactional
	public CategoryDTO save(CategoryDTO dto) {
		Category entity = new Category();
		BeanUtils.copyProperties(dto, entity,"id");
		entity = repository.save(entity);
		return new CategoryDTO(entity);
	}
	
	
	
	
	
	
}
