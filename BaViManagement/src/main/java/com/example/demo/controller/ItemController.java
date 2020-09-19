package com.example.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ItemDto;
import com.example.demo.entity.Item;
import com.example.demo.service.ItemService;

@RestController
@RequestMapping(value = "/item")
public class ItemController {

	@Autowired
	private  ItemService itemService;
	
	@PostMapping(value = "")
	public Item createItem(@RequestBody @Valid ItemDto anItemDto, BindingResult result) {
		if(result.hasErrors()) throw new IllegalArgumentException("Invalid data Item");
		return itemService.createItem(anItemDto);
	}
	
	@GetMapping(value = "")
	public List<Item> listAllItem(){
		return itemService.listAll();
	}
	
	@GetMapping(value = "/{id}")
	public Item getAnItem(@PathVariable(value = "id") Integer id){
		return itemService.getAnItem(id);
	}
	
	@PutMapping(value = "/{id}")
	public Item updateAnItem(@PathVariable(value = "id") Integer id, @RequestBody ItemDto itemDto){
		return itemService.updateItem(id, itemDto);
	}
	
	@DeleteMapping(value="/{id}")
	public void deleteAnItem(@PathVariable(value = "id") Integer id){
		itemService.deleteAnItem(id);
	}


	

	
	
	

	
	
	
	

	
	
	
}
