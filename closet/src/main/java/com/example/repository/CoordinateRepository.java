package com.example.repository;

import com.example.model.Coordinate;
import com.example.model.Item;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

@Repository
public interface CoordinateRepository extends JpaRepository<Coordinate, Integer> {
	public List<Coordinate> findAll();
	public List<Coordinate> findByUserId(int userId);
	//@Query(value = "SELECT * FROM coordinate  WHERE id = :userId", nativeQuery = true)
    //public List<Coordinate> findUserCoordinate(@Param("userId") int userId);
	
}
