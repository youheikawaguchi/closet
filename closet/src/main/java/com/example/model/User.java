package com.example.model;

import java.time.Year;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown=true)
@Entity
@Table(name = "users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	@Column(name = "id", nullable = false, precision = 11)
	private Integer id;
	
	@Size(min = 4, max = 30, message = "4~30文字で入力してください。")
	@Column(name = "user_id", length = 30, nullable=false, unique = true)
	private String userId;

	@Size(min = 8, max = 50, message = "4~50文字で入力してください。")
	@Column(name = "password", length = 50, nullable=false)
	private String password;
	
	@JsonIgnore
	@Column(name = "gender", length = 2)
	private String gender;

	@JsonIgnore
	@DateTimeFormat(pattern = "yyyy")
	@Column(name = "born_year", precision = 4)
	private Year bornYear;

	@JsonIgnore
	@Column(name = "admin_key")
	private byte adminKey;

	@JsonIgnore
	//@OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
	@Column(name = "area_id", precision = 11)
	private Integer areaId;
	
	@JsonIgnore
	@OneToMany(mappedBy="user",cascade = CascadeType.ALL,orphanRemoval=true)
	private List<Item> itemList;

}