package com.example.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "season")
public class Season {

	/*SeasonId*/
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "season_id", length = 11)
	private Integer season_id;
	
	/*SeasonName*/
	@Column(name = "season_name", length = 60, nullable=false)
	private String seasonName;
	

	@OneToMany(mappedBy="season",cascade = CascadeType.ALL,orphanRemoval=true)
	private List<Item> itemlist;
}
