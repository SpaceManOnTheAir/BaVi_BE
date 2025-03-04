package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Table;
import com.example.demo.service.TableService;

@RestController
@RequestMapping(value = "/tables")
public class TableController {

	@Autowired
	private TableService tableService;

	// CREATE A TABLE
	@PostMapping(value = "")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public Table createATable(@RequestBody Table aTable, BindingResult result) {
		if (result.hasErrors())
			throw new IllegalArgumentException("Invalid Table data");
		return tableService.createTable(aTable);
	}
	
	// UPDATE A TABLE
	@PutMapping(value = "/{id}")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public Table updateATable(@PathVariable (value = "id") Integer id,@RequestBody Table aTable, BindingResult result) {
		if (result.hasErrors())
			throw new IllegalArgumentException("Invalid Table data");
		return tableService.updateTable(id, aTable);
	}

	// GET A LIST OF TABLE
	@GetMapping(value = "")
	public List<Table> listAll() {
		return tableService.listAll();
	}

	// GET A TABLE
	@GetMapping(value = "/{id}")
	public Table getATable(@PathVariable (value = "id")int id) {
		return tableService.getATable(id);
	}

	// DELETE A TABLE
	@DeleteMapping(value = "/{id}")
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public void deleteATable(@PathVariable("id")Integer id) {
		tableService.deleteTable(id);
	}
}
