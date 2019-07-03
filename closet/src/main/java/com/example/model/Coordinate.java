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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
//@Data
@Entity
@Table(name = "coordinate")
public class Coordinate {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "coordinate_id")
	private Integer coordinateId;
	
	@JsonIgnore
	@ManyToOne
	@JsonIdentityReference(alwaysAsId = true)
	@JoinColumn(name = "id")
	private User user;
	
	@Column(name = "coordinate_title", length = 30)
	private String coordinate_title;
	
	@Column(name = "comment", length = 300)
	private String comment;
	
	@JsonIgnore
	//@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Column(name = "created_at")
	private Date createdAt;
	
	@JsonIgnore
	@Column(name = "updated_at")
	private Date updatedAt;
	
	@JsonIgnore
	@Column(name = "have_calendar")
	private int haveCalender;
	
	/*カレンダー連携*/
	@JsonIgnore
	@OneToMany(mappedBy="coordinate",cascade = CascadeType.ALL,orphanRemoval=true)
	private List<Calendar> calendarList;
	
	/*Itemとの多対多連携*/
    @ManyToMany( mappedBy = "coordinatelist")
    private List<Item> itemlist;  
}
