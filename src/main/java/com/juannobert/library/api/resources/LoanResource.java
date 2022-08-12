package com.juannobert.library.api.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.juannobert.library.api.dto.LoanDTO;
import com.juannobert.library.api.dto.LoanGetDTO;
import com.juannobert.library.api.services.LoanService;

@RestController
@RequestMapping("/loans")
public class LoanResource {
	
	@Autowired
	private LoanService service;
	
	@GetMapping
	public ResponseEntity<List<LoanGetDTO>> findAll(){
		List<LoanGetDTO> list = service.findAll();
		return ResponseEntity.ok(list);
	}
	
	@PostMapping
	public ResponseEntity<LoanDTO> insert(@RequestBody LoanGetDTO dto){
		LoanDTO loanDTO = service.save(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(loanDTO.getId()).toUri();
		
		return ResponseEntity.created(uri).body(loanDTO);
		
	}
	

}
