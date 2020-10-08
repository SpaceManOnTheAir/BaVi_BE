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

	// CREATE AN ITEM
	public Item createItem(ItemDto anItemDto) {
		Integer subCategoryId = anItemDto.getSubCategory_ID();
		SubCategory subCategory = null;
		if (subCategoryId == null)
			throw new IllegalArgumentException("Cannot be null in subCategory_ID");
		else {
			if (subRepo.findById(subCategoryId).isPresent())
				subCategory = subRepo.findById(subCategoryId).get();
		}
		// CHECK PRICE
		if (anItemDto.getPrice() <= 0)
			throw new IllegalArgumentException("Price cannot be negative");
		Item anItem = new Item(anItemDto, subCategory);
		return itemRepo.save(anItem);

	}

	// UPDATE AN ITEM
	public Item updateItem(Integer id, ItemDto anItemDto) {
		Integer subCategoryId = anItemDto.getSubCategory_ID();
		SubCategory subCategory = null;
		if (subCategoryId == null)
			throw new IllegalArgumentException("Cannot be null in subCategory_ID");
		else {
			if (subRepo.findById(subCategoryId).isPresent())
				subCategory = subRepo.findById(subCategoryId).get();
		}
		// CHECK PRICE
		if (anItemDto.getPrice() <= 0)
			throw new IllegalArgumentException("Price cannot be negative");
		Item updateItem = getAnItem(id);
		updateItem.setName(anItemDto.getName());
		updateItem.setDescription(anItemDto.getDescription());
		updateItem.setPrice(anItemDto.getPrice());
		updateItem.setPhotos(anItemDto.getPhotos());
		updateItem.setSubCategory_ID(subCategory);

		return itemRepo.save(updateItem);

	}
//	// LIST ALL 
//	public List<Item> listAll() {
//		return itemRepo.findAll();
//	}
	// GET AN ITEM BY ID
	public Item getAnItem(int id) {
		return itemRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("No Item found with id=" + id));
	}
	// DELETE AN ITEM
	public void deleteAnItem(int id) {
		itemRepo.deleteById(id);
	}
	
	public List<ItemDto> getAllItem() {
		return itemRepo.getAllItem();
	}

	public ItemDto getAnItemDto(int id) {
		return itemRepo.getItemDto(id);
	}

	// get Item by Sub ID
	public List<ItemDto> getItemBySub(int id) {
		return itemRepo.getItemBySub(id);
	}

	// get Item by Main ID
	public List<ItemDto> getItemByMain(int id) {
		return itemRepo.getItemByMain(id);
	}

}
