package com.example.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.model.Calendar;

@Repository
public interface CalendarRepository extends JpaRepository<Calendar, Integer>{

	@Query("select x from Calendar x where x.eventDate = :date ")
	public Calendar findByDate(Date date);

}
