package com.example.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Data
public class CoordinateForm {

    private List<Item> itemList;
    private String title;
    private String memo;
}
