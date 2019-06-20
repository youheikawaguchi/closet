package com.example.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "sub_category")
public class SubCategory {
	/*SubCategoryID*/
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "sub_category_id",length = 11)
	private Integer subCategoryId;
	
	/*CategoryID*/
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;
	
	/*SubCategoryName*/
	@Column(name = "subcategory_name", length = 60, nullable=false)
	private String subCategoryName;
	
	
	@OneToMany(mappedBy="subCategory",cascade = CascadeType.ALL,orphanRemoval=true)
	private List<Item> itemlist;
}
