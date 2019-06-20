package com.example.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "items")
public class Item {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "item_id", nullable = false, precision = 11)
	private Integer itemId;
	
	/*subCategoryID*/
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "category_id")
	private Category category;
	
	/*subCategoryID*/
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "sub_category_id")
	private SubCategory subCategory;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "season_id")
	private Season season;
	
	@JsonIgnore
	//@OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
	@Column(name = "color_id", precision = 11)
	private Integer colorId;
	
	/*usersのID:双方向にするとき*/
	//@JsonIgnore
	//@OneToMany(mappedBy = "user")
	//private User user;
	
	//@OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
	@Column(name = "picture")
	private String picture;
	
	@Size(max = 300, message = "300字以下で入力してください")
	//@OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
	@Column(name = "comment")
	private String comment;
	
	//@JsonIgnore
	//@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "created_at")
	private Date createdAt;
	
	@Column(name = "updated_at")
	private Date updatedAt;
}