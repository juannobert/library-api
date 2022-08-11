package com.juannobert.library.api.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.juannobert.library.api.dto.LoanDTO;
import com.juannobert.library.api.entities.Loan;
import com.juannobert.library.api.repositories.LoanRepository;

@Service
public class LoanService {

	@Autowired
	private LoanRepository repository;
	
	@Transactional(readOnly = true)
	public List<LoanDTO> findAll(){
		List<Loan> list = repository.findAll();
		return list.stream()
				.map(x -> new LoanDTO(x,x.getBooks()))
				.collect(Collectors.toList());
	}
}
