package com.example.service;

import com.example.model.Coordinate;
import com.example.repository.CoordinateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.Optional;

@Service
@Transactional
public class CoordinateServiceImpl implements CoordinateService {

    @Autowired
    CoordinateRepository coordinateRepository;

    //コーディネート新規登録
    @Override
    public Optional<Coordinate> coordinateSave(Coordinate coordinate){
                                        //ユーザー名を追加する
        coordinate.setCreatedAt(new Date());
        coordinateRepository.saveAndFlush(coordinate);
        return coordinateRepository.findById(coordinate.getCoordinateId());
    }

    @Override
    public Optional<Coordinate> coordinateUpdate(Coordinate coordinate) {

        return Optional.empty();
    }
}
