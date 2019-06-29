package com.example.service;

import java.util.List;

import com.example.model.Season;

public interface SeasonService {

	public List<Season> getAllSeason();
	public Season getSeasonById(int id);
	public Season getSeasonByName(String name);
}
