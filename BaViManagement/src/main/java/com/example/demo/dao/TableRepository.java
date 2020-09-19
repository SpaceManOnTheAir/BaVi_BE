package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Table;

public interface TableRepository extends JpaRepository<Table, Integer>{
	
}
