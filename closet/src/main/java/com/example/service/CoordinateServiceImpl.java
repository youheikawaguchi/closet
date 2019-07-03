package com.example.service;

import com.example.model.*;
import com.example.repository.CoordinateRepository;
import com.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
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
        User user = userRepository.findByUserId(userDetails.getUsername());
        coordinate.setCreatedAt(new Date());
        coordinate.setUser(user);
        return coordinateSet(coordinate, coordinateForm);
    }

    @Override
    public int coordinateUpdate(int id, CoordinateForm coordinateForm, UserDetails userDetails){
        Coordinate coordinate = new Coordinate();
        coordinate.setCoordinateId(id);
        coordinate.setUpdatedAt(new Date());
        User user = userRepository.findByUserId(userDetails.getUsername());
        coordinate.setUser(user);
        return coordinateSet(coordinate, coordinateForm);
    }

    @Override
    public CoordinateForm coordinateUpdateForm(Integer id) {

        Coordinate coordinate = coordinateRepository.findById(id).get();
        CoordinateForm coordinateForm = new CoordinateForm();
        coordinateForm.setItemList(coordinate.getItemlist());
        coordinateForm.setTitle(coordinate.getCoordinate_title());
        coordinateForm.setMemo(coordinate.getComment());
        return coordinateForm;
    }

    @Override
    public Coordinate coordinateDetails(Integer coordinateId) {
        Optional<Coordinate> coordinate = coordinateRepository.findById(coordinateId);

        return coordinate.get();
    }


	@Override
	public List<Coordinate> userCoordinateList(UserDetails userDetails) {
		User user = userRepository.findByUserId(userDetails.getUsername());
		return coordinateRepository.findByUserId(user.getId());
	}

    private int coordinateSet(Coordinate coordinate, CoordinateForm coordinateForm){
        coordinate.setItemlist(coordinateForm.getItemList());
        coordinate.setCoordinate_title(coordinateForm.getTitle());
        coordinate.setComment(coordinateForm.getMemo());
        coordinate.setHaveCalender(0);
        coordinate = coordinateRepository.saveAndFlush(coordinate);
        return coordinate.getCoordinateId();
    }
}
