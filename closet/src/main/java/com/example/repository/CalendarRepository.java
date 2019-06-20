package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.Calender;

@Repository
public interface CalendarRepository extends JpaRepository<Calender, Integer>{

}
