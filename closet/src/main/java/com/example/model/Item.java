package com.example.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	
	@JsonIgnore
	//@OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
	@Column(name = "category_id",nullable = false ,precision = 11)
	private int categoryId;
	
	@JsonIgnore
	//@OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
	@Column(name = "sub_category_id", precision = 11)
	private int subCategoryId;
	
	@JsonIgnore
	//@OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
	@Column(name = "season_id", precision = 11)
	private int seasonId;
	
	@JsonIgnore
	//@OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
	@Column(name = "color_id", precision = 11)
	private int colorId;
	
	@JsonIgnore
	@OneToMany(mappedBy = "user")
	@Column(name = "user_id",nullable = false , precision = 11)
	private User user;
	
	//@OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
	@Column(name = "picture",nullable = false)
	private String picture;
	
	@Size(max = 300, message = "300字以下で入力してください")
	//@OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
	@Column(name = "comment")
	private String comment;
	
	//@JsonIgnore
	//@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "create_at")
	private Date createAt;
	
	@Column(name = "update_at")
	private Date updateAt;
}
