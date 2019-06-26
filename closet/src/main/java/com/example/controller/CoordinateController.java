package com.example.controller;

import com.example.model.Coordinate;
import com.example.service.CoordinateServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequestMapping("/coordinate")
public class CoordinateController {

    @Autowired
    CoordinateServiceImpl coordinateServiceImpl;

    @GetMapping(value = {"/add"})
    public ModelAndView showCoordinateAdd(){
        ModelAndView mav = new ModelAndView();
        mav.setViewName("/coordinate/code_add");
        return mav;
    }

    @RequestMapping(value = {"/add"})
    public ModelAndView coordinateAdd(ModelAndView mav, Coordinate coordinate){
        //登録の処理を書く
        //if(coordinate.getCoordinateId() == null) {
            Optional<Coordinate> coordinateAdd = coordinateServiceImpl.coordinateSave(coordinate);
            mav.addObject(coordinate);
            mav.setViewName("/coordinate/only_code_dsc");
            return mav;
        //}
    }
}
