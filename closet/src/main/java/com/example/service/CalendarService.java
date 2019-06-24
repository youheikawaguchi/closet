package com.example.service;

import java.util.Date;
import java.util.List;

import com.example.model.Calendar;

public interface CalendarService {
	public List<Calendar> getAllCalendar();
	public Calendar getCalendarById(int id);
	public Calendar getCalendarByDate(int userid, Date date);
}
