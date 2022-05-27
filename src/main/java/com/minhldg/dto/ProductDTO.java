package com.minhldg.dto;


import lombok.Data;

@Data
public class ProductDTO {
	
	private long id;
	
	private String name;
	
	private double price;
	
	private int stock;
	
	private String description;
	
	private String manufacturer;
	
	private int categoryId;
	
	private String condition;
	
	private String imageName;
}
