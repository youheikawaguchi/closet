package com.example.service;

import com.example.model.Coordinate;
import com.example.model.CoordinateForm;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;
import java.util.Optional;

public interface CoordinateService {

	public List<Coordinate> getCoordinateList(UserDetails userDetails);
    //public List<Coordinate> userCoordinateListGet(UserDetails userDetails);
	
    public Integer coordinateSave(CoordinateForm coordinateForm, UserDetails userDetails);

    public Optional<Coordinate> coordinateUpdate(Coordinate coordinate);

    public Coordinate coordinateGet(Integer coordinateId);
    
}
