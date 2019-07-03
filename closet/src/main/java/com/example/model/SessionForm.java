package com.example.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.context.annotation.ScopedProxyMode;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
@Component
@Scope(value= "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class SessionForm implements Serializable{

	private static final long serialVersionUID = 6334063099671792256L;
	
	public CalendarForm calendarForm;
	public CoordinateForm coordinateForm;
}
