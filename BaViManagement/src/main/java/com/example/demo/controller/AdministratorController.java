package com.example.demo.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.Tokenizer;
import com.example.demo.entity.Administrator;
import com.example.demo.service.AdministratorService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.Authorization;


@RestController
@RequestMapping(value = "/admin")
public class AdministratorController {
	@Autowired
	private AdministratorService adminService;

	@Autowired
	private ModelMapper modelMapper;

	@PostMapping("/signin")
	@ApiOperation(value = "${AdministratorController.signin}")
	@ApiResponses(value = { //
			@ApiResponse(code = 400, message = "Something went wrong"), //
			@ApiResponse(code = 422, message = "Invalid username/password supplied") })
	public Tokenizer login(//
			@ApiParam("username") @RequestParam String username, //
			@ApiParam("password") @RequestParam String password) {
		return adminService.signin(username, password);
	}

	@GetMapping(value = "")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public List<Administrator> getAllStudents() {
		return adminService.getAllStudents();
	}

	@PostMapping(value = "")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public Administrator createAStudent(@RequestBody Administrator aStudent) {
		return adminService.createAStudent(aStudent);
	}

	// GET AN ADMIN
	@GetMapping(value = "/{id}")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public Administrator getAStudent(@PathVariable(value = "id") Integer id) throws Exception {
		return adminService.getAnAdmin(id);
	}

	// UPDATE AN ADMIN
	@PutMapping(value = "/{id}")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@ApiOperation(value = "${UserController.getAllUsers}", authorizations = { @Authorization(value = "apiKey") })
	@ApiResponses(value = { @ApiResponse(code = 400, message = "Something went wrong"), //
			@ApiResponse(code = 403, message = "Access denied"), //
			@ApiResponse(code = 404, message = "The user doesn't exist"), //
			@ApiResponse(code = 500, message = "Expired or invalid JWT token") })
	public Administrator updateAStudent(@PathVariable(value = "id") Integer id, @RequestBody Administrator admin)
			throws Exception {
		return adminService.updateAStudent(id, admin);
	}

}
