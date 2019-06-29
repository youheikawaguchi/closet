package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Category;
import com.example.repository.CategoryRepository;

@Service
public class CategoryServicelmpl implements CategoryService{
	@Autowired
	CategoryRepository CategoryRepository;
	
	@Override
	public List<Category> getAllCategory() {
		return CategoryRepository.findAll();
	}
	
	@Override
	public Category getCategoryById(int id) {
		return CategoryRepository.findById(id).orElse(null);
	}
	
	@Override
	public Category getCategoryByName(String name) {
		return CategoryRepository.findByCategoryName(name);
	}
}
