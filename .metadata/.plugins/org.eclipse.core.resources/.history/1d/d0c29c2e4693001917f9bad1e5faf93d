package com.example.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "calendar")
public class Calendar {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "calender_id")
	private Integer calendarId;
	
	//@JsonIgnore
	//@OneToMany(mappedBy = "user")
	@Column(name = "id",nullable = false , precision = 11)
	private /*User*/ int user;
	
	/*coordinate：一対多*/
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "coordinate_id")
	private Coordinate coordinate;
	
	@Column(name = "event", length = 30)
	private String event;
	
	@JsonIgnore
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "event_date",nullable=false)
	private Date eventDate;
	
	@Column(name = "met_person", length = 30)
	private String metPerson;

}
