package com.example.service;

import java.util.List;

import com.example.model.Category;
import com.example.model.Color;
import com.example.model.Item;
import com.example.model.Season;
import com.example.model.SubCategory;


public interface ItemService {
	public List<Item> getAllItem();
	public Item getItemById(int id);
	//public Item getItemByName(String name);
	public Item ItemCreate(Item item, Category category, SubCategory subcategory, Season season, Color color);
	
}
