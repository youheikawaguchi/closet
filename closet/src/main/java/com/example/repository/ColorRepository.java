package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.Color;

public interface ColorRepository extends JpaRepository<Color, Integer>{
	public Color findByColorName(String colorName);
}
