package com.example.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.example.model.Calendar;
import com.example.model.CalendarForm;
import com.example.model.Coordinate;
import com.example.model.User;
import com.example.repository.CalendarRepository;
import com.example.repository.UserRepository;

@Service
public class CalendarServicelmpl implements CalendarService{
	@Autowired
	CalendarRepository calendarRepository;
    @Autowired
    UserRepository userRepository;
	
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
	
	@Override
	public Integer createCalendar_old(Calendar calendarForm, UserDetails userDetails) {
		Calendar calendar = new Calendar();
		
		// User
		// GetUserDetails
		User user = userRepository.findByUserId(userDetails.getUsername());
		calendar.setUser(user);
		
		// Coordinate
		Coordinate coordinate = new Coordinate();
		coordinate.setItemlist(calendarForm.getCoordinate().getItemlist());
		coordinate.setComment(calendarForm.getCoordinate().getComment());
		calendar.setCoordinate(coordinate);
		
		// Event, Date, P
		calendar.setEvent(calendarForm.getEvent());
		calendar.setEventDate(calendarForm.getEventDate());
		calendar.setMetPerson(calendarForm.getMetPerson());
		
		calendar = calendarRepository.saveAndFlush(calendar);
		
		return calendar.getCalendarId();
	}
	
	@Override
	public Calendar createCalendar(CalendarForm calendarForm, UserDetails userDetails) {
		Calendar calendar = new Calendar();
		
		// User
		// GetUserDetails
		User user = userRepository.findByUserId(userDetails.getUsername());
		calendar.setUser(user);
		
		// Coordinate
		Coordinate coordinate = new Coordinate();
		coordinate.setItemlist(calendarForm.getItemList());
		coordinate.setComment(calendarForm.getMemo());
		calendar.setCoordinate(coordinate);
		
		// Event, Date, P
		calendar.setEvent(calendarForm.getEvent());
		calendar.setEventDate(calendarForm.getEventDate());
		calendar.setMetPerson(calendarForm.getMetPerson());

		return calendar = calendarRepository.saveAndFlush(calendar);
	}

}
