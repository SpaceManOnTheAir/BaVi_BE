package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.MainCategory;
import com.example.demo.entity.SubCategory;

public interface MainCategoryRepository extends JpaRepository<MainCategory, Integer> {
	
	@Query("select m.subCategories from MainCategory m where m.id = :id")
	List<SubCategory> findAllSubByID(int id);
}
