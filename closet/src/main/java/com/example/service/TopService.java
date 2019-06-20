package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Item;
import com.example.repository.ItemRepository;

@Service
public class TopService {
	@Autowired
	ItemRepository itemRepository;

	public List<Item> getAllItems() {
		return itemRepository.findAll();
	}
	
	/*
	public Item save(Item item) {
		return itemRepository.save(item);
	}
	
	public List<Item> findAll() {
		return itemRepository.findAll();
	}
	*/

}
