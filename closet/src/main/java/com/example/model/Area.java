package com.example.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Digits;

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
	
	@Column(name = "area_name", length = 60, nullable=false)
	private String areaName;
	
	@Digits(integer=9, fraction=6)
	@Column(name = "longitude", length = 60, nullable=false)
	private double longitude;
	@Digits(integer=9, fraction=6)
	@Column(name = "latitude", length = 60, nullable=false)
	private double latitude;
}
