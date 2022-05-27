package com.minhldg.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.minhldg.model.Category;

import lombok.Data;

@Entity
@Data
public class Category {
	
	@Id
	@GeneratedValue (strategy = GenerationType.AUTO)
	@Column(name = "category_id")
	private int id;
	
	private String name;
}
