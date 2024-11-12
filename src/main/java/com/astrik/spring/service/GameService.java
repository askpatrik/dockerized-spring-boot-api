package com.astrik.spring.service;
import com.astrik.spring.model.Game;
import com.astrik.spring.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class GameService {

        @Autowired
        private GameRepository gameRepository;


        public Game saveGame(Game game) {
            return gameRepository.save(game);
        }
        public Game getGame(long gameId) {
            return gameRepository.findById(gameId).orElseThrow(() -> new RuntimeException("Not Found"));
        }

        public List<Game> getAllGames() {
            return gameRepository.findAll();
        }
        public Game updateGame(long gameId, Game game) {
            Game existingGame = gameRepository.findById(gameId).orElseThrow(() -> new RuntimeException("Not Found"));
            existingGame.setGameName(game.getGameName());
            existingGame.setPrice(game.getPrice());
            gameRepository.save(existingGame);
            return existingGame;
        }

        public Game deleteGame(long gameId) {
            Game gameToDelete = gameRepository.findById(gameId).orElseThrow(() -> new RuntimeException("Not Found"));
            gameRepository.delete(gameToDelete);
            return gameToDelete;
        }
    }
