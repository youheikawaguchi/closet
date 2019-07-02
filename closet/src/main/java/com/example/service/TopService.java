package com.example.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Area;
import com.example.model.Item;
import com.example.repository.AreaRepository;
import com.example.repository.ItemRepository;


@Service
public class TopService {
	@Autowired
	ItemRepository itemRepository;
	@Autowired
	AreaRepository areaRepository;

	//getSeasonメソッドの季節IDをfindSlideImgに渡す
	public List<Item> getSlideItems() {
		int[] getSeason = getSeason();
		List<Item> items = itemRepository.findSlideImg(getSeason[0], getSeason[1]);
		return items;
	}
	//area取得
	int area = 13; //とりあえず東京
	public List<Area> getArea() {
		return areaRepository.findArea(area);
	}
	
	/*　まいまいくそー　*/
	
	//今日の月から季節IDの判定
	public int[] getSeason() {
		LocalDate date = LocalDate.now();
		int month = date.getMonthValue();
		int seasonId[] = new int[2];
		
		if(month >= 3 && month <= 5) {
			seasonId[0] = 1;
		}else if(month >= 6 && month <= 8) {
			seasonId[0] = 2;
		}else if(month >= 9 && month <= 10) {
			seasonId[0] = 3;
		}else if(month >= 11 && month <= 12 || month <= 2 ) {
			seasonId[0] = 4;
		}
		
		if(month >=5 && month <= 8) {
			seasonId[1] = 5;
		}else if(month >= 9 && month <= 12 || month <= 4) {
			seasonId[1] = 6;
		}
	
		return seasonId;
		
	}
	

}