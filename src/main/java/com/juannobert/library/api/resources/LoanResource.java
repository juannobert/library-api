package com.juannobert.library.api.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.juannobert.library.api.dto.LoanDTO;
import com.juannobert.library.api.services.LoanService;

@RestController
@RequestMapping("/loans")
public class LoanResource {
	
	@Autowired
	private LoanService service;
	
	@GetMapping
	public ResponseEntity<List<LoanDTO>> findAll(){
		List<LoanDTO> list = service.findAll();
		return ResponseEntity.ok(list);
	}
	
	

}
