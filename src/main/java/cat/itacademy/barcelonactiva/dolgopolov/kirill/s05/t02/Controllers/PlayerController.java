package cat.itacademy.barcelonactiva.dolgopolov.kirill.s05.t02.Controllers;

import cat.itacademy.barcelonactiva.dolgopolov.kirill.s05.t02.DTO.PlayerDTO;
import cat.itacademy.barcelonactiva.dolgopolov.kirill.s05.t02.Model.Game;
import cat.itacademy.barcelonactiva.dolgopolov.kirill.s05.t02.Model.Player;
import cat.itacademy.barcelonactiva.dolgopolov.kirill.s05.t02.Model.PlayerWinPercentage;
import cat.itacademy.barcelonactiva.dolgopolov.kirill.s05.t02.Services.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;


@RestController
@RequestMapping("/players")
public class PlayerController {
    private final PlayerService playerService;

    @Autowired
    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }


    @PostMapping
    public ResponseEntity<PlayerDTO> savePlayer(@RequestBody PlayerDTO playerDTO) {
        if (Objects.equals(playerDTO.getName(), "") || Objects.equals(playerDTO.getName(), null)) {
            PlayerDTO anonimusPlayer = new PlayerDTO();
            anonimusPlayer.setName("ANONIMUS");
            PlayerDTO savedPlayer = playerService.savePlayer(anonimusPlayer);
            return new ResponseEntity<>(savedPlayer, HttpStatus.CREATED);
        }
        Player existingPlayer = playerService.findPlayerByName(playerDTO.getName());
        if (existingPlayer != null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        PlayerDTO savedPlayer = playerService.savePlayer(playerDTO);
        return new ResponseEntity<>(savedPlayer, HttpStatus.CREATED);
    }


    @PutMapping
    public ResponseEntity<Player> updatePlayer(@RequestBody PlayerDTO playerDTO) {
        Player existingPlayer = playerService.changeName(playerDTO);
        if (existingPlayer == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } else return new ResponseEntity<>(existingPlayer, HttpStatus.OK);
    }

    @GetMapping("{id}/games")
    public ResponseEntity<ArrayList<Game>> getAllByPlayer(@PathVariable("id") Long playerId) {
        Optional<Player> playerOptional = playerService.findPlayerById(playerId);
        if (playerOptional.isPresent()) {
            ArrayList<Game> arrayOfPlayers = new ArrayList<>();
            arrayOfPlayers.addAll(playerService.getAllByPlayer(playerOptional.get()));
            return new ResponseEntity<>(arrayOfPlayers, HttpStatus.OK);
        } else return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    @GetMapping
    public ResponseEntity<List<PlayerWinPercentage>> getAllPlayersWithAverageWin() {
        return new ResponseEntity<>(playerService.getPlayerWinPercentage(), HttpStatus.OK);
    }


    @GetMapping("/ranking")
    public ResponseEntity<Double> getAverageRanking() {
        return new ResponseEntity<>(playerService.getAverageWinPercentage(), HttpStatus.OK);
    }


    @GetMapping("/ranking/loser")
    public ResponseEntity<PlayerWinPercentage> getLoser(){
        return new ResponseEntity<>(playerService.theLoser(), HttpStatus.OK);

    } @GetMapping("/ranking/winner")
    public ResponseEntity<PlayerWinPercentage> getWinner(){
        return new ResponseEntity<>(playerService.theWinner(), HttpStatus.OK);
    }
}
