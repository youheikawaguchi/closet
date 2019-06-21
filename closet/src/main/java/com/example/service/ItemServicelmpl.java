/*package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.model.Calender;
import com.example.model.Category;
import com.example.model.Color;
import com.example.model.Item;
import com.example.model.Season;
import com.example.model.SubCategory;
import com.example.repository.CalendarRepository;

public class ItemServicelmpl implements ItemService{

	@Autowired
	CalendarRepository calendarRepository;
	
	@Override
	public List<Item> getAllItem() {
		return ItemRepository.findAll();
	}
	
	@Override
	public Item getItemById(int id) {
		return ItemRepository.findById(id).orElse(null);
	}
	
	@Override
	public Item ItemCreate(Item item, Category category, SubCategory SubCategory,
			Season season, Color color ) {
		
		
		return ItemRepository.save(Item);
	}
}*/
