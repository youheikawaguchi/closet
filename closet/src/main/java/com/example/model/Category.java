package com.example.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "category")
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "category_id")
	private Integer categoryId;
	
	@Column(name = "category_name", length = 60, nullable=false)
	private String categoryName;
	
	@OneToMany(mappedBy="category",cascade = CascadeType.ALL,orphanRemoval=true)
	private List<Item> itemlist;
	
	@OneToMany(mappedBy="category",cascade = CascadeType.ALL,orphanRemoval=true)
	private List<Item> subCategorylist;
}
