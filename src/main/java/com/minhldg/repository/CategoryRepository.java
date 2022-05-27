package com.minhldg.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.minhldg.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
 
}
