package com.juannobert.library.api.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.juannobert.library.api.entities.Loan;
import com.juannobert.library.api.entities.User;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Long> {

	List<Loan> findByUser(User user);
}
