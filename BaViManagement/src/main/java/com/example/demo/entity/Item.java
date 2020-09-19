package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import com.example.demo.dto.ItemDto;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@javax.persistence.Table(name = "_item")
public class Item {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "item_name", nullable = false)
	private String name;

	@Lob
	@Column(name = "item_description", nullable = false)
	private String description;

	@Column(name = "item_price", nullable = true)
	private Double price;

	@ManyToOne
//	@JsonIgnore
	@JsonBackReference
	@JoinColumn(name = "subCategory_ID", nullable = false)
	private SubCategory subCategory_ID;

	private String photos;

	public Item(String name, String description, Double price, SubCategory subCategory_ID) {
		super();
		this.name = name;
		this.description = description;
		this.price = price;
		this.subCategory_ID = subCategory_ID;
	}
	public Item(ItemDto itemDto, SubCategory subCategory) {
		super();
		this.name = itemDto.getName();
		this.description = itemDto.getDescription();
		this.price = itemDto.getPrice();
		this.subCategory_ID = subCategory;
	}

	public Item() {
		super();
	}

	public String getPhotos() {
		return photos;
	}

	public void setPhotos(String photos) {
		this.photos = photos;
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

	public SubCategory getSubCategory_ID() {
		return subCategory_ID;
	}

	public void setSubCategory_ID(SubCategory subCategory_ID) {
		this.subCategory_ID = subCategory_ID;
	}

}
