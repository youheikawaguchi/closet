package com.example.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

@Getter
@Setter
@Data
public class CalendarForm {

    private List<Item> itemList;
    private String memo;
    private String event;
    
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date eventDate;
    private String metPerson;
}
