package com.example.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.MainCategory;
import com.example.demo.model.ErrorDetails;
import com.example.demo.service.MainService;
import com.example.demo.service.SubCategoryService;

@RestController
@RequestMapping(value = "/mainCategory")
public class MainCategoryController {
	private static final Logger logger = LoggerFactory.getLogger(MainCategoryController.class);
	@Autowired
	private MainService mainService;

	@Autowired
	private SubCategoryService subService;

	// CREATE A MAIN CATEGORY
	@PostMapping("")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public ResponseEntity<?> createMainCategory(@RequestBody @Valid MainCategory mainCate, BindingResult result) {
		if (result.hasErrors()) {
			StringBuilder devErrorMsg = new StringBuilder();
			List<ObjectError> allErrors = result.getAllErrors();
			for (ObjectError objectError : allErrors) {
				devErrorMsg.append(objectError.getDefaultMessage() + "\n");
			}
			ErrorDetails errorDetails = new ErrorDetails();
			errorDetails.setErrorCode("ERR-1400");// Business specific error codes
			errorDetails.setErrorMessage("Invalid Post data received");
			errorDetails.setDevErrorMessage(devErrorMsg.toString());

			return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
		}
		MainCategory savedMainCategory = mainService.save(mainCate);
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("MyResponseHeader", "MyValue");
		logger.info("create a main category " + mainCate.getName());
		return new ResponseEntity<>(savedMainCategory, responseHeaders, HttpStatus.CREATED);
	}

	// GET ALL MAIN CATEGORY LISTS
	@GetMapping("")
	public List<MainCategory> listAllMainCategory() {
		logger.info("List all Main Category");
		return mainService.listAllMain();
	}

	// GET A MAIN CATEGORY
	@GetMapping("/{id}")
	public MainCategory getACategory(@PathVariable("id") Integer id) {
		logger.info("List a main category with id "+ id);
		return mainService.findByID(id);
	}
	
	// UPDATE A MAIN CATEGORY/
	@PutMapping("")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public MainCategory update(@RequestBody MainCategory main) {
		logger.info("Update a main category with id " + main.getId());
		return mainService.update(main);
	}

}
