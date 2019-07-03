package com.example.repository;

import com.example.model.Coordinate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CoordinateRepository extends JpaRepository<Coordinate, Integer> {
    public List<Coordinate> findAll();
    //public Coordinate findById(Integer id);
}
