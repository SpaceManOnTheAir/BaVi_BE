package com.example.demo.dto;

public class SubDto {
//	private Integer id;
	private String name;
	private int mainCategory_ID;
	
	public SubDto(String name, int mainCategory_ID) {
		super();
		this.name = name;
		this.mainCategory_ID = mainCategory_ID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMainCategory_ID() {
		return mainCategory_ID;
	}

	public void setMainCategory_ID(int mainCategory_ID) {
		this.mainCategory_ID = mainCategory_ID;
	}



}
