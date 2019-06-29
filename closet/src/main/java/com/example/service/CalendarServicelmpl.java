package com.example.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Calendar;
import com.example.repository.CalendarRepository;

@Service
public class CalendarServicelmpl implements CalendarService{
	@Autowired
	CalendarRepository calendarRepository;
	
	@Override
	public List<Calendar> getAllCalendar() {
		return calendarRepository.findAll();
	}
	
	@Override
	public Calendar getCalendarById(int id) {
		return calendarRepository.findById(id).orElse(null);
	}

	@Override
	public Calendar getCalendarByDate(int userid, Date date) {
		return calendarRepository.findByDate(userid, date);
	}
}
