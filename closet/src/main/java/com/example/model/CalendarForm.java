package com.example.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Data
public class CalendarForm {

    private List<Item> itemList;
    private String event;
    private Date eventDate;
    private String metPerson;
    private String memo;
}
