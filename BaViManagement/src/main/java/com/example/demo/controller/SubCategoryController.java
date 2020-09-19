package com.example.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.condition.ConsumesRequestCondition;

import com.example.demo.dao.ItemRepository;
import com.example.demo.dao.SubCategoryRepository;
import com.example.demo.dto.SubDto;
import com.example.demo.entity.MainCategory;
import com.example.demo.entity.SubCategory;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.ErrorDetails;
import com.example.demo.service.MainService;
import com.example.demo.service.SubCategoryService;

@RestController
@RequestMapping(value = "/")
public class SubCategoryController {

	@Autowired
	private MainService mainService;

	@Autowired
	private SubCategoryService subService;

	// GET A LIST OF SUB CATEGORY BY MAIN CATEGORY ID
	@GetMapping("subCategories/{idMain}")
	public List<SubCategory> listAllCategory(@PathVariable("idMain") Integer idMain) {
		return mainService.getAllSub(idMain);
	}

	// GET A SUB CATEGORY
	@GetMapping("subCategory/{id}")
	public SubCategory getASubCategory(@PathVariable("idMain") Integer idMain, @PathVariable("id") Integer id) {
		return subService.getASubCategory(id);
	}

	// CREATE A SUB CATEGORY
	@PostMapping(value = "subCategory", consumes = "application/json")
	public SubCategory createASubCategory(@RequestBody SubDto aSub, BindingResult result) {
		if (result.hasErrors())
			throw new IllegalArgumentException("Invalid data SUB CATEGORY");
		System.out.println(aSub);
		
		return subService.createSubCategory(aSub);
	}

	// UPDATE A SUB CATEGORY
	@PutMapping("subCategory/{id}")
	public SubCategory updateSubCategory(@PathVariable("idMain") Integer idMain, @PathVariable("id") Integer id,
			@RequestBody @Valid SubDto aSub, BindingResult result) {
		if (result.hasErrors())
			throw new IllegalArgumentException("Invalid data SUB CATEGORY");
		return subService.updateSubCategory(id, aSub);
	}

	// DELETE A SUB CATEGORY
	@DeleteMapping("/{idMain}/subCategory/{id}")
	public void deleteSubCategory(@PathVariable("idMain") Integer idMain, @PathVariable("id") Integer id) {
		try {
			subService.deleteSubCategory(id);
		} catch (Exception e) {
			throw new ResourceNotFoundException("Cannot DELETE SUB CATEGORY id=" + id);
		}

	}

}
