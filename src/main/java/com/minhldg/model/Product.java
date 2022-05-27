package com.minhldg.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.minhldg.model.Product;

import lombok.Data;

@Entity
@Data
public class Product {
	
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	private long id;
	
	private String name;
	
	private double price;
	
	private int stock;
	
	@Column(columnDefinition = "nvarchar(1000)")
	private String description;
	
	private String manufacturer;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "category_id", referencedColumnName = "category_id")
	private Category category;
	
	private String condition;
	
	private String imageName;
	
	
}
