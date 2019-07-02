package com.example.service;

import com.example.model.Coordinate;
import com.example.model.CoordinateForm;
import com.example.model.User;
import com.example.repository.CoordinateRepository;
import com.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.Optional;

@Service
@Transactional
public class CoordinateServiceImpl implements CoordinateService {

    @Autowired
    CoordinateRepository coordinateRepository;
    @Autowired
    UserRepository userRepository;

    //コーディネート新規登録
    @Override
    public Integer coordinateSave(CoordinateForm coordinateForm, UserDetails userDetails){
        Coordinate coordinate = new Coordinate();
        coordinate.setItemlist(coordinateForm.getItemList());
        coordinate.setCoordinate_title(coordinateForm.getTitle());
        coordinate.setComment(coordinateForm.getMemo());
        coordinate.setCreatedAt(new Date());
        User user = userRepository.findByUserId(userDetails.getUsername());
        coordinate.setUser(user);
        coordinate.setHaveCalender(0);
        coordinate = coordinateRepository.saveAndFlush(coordinate);
        return coordinate.getCoordinateId();
    }

    @Override
    public Optional<Coordinate> coordinateUpdate(Coordinate coordinate) {

        return Optional.empty();
    }

    @Override
    public Coordinate coordinateGet(Integer coordinateId) {
        Optional<Coordinate> coordinate = coordinateRepository.findById(coordinateId);

        return coordinate.get();
    }




}
