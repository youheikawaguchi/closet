package com.example.service;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import com.example.model.*;
import com.example.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ItemServiceImpl implements ItemService{

	@Autowired
	ItemRepository itemRepository;
	@Autowired
	CategoryRepository categoryRepository;
	@Autowired
	SubCategoryRepository subCategoryRepository;
	@Autowired
	SeasonRepository seasonRepository;
	@Autowired
	ColorRepository colorRepository;
	@Autowired
	UserRepository userRepository;

	@Autowired
	
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
	public ItemSelect itemCreateForm(){
		ItemSelect itemSelect = new ItemSelect();
		itemSelect.setCategoryList(categoryRepository.findAll());
		itemSelect.setSubCategoryList(subCategoryRepository.findAll());
		itemSelect.setSeasonList(seasonRepository.findAll());
		itemSelect.setColorList(colorRepository.findAll());
		return itemSelect;
	}

	@Override
	public Item ItemCreate(ItemForm itemForm, UserDetails userDetails) {
		//item.setItem(item, category, subcategory, season, color);
		Item item = new Item();
		String uploadFilePath = photoConverter(itemForm);
		item.setPicture(uploadFilePath);

		//null判定が必要
		Optional<Category> category = categoryRepository.findById(itemForm.getCategoryId());
		Optional<SubCategory> subCategory = subCategoryRepository.findById(itemForm.getSubCategoryId());
		Optional<Season> season = seasonRepository.findById(itemForm.getSeasonId());
		Optional<Color> color = colorRepository.findById(itemForm.getColorId());

		//Optionalと仲良くしてもらう
		item.setCategory(category.get());
		item.setSubCategory(subCategory.get());
		item.setSeason(season.get());
		item.setColor(color.get());
		item.setCreatedAt(new Date());
		item.setComment(itemForm.getMemo());
		User user = userRepository.findByUserId(userDetails.getUsername());
		item.setUser(user);

		//itemRepository.saveAndFlush(itemForm);
		return itemRepository.saveAndFlush(item);
	}

	private String photoConverter(ItemForm itemForm){
		Path path = Paths.get("/static/images/item");
		if (!Files.exists(path)) {
			try {
				Files.createDirectory(path);
			} catch (IOException ex) {
				System.err.println(ex);
			}
		}

		int dot = itemForm.getPicture().getOriginalFilename().lastIndexOf(".");
		String extension = "";
		if (dot > 0) {
			extension = itemForm.getPicture().getOriginalFilename().substring(dot).toLowerCase();
		}
		String filename = DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS").format(LocalDateTime.now());
		Path uploadFilePath = Paths
				.get("/static/images/item/" + filename + extension);

		try (OutputStream os = Files.newOutputStream(uploadFilePath, StandardOpenOption.CREATE)) {
			byte[] bytes = itemForm.getPicture().getBytes();
			os.write(bytes);
		} catch (IOException ex) {
			System.err.println(ex);
		}

		return uploadFilePath.toString();

	}
	
	
}
