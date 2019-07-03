package com.example.service;

import com.example.model.*;
import com.example.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

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
	ResourceLoader resourceLoader;

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

		//null判定が必要
		Optional<Category> category = categoryRepository.findById(itemForm.getCategoryId());
		Optional<SubCategory> subCategory = subCategoryRepository.findById(itemForm.getSubCategoryId());
		Optional<Season> season = seasonRepository.findById(itemForm.getSeasonId());
		Optional<Color> color = colorRepository.findById(itemForm.getColorId());
		User user = userRepository.findByUserId(userDetails.getUsername());

		item.setCategory(category.get());
		item.setSubCategory(subCategory.get());
		item.setSeason(season.get());
		item.setColor(color.get());
		item.setCreatedAt(new Date());
		item.setComment(itemForm.getMemo());
		item.setUser(user);
		String uploadFilePath = imageSave(itemForm, item.getUser().getUserId());
		item.setPicture(uploadFilePath);

		return itemRepository.saveAndFlush(item);
	}
	/*
	@Override
    public int itemUpdate(int id, ItemForm itemForm, UserDetails userDetails){
        Item item = new Item();
        item.setItemId(id);
        item.setUpdatedAt(new Date());
        User user = userRepository.findByUserId(userDetails.getUsername());
        item.setUser(user);
        return itemSet(item, itemForm);
    }
    */

	@Override
	public List<Item> userItemList(UserDetails userDetails){
		User user = userRepository.findByUserId(userDetails.getUsername());
		return itemRepository.findUserItem(user.getId());
	}

	private String imageSave(ItemForm itemForm, String userId){

		String extension = "";
		String imageName = itemForm.getPicture().getOriginalFilename();

		if(itemForm.getPicture().isEmpty()){
			// 異常終了時の処理
			System.out.println("画像の取得ができなかったよ");
		}

		//パスの指定								
		//Resource resource = resourceLoader.getResource( "static/images/item");
		Resource resource = resourceLoader.getResource( "//file/Users/s.yamamoto/Documents/closet");
		String path = resource.toString();

		try {
			// /static/images/item/userId の状態になる  fileクラスpathクラスたぶんfile
			//File uploadDir = new File(Objects.requireNonNull(resource.getFile()) + File.separator + userId);
			File uploadDir = new File(path);

			// アップロードファイルを格納するディレクトリがなければ作成する
			if(!uploadDir.exists())	uploadDir.mkdirs();

			assert imageName != null;
			int dot = imageName.lastIndexOf(".");

			if (dot > 0) extension = imageName.substring(dot).toLowerCase();

			String filename = DateTimeFormatter.ofPattern("yyyyMMddHHmmssSSS").format(LocalDateTime.now());

			// アップロードファイルを置く
			File uploadFile =
					new File(uploadDir.getPath() + "/" + filename + extension);
			byte[] bytes = itemForm.getPicture().getBytes();
			BufferedOutputStream uploadFileStream =
					new BufferedOutputStream(new FileOutputStream(uploadFile));
			uploadFileStream.write(bytes);
			uploadFileStream.close();

			return uploadFile.getPath();
		} catch (Throwable e) {
			// 異常終了時の処理
			System.out.println("画像置くのに失敗したよ");
			System.out.println(e);
		}
		return null;
	}
}
