package com.example.service;

import java.util.List;

import com.example.model.Area;

public interface AreaService {
	public List<Area> getAllArea();
	public Area getAreaById(int id);
	public Area getAreaByName(String name);
}
