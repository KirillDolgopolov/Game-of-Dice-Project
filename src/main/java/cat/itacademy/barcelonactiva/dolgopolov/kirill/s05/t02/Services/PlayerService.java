package cat.itacademy.barcelonactiva.dolgopolov.kirill.s05.t02.Services;

import cat.itacademy.barcelonactiva.dolgopolov.kirill.s05.t02.DTO.PlayerDTO;
import cat.itacademy.barcelonactiva.dolgopolov.kirill.s05.t02.GameMechanics.DiceSet;
import cat.itacademy.barcelonactiva.dolgopolov.kirill.s05.t02.Model.Game;
import cat.itacademy.barcelonactiva.dolgopolov.kirill.s05.t02.Model.Player;
import cat.itacademy.barcelonactiva.dolgopolov.kirill.s05.t02.Repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Service
public class PlayerService {
    @Autowired
    PlayerRepository playerRepository;


    public PlayerDTO savePlayer(PlayerDTO playerDTO) {
        Player player =PlayerMapper.toEntity(playerDTO);
        return PlayerMapper.toDTO(playerRepository.save(player));
    }


    public Player changeName(PlayerDTO playerDTO) {
        Player player = PlayerMapper.toEntity(playerDTO);
        Optional<Player> entity = playerRepository.findById(player.getPlayerID());
        if (entity.isPresent()&&findPlayerByName(player.getName())==null) {
            Player player1 = entity.get();
            player1.setName(player.getName());
            playerRepository.save(player1);
            return player1;
        } else {
            System.out.println("Something wrong");
            return null;
        }
    }

    public Player findPlayerByName(String name) {
        return playerRepository.findByName(name);
    }


    public Optional<Player> findPlayerById(Long playerId) {
        return playerRepository.findById(playerId);
    }


}
