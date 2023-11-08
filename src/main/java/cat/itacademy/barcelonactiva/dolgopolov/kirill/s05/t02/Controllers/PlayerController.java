package cat.itacademy.barcelonactiva.dolgopolov.kirill.s05.t02.Controllers;

import cat.itacademy.barcelonactiva.dolgopolov.kirill.s05.t02.DTO.PlayerDTO;
import cat.itacademy.barcelonactiva.dolgopolov.kirill.s05.t02.Model.Player;
import cat.itacademy.barcelonactiva.dolgopolov.kirill.s05.t02.Services.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


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
        if(Objects.equals(playerDTO.getName(), "")){
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
    public Player updatePlayer(@RequestBody Player player) {
        return playerService.changeName(player);
    }

}