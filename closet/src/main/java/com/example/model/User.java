package com.example.model;

import java.time.Year;
import java.util.Date;
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
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class)//循環参照防止
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

	@Size(min = 8, max = 100, message = "8~16文字で入力してください。")
	@Column(name = "password", length = 100, nullable=false)
	private String password;
	
	@Column(name = "gender", length = 2)
	private String gender;

	@Column(name = "born_year", precision = 4)
	private String bornYear;

	@Column(name = "admin_key")
	private byte adminKey;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "area_id")
	private Area area;
	
	@JsonIgnore
	@OneToMany(mappedBy="user",cascade = CascadeType.ALL,orphanRemoval=true)
	private List<Item> itemList;

	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL,orphanRemoval=true)
	private List<Calendar> calendarList;
	
	@JsonIgnore
	@OneToMany(mappedBy="user")
	private List<Coordinate> coordinateList;
}