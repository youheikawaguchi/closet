package com.example.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "category")
public class Category {

	@Column(name = "category_id")
	private Integer categoryId;
	
	@Column(name = "category_name", length = 60, nullable=false)
	private String categoryName;
}
