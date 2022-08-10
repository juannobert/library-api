package com.juannobert.library.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.juannobert.library.api.entities.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

}
