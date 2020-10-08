package com.example.demo.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.example.demo.dto.SubDto;
import com.example.demo.entity.SubCategory;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class SubCategoryControllerTest {
	@LocalServerPort
	private int port;

	RestTemplate restTemplate = new RestTemplate();

	private String getRootUrl() {
		return "http://localhost:" + port;
	}

	@Test
	void testListAllCategory() {
		ResponseEntity<SubCategory[]> responeEntity = restTemplate.getForEntity(getRootUrl() + "/sub/1",
				SubCategory[].class);
		List<SubCategory> subs = Arrays.asList(responeEntity.getBody());
		assertNotNull(subs);
	}

	@Test
	void testListAllSUB() {
		ResponseEntity<SubCategory[]> responeEntity = restTemplate.getForEntity(getRootUrl() + "/sub",
				SubCategory[].class);
		List<SubCategory> subs = Arrays.asList(responeEntity.getBody());
		assertNotNull(subs);
	}

	@Test
	void testCreateASubCategory() {
		SubDto subcategory = new SubDto("test create a sub category", 1);
		ResponseEntity<SubCategory> responeEntity = restTemplate.postForEntity(getRootUrl() + "/sub", subcategory,
				SubCategory.class);
		
		assertNotNull(responeEntity);
		assertNotNull(responeEntity.getBody());
	}

	@Test
	void testUpdateSubCategory() {
		int id = 1;
		SubCategory subcategory = restTemplate.getForObject(getRootUrl() + "/sub/sub/" + id, SubCategory.class);
		subcategory.setName("Test update a sub category" + subcategory.getId() + " name" + subcategory.getName());
		SubDto subDto = new SubDto(subcategory.getName(), subcategory.getId());

		// update api
		restTemplate.put(getRootUrl() + "/sub/" + id, subDto);
		SubCategory responeEntity = restTemplate.getForObject(getRootUrl() + "/sub/sub/" + id, SubCategory.class);
		assertNotNull(responeEntity);
	}

	@Test
	void testDeleteSubCategory() {
		int id = 46;
		SubCategory subcategory = restTemplate.getForObject(getRootUrl() + "/sub/sub/" + id, SubCategory.class);

		// Delete API
		try {
			restTemplate.delete(getRootUrl() + "/sub/" + id);
		} catch (final HttpClientErrorException e) {
			assertEquals(e.getStatusCode(), HttpStatus.NOT_FOUND);
		}
	}

}
