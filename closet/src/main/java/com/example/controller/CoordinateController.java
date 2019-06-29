package com.example.controller;

import com.example.model.Coordinate;
import com.example.model.CoordinateForm;
import com.example.service.CoordinateServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
        mav.addObject(new CoordinateForm());
        mav.setViewName("/coordinate/code_add");
        return mav;
    }

    @PostMapping(value = {"/add"})
    public ModelAndView coordinateAdd(ModelAndView mav, CoordinateForm coordinateForm, @AuthenticationPrincipal UserDetails userDetails){
        //登録の処理を書く
        //if(coordinate.getCoordinateId() == null) {
        Integer coordinateId = coordinateServiceImpl.coordinateSave(coordinateForm, userDetails);
        mav.setViewName("/coordinate/only_code_dsc/" + coordinateId);
        return mav;
        //}
    }

    @GetMapping(value = {"/details/{coordinateId}"})
    public ModelAndView coordinateDetails(@PathVariable Integer coordinateId){
        ModelAndView mav = new ModelAndView();
        Coordinate coordinate = coordinateServiceImpl.coordinateGet(coordinateId);
        mav.addObject(coordinate);
        mav.setViewName("/coordinate/only_code_dsc");
        return mav;
    }
}
