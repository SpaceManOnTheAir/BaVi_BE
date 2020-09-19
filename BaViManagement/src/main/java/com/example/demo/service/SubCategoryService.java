package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.MainCategoryRepository;
import com.example.demo.dao.SubCategoryRepository;
import com.example.demo.dto.SubDto;
import com.example.demo.entity.MainCategory;
import com.example.demo.entity.SubCategory;
import com.example.demo.exception.ResourceNotFoundException;

@Service
public class SubCategoryService {

	@Autowired
	private MainCategoryRepository mainCateRepo;

	@Autowired
	private SubCategoryRepository subCateRepo;

	public SubCategory createSubCategory(SubDto subDto) {
		Integer categoryId = subDto.getMainCategory_ID();
		System.out.println(subDto.getMainCategory_ID());
		MainCategory mainCategory = null;
		
		if (categoryId != null) {
			if(mainCateRepo.findById(categoryId).isPresent()) {
				mainCategory=mainCateRepo.findById(categoryId).get();
			}
			else throw new IllegalArgumentException();
		}
		
		SubCategory aSubCategory = new SubCategory(subDto, mainCategory);
		try {
		subCateRepo.save(aSubCategory);
		} catch(IllegalArgumentException e)
		{	
			System.out.println(e);
		}
		return aSubCategory;
	}
	
	public SubCategory updateSubCategory(int id,SubDto subDto) {
		Integer categoryId = subDto.getMainCategory_ID();	
		MainCategory mainCategory = null;
		if (categoryId != null) {
			if(mainCateRepo.findById(categoryId).isPresent()) {
				mainCategory=mainCateRepo.findById(categoryId).get();
			}
			else throw new IllegalArgumentException();
		}
		SubCategory updateSub = getASubCategory(id);
		updateSub.setName(subDto.getName());
		updateSub.setMainCategory_ID(mainCategory);
		return subCateRepo.save(updateSub);
	}

	public SubCategory save(SubCategory aSubCategory) {
		return subCateRepo.save(aSubCategory);
	}

	public List<SubCategory> listAllMain() {
		return subCateRepo.findAll();
	}

	public SubCategory getASubCategory(int id) {
		return subCateRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No Sub Category found with id=" + id));
	}

	public void deleteSubCategory(int id) {
		subCateRepo.deleteById(id);
	}

}
