package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.MainCategoryRepository;
import com.example.demo.entity.MainCategory;
import com.example.demo.entity.SubCategory;
import com.example.demo.exception.ResourceNotFoundException;

@Service
public class MainService {

	@Autowired
	private MainCategoryRepository mainRepo;
	
	public List<SubCategory> getAllSub(int id){
		return mainRepo.findAllSubByID(id);
	}
	
	
	public MainCategory save( MainCategory aMain){
		return  mainRepo.save(aMain);
	}
	
	public List<MainCategory> listAllMain(){
		return mainRepo.findAll();
	}
	
	public MainCategory findByID(int id){
		return mainRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("No main Category found with id=" + id));
	}
	
	
	
}
