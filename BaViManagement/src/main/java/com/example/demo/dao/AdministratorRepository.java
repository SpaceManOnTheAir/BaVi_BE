package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Administrator;


public interface AdministratorRepository extends JpaRepository<Administrator, Integer> {
	Boolean existsByUsername(String username);
	public Administrator findByUsername(String username);
}
