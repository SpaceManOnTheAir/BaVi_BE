package com.example.demo.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.example.demo.dto.SubDto;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@javax.persistence.Table(name="subCategory")
public class SubCategory {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "name", nullable = false)
	private String name;
	@JsonIgnore
	@ManyToOne
//	@JsonBackReference
	@JoinColumn(name="main_category_ID")
	private MainCategory mainCategory_ID;
	
	@JsonManagedReference
//	@JsonIgnore
	@OneToMany(mappedBy = "subCategory_ID")
	private List<Item> itemIDs;


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


	public MainCategory getMainCategory_ID() {
		return mainCategory_ID;
	}


	public void setMainCategory_ID(MainCategory mainCategory_ID) {
		this.mainCategory_ID = mainCategory_ID;
	}


	public List<Item> getItemIDs() {
		return itemIDs;
	}


	public void setItemIDs(List<Item> itemIDs) {
		this.itemIDs = itemIDs;
	}


	public SubCategory(Integer id, String name, MainCategory mainCategory_ID, List<Item> itemIDs) {
		super();
		this.id = id;
		this.name = name;
		this.mainCategory_ID = mainCategory_ID;
		this.itemIDs = itemIDs;
	}

	public SubCategory(SubDto subDto, MainCategory main) {
		super();
		this.setName(subDto.getName()) ;
		this.setMainCategory_ID(main);
	}

	public SubCategory() {
		super();
	} 
	
	

}
