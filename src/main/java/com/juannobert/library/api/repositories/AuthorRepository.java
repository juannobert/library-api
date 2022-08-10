package com.juannobert.library.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.juannobert.library.api.entities.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

}
