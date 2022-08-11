package com.juannobert.library.api.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import com.juannobert.library.api.entities.Book;
import com.juannobert.library.api.entities.Loan;

public class LoanDTO implements Serializable{
	private static final long serialVersionUID = 1L;

	private Long id;

	private Date deliveryDate;

	private Date returnDate;

	private List<Book> books = new ArrayList<>();

	private Long userId;
	
	public LoanDTO() {
	}

	public LoanDTO(Long id, Date deliveryDate, Date returnDate, Long userId) {
		this.id = id;
		this.deliveryDate = deliveryDate;
		this.returnDate = returnDate;
		this.userId = userId;
	}
	
	public LoanDTO(Loan entity) {
		this.id = entity.getId();
		this.deliveryDate = entity.getDeliveryDate();
		this.returnDate = entity.getReturnDate();
		this.userId = entity.getUser().getId();
	}
	
	public LoanDTO(Loan entity,Set<Book> books) {
		this(entity);
		books.stream()
			.forEach(book -> new BookDTO(book));
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(Date deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public Date getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public List<Book> getBooks() {
		return books;
	}
	
	
	
	
	
}
