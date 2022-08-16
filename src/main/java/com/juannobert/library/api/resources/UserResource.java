package com.juannobert.library.api.resources;

import java.net.URI;

import javax.validation.Valid;

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

import com.juannobert.library.api.dto.UserDTO;
import com.juannobert.library.api.dto.UserInsertDTO;
import com.juannobert.library.api.services.UserService;

@RestController
@RequestMapping("/users")
public class UserResource {
	
	@Autowired
	private UserService service;
	
	@GetMapping
	public ResponseEntity<Page<UserDTO>> findAllPaged(Pageable pageable){
		Page<UserDTO> page = service.findAllPaged(pageable);
		return ResponseEntity.ok(page);
	}
	
	@PostMapping
	public ResponseEntity<UserDTO> insert(@RequestBody @Valid UserInsertDTO dto){
		UserDTO userDTO = service.save(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(userDTO.getId()).toUri();
		
		return ResponseEntity.created(uri).body(userDTO);
		
	}
	
	@GetMapping("/profile")
	public ResponseEntity<UserDTO> profileActive(){
		UserDTO dto = service.userProfileActive();
		return ResponseEntity.ok(dto);
	}

}
