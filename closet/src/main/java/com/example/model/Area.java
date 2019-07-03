package com.example.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Digits;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "areas")
public class Area {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "area_id")
	private Integer areaId;
	
	/*都道府県*/
	@Column(name = "area_name", length = 60, nullable=false)
	private String areaName;
	
	/*緯度*/
	@Digits(integer=9, fraction=6)
	@Column(name = "latitude", length = 60, nullable=false)
	private double latitude;
	
	/*経度*/
	@Digits(integer=9, fraction=6)
	@Column(name = "longitude", length = 60, nullable=false)
	private double longitude;
	
	@JsonIgnore
	@OneToMany(mappedBy="area",cascade = CascadeType.ALL,orphanRemoval=true)
	private List<User> userlist;
}
