package com.juannobert.library.api.services;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.juannobert.library.api.dto.BookDTO;
import com.juannobert.library.api.dto.LoanDTO;
import com.juannobert.library.api.dto.LoanGetDTO;
import com.juannobert.library.api.entities.Book;
import com.juannobert.library.api.entities.Loan;
import com.juannobert.library.api.repositories.BookRepository;
import com.juannobert.library.api.repositories.LoanRepository;
import com.juannobert.library.api.repositories.UserRepository;

@Service
public class LoanService {

	@Autowired
	private LoanRepository repository;
	
	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Transactional(readOnly = true)
	public List<LoanGetDTO> findAll(){
		List<Loan> list = repository.findAll();
		return list.stream()
				.map(x -> new LoanGetDTO(x,x.getBooks(),x.getDeliveryDate(),x.getReturnDate()))
				.collect(Collectors.toList());
	}
	
	@Transactional
	public LoanDTO save(LoanDTO dto) {
		Loan entity = new Loan();
		copyToEntity(dto, entity);
		entity = repository.save(entity);
		return new LoanGetDTO(entity,entity.getBooks(),entity.getDeliveryDate(),entity.getReturnDate());
		
	}
	
	private void copyToEntity(LoanDTO dto,Loan entity) {
		entity.setDeliveryDate(Date.valueOf(LocalDate.now()));
		entity.setReturnDate(Date.valueOf(LocalDate.now().plusMonths(1L)));
		entity.setUser(userRepository.getReferenceById(dto.getUserId()));
		
		entity.getBooks().clear();
		for(BookDTO bookDTO : dto.getBooks()) {
			Book book = bookRepository.getReferenceById(bookDTO.getId());
			entity.getBooks().add(book);
		}
		
	}
}
