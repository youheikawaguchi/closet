package com.example.service;

import com.example.model.Coordinate;
import com.example.model.CoordinateForm;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

public interface CoordinateService {

    public Integer coordinateSave(CoordinateForm coordinateForm, UserDetails userDetails);

    public CoordinateForm coordinateUpdate(Integer id);

    public Coordinate coordinateDetails(Integer coordinateId);
}
