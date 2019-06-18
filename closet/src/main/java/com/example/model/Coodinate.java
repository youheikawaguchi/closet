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
@Table(name = "coodinate")
public class Coodinate {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "coodinate_id")
	private Integer coodinateId;
	
	//@JsonIgnore
	//@OneToMany(mappedBy = "user")
	//@Column(name = "user_id",nullable = false , precision = 11)
	//private User user;
	
	@Column(name = "event", length = 30)
	private String coodinate_title;
	
	@Column(name = "comment", length = 300)
	private String comment;
	
	//@JsonIgnore
	//@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "create_at")
	private Date createAt;
	
	@Column(name = "update_at")
	private Date updateAt;
	
	@JsonIgnore
	@Column(name = "have_calender")
	private byte haveCalender;
}
