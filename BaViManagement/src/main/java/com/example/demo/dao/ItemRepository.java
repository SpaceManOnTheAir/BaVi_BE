package com.example.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.dto.ItemDto;
import com.example.demo.entity.Item;

public interface ItemRepository extends JpaRepository<Item, Integer> {

	
	@Query("select new com.example.demo.dto.ItemDto(it.id, it.name, it.description, it.price, it.photos, sb.id) "
			+ "from SubCategory sb join sb.itemIDs it")
	public List<ItemDto> getAllItem();
	
	
	@Query("select new com.example.demo.dto.ItemDto(it.id, it.name, it.description, it.price, it.photos, sb.id) "
			+ "from SubCategory sb join sb.itemIDs it "
			+ "where it.id= :id")
	public ItemDto getItemDto( Integer id);
	
	@Query("select new com.example.demo.dto.ItemDto(it.id, it.name, it.description, it.price, it.photos, sb.id) "
			+ "from SubCategory sb join sb.itemIDs it "
			+ "where sb.id= :id")
	public List<ItemDto> getItemBySub( Integer id);
}
