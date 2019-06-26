package com.example.service;

import java.util.List;

import com.example.model.SubCategory;


public interface SubCategoryService {
	
	public List<SubCategory> getAllSubCategory();
	public SubCategory getSubCategoryById(int id);
	public SubCategory getSubCategoryByName(String name);
}
