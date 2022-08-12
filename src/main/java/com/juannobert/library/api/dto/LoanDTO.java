package com.juannobert.library.api.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.juannobert.library.api.entities.Book;
import com.juannobert.library.api.entities.Loan;

public class LoanDTO implements Serializable{
	private static final long serialVersionUID = 1L;

	private Long id;

	//private Date deliveryDate;

	//private Date returnDate;

	private List<BookDTO> books = new ArrayList<>();

	private Long userId;
	
	public LoanDTO() {
	}

	public LoanDTO(Long id, Date deliveryDate, Date returnDate, Long userId) {
		this.id = id;
		this.userId = userId;
	}
	
	public LoanDTO(Loan entity) {
		this.id = entity.getId();
		this.userId = entity.getUser().getId();
	}
	
	public LoanDTO(Loan entity,List<Book> books) {
		this(entity);
		books.stream()
			.forEach(book -> this.books.add(new BookDTO(book,book.getCategories())));
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public List<BookDTO> getBooks() {
		return books;
	}
	
	
	
	
	
}
