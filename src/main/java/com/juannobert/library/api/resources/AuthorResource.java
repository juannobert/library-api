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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.juannobert.library.api.dto.AuthorDTO;
import com.juannobert.library.api.services.AuthorService;

@RestController
@RequestMapping("/authors")
public class AuthorResource {
	
	@Autowired
	private AuthorService service;
	
	@GetMapping
	public ResponseEntity<Page<AuthorDTO>> findAllPaged(Pageable pageable){
		Page<AuthorDTO> page = service.findAllPaged(pageable);
		return ResponseEntity.ok(page);
	}
	
	@PostMapping
	public ResponseEntity<AuthorDTO> insert(@RequestBody AuthorDTO dto){
		AuthorDTO userDTO = service.save(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(userDTO.getId()).toUri();
		
		return ResponseEntity.created(uri).body(userDTO);	
	}

}
