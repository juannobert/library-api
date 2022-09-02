package com.juannobert.library.api.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.juannobert.library.api.entities.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

	
	@Query("SELECT obj FROM Author obj "
			+ "WHERE "
			+ "LOWER(obj.name) LIKE LOWER(CONCAT('%',:name,'%'))")
	public Page<Author> find(String name,Pageable pageable);
}
