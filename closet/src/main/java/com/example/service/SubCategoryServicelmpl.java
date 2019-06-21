package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Category;
import com.example.model.SubCategory;
import com.example.repository.SubCategoryRepository;

@Service
public class SubCategoryServicelmpl implements SubCategoryService{
	@Autowired
	SubCategoryRepository subCategoryrepository;
	
	@Override
	public List<SubCategory> getAllSubCategory() {
		return subCategoryrepository.findAll();
	}
	
	@Override
	public SubCategory getSubCategoryById(int id) {
		return subCategoryrepository.findById(id).orElse(null);
	}
	
	@Override
	public SubCategory getSubCategoryByName(String name) {
		return subCategoryrepository.findBySubCategoryName(name);
	}
}
