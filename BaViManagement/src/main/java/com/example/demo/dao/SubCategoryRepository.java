package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.SubCategory;

public interface SubCategoryRepository extends JpaRepository<SubCategory, Integer> {

//	@Query("INSERT INTO sub_category(name,main_category_id) VALUES(:, 1)")
//	public void 
}
