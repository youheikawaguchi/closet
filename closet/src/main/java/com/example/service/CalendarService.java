package com.example.service;

import java.util.List;

import com.example.model.Calendar;

public interface CalendarService {
	public List<Calendar> getAllCalendar();
	public Calendar getCalendarById(int id);
}
