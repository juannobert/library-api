package com.juannobert.library.api.dto;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.juannobert.library.api.entities.Book;
import com.juannobert.library.api.entities.Loan;

public class LoanGetDTO extends LoanDTO {

	private static final long serialVersionUID = 1L;

	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date deliveryDate;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date returnDate;

	public LoanGetDTO() {
	}

	public LoanGetDTO(Loan entity, List<Book> books, Date deliveryDate, Date returnDate) {
		super(entity, books);
		this.deliveryDate = deliveryDate;
		this.returnDate = returnDate;
	}

	public LoanGetDTO(Loan entity, Date deliveryDate, Date returnDate) {
		super(entity);
		this.deliveryDate = deliveryDate;
		this.returnDate = returnDate;
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

}
