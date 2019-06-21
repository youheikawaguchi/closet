package com.example.service;

import java.util.List;

import com.example.model.Category;
import com.example.model.Color;

public interface ColorService {
	public List<Color> getAllColor();
	public Color getColorById(int id);
	public Color getColorByName(String name);
}
