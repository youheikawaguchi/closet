package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Color;
import com.example.repository.ColorRepository;

@Service
public class ColorServicelmpl implements ColorService{
	@Autowired
	ColorRepository ColorRepository;
	
	@Override
	public List<Color> getAllColor() {
		return ColorRepository.findAll();
	}

	@Override
	public Color getColorById(int id) {
		return ColorRepository.findById(id).orElse(null);
	}
	@Override
	public Color getColorByName(String name) {
		return ColorRepository.findByColorName(name);
	}
	
}
