package com.astrik.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.astrik.spring.model.Game;

import java.util.List;


    public interface GameRepository extends JpaRepository<Game, Long> {
        @Query(value = "SELECT * FROM game_inventory WHERE game_name = ?1", nativeQuery = true)
        List<Game> getProductsByName(String productName);

}