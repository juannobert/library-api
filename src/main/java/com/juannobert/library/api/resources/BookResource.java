package com.juannobert.library.api.resources;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.juannobert.library.api.dto.BookDTO;
import com.juannobert.library.api.services.BookService;

@RestController
@RequestMapping("/books")
public class BookResource {
	
	@Autowired
	private BookService service;
	
	@GetMapping
	public ResponseEntity<Page<BookDTO>> findAllPaged(Pageable pageable,
			@RequestParam(defaultValue = "",name = "name") String name,
			@RequestParam(defaultValue = "0",name = "categoryId") Long categoryId){
		Page<BookDTO> page = service.findAllPaged(categoryId,name,pageable);
		return ResponseEntity.ok(page);
	}
	
	@PostMapping
	public ResponseEntity<BookDTO> insert(@RequestBody BookDTO dto){
		BookDTO bookDTO = service.save(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(bookDTO.getId()).toUri();
		
		return ResponseEntity.created(uri).body(bookDTO);	
	}

}
