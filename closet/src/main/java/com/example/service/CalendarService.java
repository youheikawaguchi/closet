package com.example.service;

import java.util.Date;
import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;

import com.example.model.Calendar;
import com.example.model.CalendarForm;

public interface CalendarService {
	public List<Calendar> getAllCalendar();
	public Calendar getCalendarById(int id);
	public Calendar getCalendarByDate(int userid, Date date);
	public Integer createCalendar_old(Calendar calendarForm, UserDetails userDetails);
	public Calendar createCalendar(CalendarForm calendarForm, UserDetails userDetails);
}
