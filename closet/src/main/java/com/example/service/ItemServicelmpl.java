package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Category;
import com.example.model.Color;
import com.example.model.Item;
import com.example.model.Season;
import com.example.model.SubCategory;
import com.example.repository.ItemRepository;

@Service
public class ItemServicelmpl implements ItemService{

	@Autowired
	ItemRepository itemRepository;
	
	@Override
	public List<Item> getAllItem() {
		return itemRepository.findAll();
	}
	
	@Override
	public Item getItemById(int id) {
		return itemRepository.findById(id).orElse(null);
	}
	
//	@Override
//	public Item getItemByName(String name) {
//		return ItemRepository.findByName(name);
//	}

	@Override
	public Item ItemCreate(Item item, Category category, SubCategory subcategory, Season season, Color color) {
		//item.setItem(item, category, subcategory, season, color);
		return itemRepository.save(item);
	}
	
	
}
