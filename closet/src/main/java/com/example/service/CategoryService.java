package com.example.service;

import java.util.List;

import com.example.model.Category;


public interface CategoryService {

	public List<Category> getAllCategory();
	public Category getCategoryById(int id);
	public Category getCategoryByName(String name);
	
}
