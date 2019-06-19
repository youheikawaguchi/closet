package com.example.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "coordinate")
public class Coordinate {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "coordinate_id")
	private Integer coordinateId;
	
	//@JsonIgnore
	//@OneToMany(mappedBy = "user")
	@Column(name = "id",nullable = false , precision = 11)
	private /*User*/ int user;
	
	@Column(name = "coordinate_title", length = 30)
	private String coordinate_title;
	
	@Column(name = "comment", length = 300)
	private String comment;
	
	//@JsonIgnore
	//@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "created_at")
	private Date createdAt;
	
	@Column(name = "updated_at")
	private Date updatedAt;
	
	@JsonIgnore
	@Column(name = "have_calender")
	private byte haveCalender;
}
