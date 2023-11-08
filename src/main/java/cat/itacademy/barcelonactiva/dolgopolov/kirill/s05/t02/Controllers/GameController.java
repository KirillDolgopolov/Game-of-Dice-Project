package cat.itacademy.barcelonactiva.dolgopolov.kirill.s05.t02.Controllers;

import cat.itacademy.barcelonactiva.dolgopolov.kirill.s05.t02.GameMechanics.DiceSet;
import cat.itacademy.barcelonactiva.dolgopolov.kirill.s05.t02.Model.Game;
import cat.itacademy.barcelonactiva.dolgopolov.kirill.s05.t02.Model.Player;
import cat.itacademy.barcelonactiva.dolgopolov.kirill.s05.t02.Services.GameService;
import cat.itacademy.barcelonactiva.dolgopolov.kirill.s05.t02.Services.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/players")
public class GameController {
    @Autowired
    GameService gameService;
    @Autowired
    PlayerService playerService;

    @PostMapping("/{playerId}/games")
    public ResponseEntity<Game> createGameForPlayer(@PathVariable Long playerId) {
        Optional<Player> playerOptional = playerService.findPlayerById(playerId);

        Player player;
        if (playerOptional.isPresent()) {
            player = playerOptional.get();
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        Game game = new Game();
        game.setPlayer(player);
       game.setDice1(DiceSet.playDice());
       game.setDice2(DiceSet.playDice());



        gameService.saveGame(game);

        return new ResponseEntity<>(game, HttpStatus.CREATED);
    }




}
