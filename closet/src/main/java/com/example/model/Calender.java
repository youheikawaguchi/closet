package com.example.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "calender")
public class Calender {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "calender_id")
	private Integer calenderId;
	
	//@JsonIgnore
	//@OneToMany(mappedBy = "user")
	//@Column(name = "user_id",nullable = false , precision = 11)
	//private User user;
	
	//@JsonIgnore
	//@OneToMany(mappedBy = "user")
	//@Column(name = "coodinate_id",nullable = false , precision = 11)
	//private Coodinate coodinate;
	
	@Column(name = "event", length = 30)
	private String event;
	
	@JsonIgnore
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "event_date",nullable=false)
	private Date eventDate;
	
	@Column(name = "met_parson", length = 30)
	private String metParson;
}
