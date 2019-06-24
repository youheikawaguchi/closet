package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.controller.TopController;
import com.example.model.Item;
import com.example.repository.ItemRepository;


@Service
public class TopService {
	@Autowired
	ItemRepository itemRepository;
	@Autowired
	TopController topController;

	public List<Item> getAllItems() {
		return itemRepository.findAll();
	}
	
	public List<Item> getSlideItems(int[] getSeason.seasonId) {
		int[] getSeason = topController.getSeason();
		for(int i = 0; i <= getSeason.length ; i++) {
			List<Item> items = itemRepository.findBySlideImg(getSeason.seasonId[i]);
		return items;
		}
		
	}
	

}