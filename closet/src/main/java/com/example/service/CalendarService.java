package com.example.service;

import java.util.List;

import com.example.model.Calender;

public interface CalendarService {
	public List<Calender> getAllCalendar();
	public Calender getCalendarById(int id);
}
