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

import com.example.demo.entity.MainCategory;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class MainCategoryControllerTest {

	
	@LocalServerPort
	private int port;
	
	RestTemplate restTemplate = new RestTemplate();
	
	private String getRootUrl(){
		return "http://localhost:"+port;
	}
	
	@Test
	public void testGetAllMainCategory() 
	{		
		ResponseEntity<MainCategory[]> responseEntity = restTemplate.getForEntity(getRootUrl()+"/mainCategory", MainCategory[].class); 
		System.out.println(responseEntity.getBody().toString());
        List<MainCategory> mains = Arrays.asList(responseEntity.getBody());
	}
	
	@Test
	public void testGetMainCategoryByID() 
	{	
		MainCategory post = restTemplate.getForObject(getRootUrl()+"/mainCategory/1", MainCategory.class); 
		assertNotNull(post);
	}
	
	@Test
	public void testCreateMainCategory() 
	{
		MainCategory post = new MainCategory();
		post.setName("Something");
		post.setDescription("Something");
		ResponseEntity<MainCategory> postResponse = restTemplate.postForEntity(getRootUrl()+"/mainCategory", post, MainCategory.class); 
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());	}
	

}
