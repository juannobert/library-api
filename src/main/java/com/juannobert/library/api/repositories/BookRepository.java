package com.juannobert.library.api.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.juannobert.library.api.entities.Book;
import com.juannobert.library.api.entities.Category;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
	
	
	@Query("SELECT DISTINCT obj FROM Book obj "
			+ "INNER JOIN obj.categories cats "
			+ "WHERE "
			+ "(:categories = null OR cats IN :categories) "
			+ "AND "
			+ "(LOWER(obj.name) LIKE LOWER(CONCAT('%',:name,'%')) )")
	Page<Book> find(List<Category> categories,String name,Pageable pageable);

}
