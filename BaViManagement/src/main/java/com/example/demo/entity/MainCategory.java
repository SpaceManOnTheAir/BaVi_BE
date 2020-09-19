package com.example.demo.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
//@javax.persistence.Table(name="main_category")
public class MainCategory {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "name", nullable = false)
	private String name;
	@Column(name = "description", nullable = false)
	private String description;
	
//	@JsonManagedReference
	@JsonIgnore
	@OneToMany(mappedBy = "mainCategory_ID")
	private List<SubCategory> subCategories;


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


	public List<SubCategory> getSubCategories() {
		return subCategories;
	}


	public void setSubCategories(List<SubCategory> subCategories) {
		this.subCategories = subCategories;
	}


	public MainCategory( String name, String description, List<SubCategory> subCategories) {
		super();
		this.name = name;
		this.description = description;
		this.subCategories = subCategories;
	}


	public MainCategory() {
		super();
	}
	
	

}
