package com.example.service;

import java.util.List;

import com.example.model.*;
import org.springframework.security.core.userdetails.UserDetails;


public interface ItemService {
	public List<Item> getAllItem();
	public Item getItemById(int id);
	public void delete(int id);

	ItemSelect itemCreateForm();
	//public Item getItemByName(String name);
	public Item ItemCreate(ItemForm itemForm, UserDetails userDetails);
	public List<Item> userItemList(UserDetails userDetails);
	public Item itemUpdate(int id, ItemForm itemForm, UserDetails userDetails);
	
}
