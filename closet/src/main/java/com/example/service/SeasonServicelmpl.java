package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Season;
import com.example.model.Season;
import com.example.repository.SeasonRepository;

@Service
public class SeasonServicelmpl implements SeasonService{
	@Autowired
	SeasonRepository seasonRepository;
	
	@Override
	public List<Season> getAllSeason() {
		return seasonRepository.findAll();
	}
	
	@Override
	public Season getSeasonById(int id) {
		return seasonRepository.findById(id).orElse(null);
	}
	
	@Override
	public Season getSeasonByName(String name) {
		return seasonRepository.findBySeasonName(name);
	}
}
