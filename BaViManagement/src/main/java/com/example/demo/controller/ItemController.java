package com.example.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.ItemDto;
import com.example.demo.entity.Item;
import com.example.demo.service.ItemService;

@RestController
@RequestMapping(value = "/item")
public class ItemController {

	@Autowired
	private  ItemService itemService;
	
	private static final Logger logger = LoggerFactory.getLogger(ItemController.class);
	
	@PostMapping(value = "")
	public Item createItem(@RequestBody @Valid ItemDto anItemDto, BindingResult result) {
		if(result.hasErrors()) throw new IllegalArgumentException("Invalid data Item");
		logger.info("create an Item name:" + anItemDto.getName());
		return itemService.createItem(anItemDto);
	}
	
	@GetMapping(value = "")
	public List<ItemDto> listAllItem(){
		logger.info("list all Item");
		return itemService.getAllItem();
	}
	
	@GetMapping(value = "/{id}")
	public ItemDto getAnItem(@PathVariable(value = "id") Integer id){
		logger.info("Get an Item id " +id);
		return itemService.getAnItemDto(id);
	}
	
	@PutMapping(value = "/{id}")
	public Item updateAnItem(@PathVariable(value = "id") Integer id, @RequestBody ItemDto itemDto){
		logger.info("Update an Item id " +id+" with name " + itemDto.getName());
		return itemService.updateItem(id, itemDto);
	}
	
	@DeleteMapping(value="/{id}")
	public void deleteAnItem(@PathVariable(value = "id") Integer id){
		logger.info("Delete an Item id" +id);
		itemService.deleteAnItem(id);
	}
	
	//	GET ITEM BY SUB CATEGORY
	@GetMapping("/sub/{id}")
	public List<ItemDto> getAnItemBySubID(@PathVariable(value = "id") Integer id){
		logger.info("Get an Item by sub id " +id);
		return itemService.getItemBySub(id);
	}
	
	//	GET ITEM BY MAIN CATEGORY
//	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/main/{id}")
	public List<ItemDto> getAnItemByMainID(@PathVariable(value = "id") Integer id){
		logger.info("Get an Item by main id " +id);
		return itemService.getItemByMain(id);
	}


	

	
	
	

	
	
	
	

	
	
	
}
