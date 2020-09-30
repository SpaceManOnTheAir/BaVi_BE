package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.TableRepository;
import com.example.demo.entity.Table;
import com.example.demo.exception.ResourceNotFoundException;

@Service
public class TableService {

	@Autowired
	private TableRepository tableRepo;

	public List<Table> listAll() {
		return tableRepo.findAll();
	}

	public Table getATable(int id) {
		return tableRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Invalid table id"));
	}

	public Table createTable(Table aTable) {
		return tableRepo.save(aTable);
	}

	public Table updateTable(Integer id, Table aTable) {
		Table updateTable = null;
		if (tableRepo.findById(id).isPresent()) {
			updateTable=tableRepo.findById(id).get();
			updateTable.setTable_name(aTable.getTable_name());
			updateTable.setTable_no(aTable.getTable_no());

		} else {
			throw new ResourceNotFoundException();
		}

		return tableRepo.save(updateTable);
	}

	public void deleteTable(Integer id) {
		tableRepo.deleteById(id);
	}

}
