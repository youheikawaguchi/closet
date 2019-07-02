package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.model.Item;

public interface ItemRepository extends JpaRepository<Item, Integer>{
	
	//TopServiceのfindSlideImgから受け取った値をバインドし、クエリーにいれる
	//
    @Query(value = "SELECT * FROM items WHERE season_id = :fourSeasons OR season_Id = :twoSeasons ORDER BY RAND() LIMIT 10", nativeQuery = true)
    public List<Item> findSlideImg(@Param("fourSeasons") int fourSeasonId, @Param("twoSeasons") int twoSeasonId);
    //あとuserID

    @Query(value = "SELECT * FROM items  WHERE id = :userId", nativeQuery = true)
    public List<Item> findUserItem(@Param("userId") int userId);

}
