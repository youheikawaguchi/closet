package com.example.service;

import com.example.model.Coordinate;

import java.util.Optional;

public interface CoordinateService {

    public Optional<Coordinate> coordinateSave(Coordinate coordinate);

    public Optional<Coordinate> coordinateUpdate(Coordinate coordinate);
}
