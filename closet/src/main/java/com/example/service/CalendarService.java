package com.example.service;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;

import com.example.model.Calendar;
import com.example.model.CalendarForm;

public interface CalendarService {
	public List<Calendar> getAllCalendar(String userid);
	public Calendar getCalendarById(int id);
	public Calendar getCalendarByDate(int userid, Date date);
	public Calendar getCalendarByCoordinateId(int coordinateId);
	
	public void createCalendar(CalendarForm calendarForm, UserDetails userDetails);
	public void editCalendar(CalendarForm calendarForm, UserDetails userDetails, int c_id);
	public void deleteCalendar(CalendarForm calendarForm, UserDetails userDetails, int c_id);
	
	public Integer createCalendar_old(Calendar calendarForm, UserDetails userDetails);
	public Date strToDate(String sDate) throws ParseException;
}
