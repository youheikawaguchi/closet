package com.example.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
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
import com.example.repository.CoordinateRepository;

@Service
public class CalendarServicelmpl implements CalendarService{
	@Autowired
	CalendarRepository calendarRepository;
	@Autowired
    UserRepository userRepository;
    @Autowired
    CoordinateRepository coordinateRepository;
	@Autowired
    UserService userService;

	@Override
	public List<Calendar> getAllCalendar(String userid) {
		int numId = userService.getUserByUserId(userid).getId();
		return calendarRepository.findAll(numId);
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
	public Calendar getCalendarByCoordinateId(int coordinateId) {
		return calendarRepository.findByCoordinateId(coordinateId);
	}
	
	@Override
	public void createCalendar(CalendarForm calendarForm, UserDetails userDetails) {
		
		Calendar calendar = new Calendar();
		
		// User
		// GetUserDetails
		User user = userRepository.findByUserId(userDetails.getUsername());
		calendar.setUser(user);
		
		// Coordinate
		Coordinate coordinate = new Coordinate();
		coordinate.setUser(user);
//		coordinate.setItemlist(calendarForm.getItemList());
		coordinate.setComment(calendarForm.getMemo());
		
		coordinate.setHaveCalender(1);
		coordinate.setItemId(0);
		
		coordinateRepository.saveAndFlush(coordinate);
		calendar.setCoordinate(coordinate);
		
		// Event, Date, P
		calendar.setEvent(calendarForm.getEvent());
		calendar.setEventDate(calendarForm.getEventDate());
		calendar.setMetPerson(calendarForm.getMetPerson());

		calendarRepository.saveAndFlush(calendar);
	}
	
	@Override
	public void editCalendar(CalendarForm calendarForm
			, UserDetails userDetails
			, int c_id) {
		
		Calendar calendar = getCalendarByCoordinateId(c_id);
		
		// Coordinate
		Coordinate coordinate = new Coordinate();
		coordinate.setItemlist(calendarForm.getItemList());
		coordinate.setComment(calendarForm.getMemo());
		calendar.setCoordinate(coordinate);
		
		// Event, Date, P
		calendar.setEvent(calendarForm.getEvent());
		calendar.setEventDate(calendarForm.getEventDate());
		calendar.setMetPerson(calendarForm.getMetPerson());
		
		calendarRepository.saveAndFlush(calendar);
	}
	
	@Override
	public void deleteCalendar(CalendarForm calendarForm
			, UserDetails userDetails
			, int c_id) {
	
		Calendar calendar = getCalendarByCoordinateId(c_id);
		
		calendarRepository.deleteById(calendar.getCalendarId());
	}

	@Override
	public Date strToDate(String sDate) throws ParseException {
		
		SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date dDate = sdFormat.parse(sDate);
		
		return dDate;
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
	
}
