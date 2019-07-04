package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.model.Area;
import com.example.repository.AreaRepository;

public class AreaServicelmpl implements AreaService {
	@Autowired
	AreaRepository areaRepository;
	public List<Area> getAllArea() {
		return areaRepository.findAll();
	}
	public Area getAreaById(int id) {
		return areaRepository.findById(id).orElse(null);
	}
	public Area getAreaByName(String name) {
		return areaRepository.findByAreaName(name);
	}
}
