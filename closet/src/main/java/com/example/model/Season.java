package com.example.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "season")
public class Season {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "season_id")
	private Integer seasonId;
	
	@Column(name = "season_name", length = 60, nullable=false)
	private String seasonName;
}
