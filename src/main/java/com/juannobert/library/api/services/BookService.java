package com.juannobert.library.api.services;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.juannobert.library.api.dto.BookDTO;
import com.juannobert.library.api.dto.CategoryDTO;
import com.juannobert.library.api.entities.Author;
import com.juannobert.library.api.entities.Book;
import com.juannobert.library.api.entities.Category;
import com.juannobert.library.api.repositories.AuthorRepository;
import com.juannobert.library.api.repositories.BookRepository;
import com.juannobert.library.api.repositories.CategoryRepository;

@Service
public class BookService {

	@Autowired 
	private BookRepository repository;
	
	@Autowired
	private AuthorRepository authorRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Transactional(readOnly = true)
	public Page<BookDTO> findAllPaged(Long categoryId,String name,Pageable pageable){
		List<Category> categories = (categoryId == 0 ? null : Arrays.asList(categoryRepository.getReferenceById(categoryId)));
		Page<Book> page = repository.find(categories,name,pageable);
		return page.map(x -> new BookDTO(x,x.getCategories()));
	}
	
	@Transactional
	public BookDTO save(BookDTO dto) {
		Book entity = new Book();
		copyToEntity(entity, dto);
		entity = repository.save(entity);
		return new BookDTO(entity,entity.getCategories());
	}
	
	private void copyToEntity(Book entity,BookDTO dto) {
		entity.setName(dto.getName());
		entity.setPublishingCompany(dto.getPublishingCompany());
		Author auhtor  = authorRepository.getReferenceById(dto.getAuthorId());
		entity.setAuthor(auhtor);
		entity.getCategories().clear();
		
		for(CategoryDTO categoryDTO : dto.getCategories()) {
			Category category = categoryRepository.getReferenceById(categoryDTO.getId());
			entity.getCategories().add(category);
			
			
		}
	}
}
