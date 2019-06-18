package com.example.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "sub_category")
public class SubCategory {
	
	@Column(name = "sub_category_id")
	private Integer subCategoryId;
	
	@Column(name = "category_id")
	private Integer categoryId;
	
	@Column(name = "category_name", length = 60, nullable=false)
	private String categoryName;
}
