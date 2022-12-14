package com.juannobert.library.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.juannobert.library.api.entities.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

}
