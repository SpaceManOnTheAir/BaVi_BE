package com.example.demo.dto;

public class ItemDto {

	private Integer id;
	private String name;
	private String description;
	private Double price;
	private String photos;
	private Integer subCategory_ID;

	public ItemDto(String name, String description, Double price, String photos, Integer subCategory_ID) {
		super();
		this.name = name;
		this.description = description;
		this.price = price;
		this.photos = photos;
		this.subCategory_ID = subCategory_ID;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getPhotos() {
		return photos;
	}

	public void setPhotos(String photos) {
		this.photos = photos;
	}

	public Integer getSubCategory_ID() {
		return subCategory_ID;
	}

	public void setSubCategory_ID(Integer subCategory_ID) {
		this.subCategory_ID = subCategory_ID;
	}

}
