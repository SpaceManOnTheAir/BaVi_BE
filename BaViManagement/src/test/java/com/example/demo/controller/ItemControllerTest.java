package com.example.demo.controller;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.example.demo.dto.ItemDto;
import com.example.demo.entity.Item;
import com.example.demo.entity.MainCategory;
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ItemControllerTest {
	@LocalServerPort
	private int port;
	
	RestTemplate restTemplate = new RestTemplate();
	
	private String getRootUrl(){
		return "http://localhost:"+port;
	}
	
	@Test
	public void testListAllItem() 
	{		
		ResponseEntity<ItemDto[]> responseEntity = restTemplate.getForEntity(getRootUrl()+"/item", ItemDto[].class); 
		System.out.println(responseEntity.getBody().toString());
        List<ItemDto> mains = Arrays.asList(responseEntity.getBody());
	}
	
	@Test
	public void testCreateItem() {
		ItemDto item  = new ItemDto();
		item.setName("This is a test item");
		item.setPrice(99999.9);
		item.setDescription("This is a test description");
		
		ResponseEntity<ItemDto> itemRespone = restTemplate.postForEntity(getRootUrl()+"/item", item, ItemDto.class); 
		 assertNotNull(itemRespone);
	        assertNotNull(itemRespone.getBody());
		
		
	}
	
	@Test
	public void testGetAnItem() {
		ItemDto item = restTemplate.getForObject(getRootUrl()+"/item/1", ItemDto.class); 
		assertNotNull(item);
	}
	
	@Test
	public void testGetAnItemBySubID() {
		ResponseEntity<ItemDto[]> item = restTemplate.getForEntity(getRootUrl()+"/item/sub/1", ItemDto[].class); 
		List<ItemDto> items = Arrays.asList(item.getBody());
		assertNotNull(items);
	}
	
	@Test
	public void testGetAnItemByMainID() {
		ResponseEntity<ItemDto[]> item = restTemplate.getForEntity(getRootUrl()+"/item/main/1", ItemDto[].class); 
		List<ItemDto> items = Arrays.asList(item.getBody());
		assertNotNull(items);
	}
	
	
	
	
	
	

}
