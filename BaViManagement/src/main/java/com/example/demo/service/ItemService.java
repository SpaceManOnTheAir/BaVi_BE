package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ItemRepository;
import com.example.demo.dao.SubCategoryRepository;
import com.example.demo.dto.ItemDto;
import com.example.demo.entity.Item;
import com.example.demo.entity.SubCategory;
import com.example.demo.exception.ResourceNotFoundException;

@Service
public class ItemService {
	@Autowired
	private ItemRepository itemRepo;

	@Autowired 
	private SubCategoryRepository subRepo;
	
	public Item createItem (ItemDto anItemDto) {
		Integer subCategoryId = anItemDto.getSubCategory_ID();
		SubCategory subCategory = null;
		if(subCategoryId  == null) throw new IllegalArgumentException("Cannot be null in subCategory_ID");	
		else {
			if(subRepo.findById(subCategoryId).isPresent())
				subCategory=subRepo.findById(subCategoryId).get();
		}
		Item anItem = new Item(anItemDto, subCategory);
		return itemRepo.save(anItem);
		
	}
	
	public Item updateItem (Integer id,ItemDto anItemDto) {
		Integer subCategoryId = anItemDto.getSubCategory_ID();
		SubCategory subCategory = null;
		if(subCategoryId  == null) throw new IllegalArgumentException("Cannot be null in subCategory_ID");	
		else {
			if(subRepo.findById(subCategoryId).isPresent())
				subCategory=subRepo.findById(subCategoryId).get();
		}
		Item updateItem = getAnItem(id);
		updateItem.setName(anItemDto.getName());
		updateItem.setDescription(anItemDto.getDescription());
		updateItem.setPrice(anItemDto.getPrice());
		updateItem.setPhotos(anItemDto.getPhotos());
		updateItem.setSubCategory_ID(subCategory);
		
		return itemRepo.save(updateItem);
		
	}
	
	public List<Item> listAll() {
		return itemRepo.findAll();
	}
	
	public Item getAnItem(int id) {
		return itemRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No Item found with id=" + id));
	}
	public void deleteAnItem(int id) {
		itemRepo.deleteById(id);
	}
	
}
