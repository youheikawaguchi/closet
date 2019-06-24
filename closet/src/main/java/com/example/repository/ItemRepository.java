package com.example.repository;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.LockModeType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.controller.TopController;
import com.example.model.Item;

public interface ItemRepository extends JpaRepository<Item, Integer>{

	
    //@Query(value = "SELECT ")
	//public List<Item> findSlideImg(int season_id);
    @Query(value = "SELECT * FROM items WHERE season_id = :seasonId")
    //あとuserID
    @Lock(LockModeType.PESSIMISTIC_WRITE)
    List<Item> findBySlideImg(@Param("season_Id") int seasonId);
}

//IN句