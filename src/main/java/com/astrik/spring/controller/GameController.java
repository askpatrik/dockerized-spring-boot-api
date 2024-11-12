package com.astrik.spring.controller;

import com.astrik.spring.model.Game;
import com.astrik.spring.service.GameService;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GameController {

    @Autowired
    private GameService gameService;

    // insert a game into database
    @PostMapping("/game")
    public ResponseEntity<Game> saveGame(@RequestBody Game game) {
        Game savedProduct = gameService.saveGame(game);
        return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
    }

    // get a game by its id
    @GetMapping("/game")
    public ResponseEntity<Game> getGame(@RequestParam(name = "gameId") long gameId) {
        Game game = gameService.getGame(gameId);
        return new ResponseEntity<>(game, HttpStatus.OK);
        }

    // get all games
    @GetMapping("/games")
    public List<Game> getAllGames() {
        return gameService.getAllGames();
    }

    // update an existing game in the database
    @PatchMapping("/game")
    public ResponseEntity<Game> patchGame(@RequestParam(name = "gameId") long gameId, @RequestBody Game game) {
        Game updatedGame = gameService.updateGame(gameId, game);
        return new ResponseEntity<>(updatedGame, HttpStatus.OK);
    }

    // delete a game from the database
    @DeleteMapping("/game")
    public ResponseEntity<Game> deleteGame(@RequestParam(name = "gameId") long gameId) {
        Game deletedGame = gameService.deleteGame(gameId);
        return new ResponseEntity<>(deletedGame, HttpStatus.OK);
    }
}
