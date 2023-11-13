package cat.itacademy.barcelonactiva.dolgopolov.kirill.s05.t02.Services;

import cat.itacademy.barcelonactiva.dolgopolov.kirill.s05.t02.DTO.PlayerDTO;
import cat.itacademy.barcelonactiva.dolgopolov.kirill.s05.t02.GameMechanics.DiceSet;
import cat.itacademy.barcelonactiva.dolgopolov.kirill.s05.t02.Model.Game;
import cat.itacademy.barcelonactiva.dolgopolov.kirill.s05.t02.Model.Player;
import cat.itacademy.barcelonactiva.dolgopolov.kirill.s05.t02.Model.PlayerWinPercentage;
import cat.itacademy.barcelonactiva.dolgopolov.kirill.s05.t02.Repository.GameRepository;
import cat.itacademy.barcelonactiva.dolgopolov.kirill.s05.t02.Repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PlayerService {
    @Autowired
    PlayerRepository playerRepository;
    @Autowired
    GameRepository gameRepository;
    @Autowired
    private GameService gameService;




    public PlayerDTO savePlayer(PlayerDTO playerDTO) {
        Player player = PlayerMapper.toEntity(playerDTO);
        return PlayerMapper.toDTO(playerRepository.save(player));
    }


    public Player changeName(PlayerDTO playerDTO) {
        Player player = PlayerMapper.toEntity(playerDTO);
        Optional<Player> entity = playerRepository.findById(player.getPlayerID());
        if (entity.isPresent() && findPlayerByName(player.getName()) == null) {
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

    public List<Game> getAllByPlayer(Player player) {
        return gameRepository.getAllByPlayer(player);
    }
    public List<PlayerWinPercentage> getPlayerWinPercentage() {
        List<Player> allPlayers = (List<Player>) playerRepository.findAll();

        List<PlayerWinPercentage> result = new ArrayList<>();

        for (Player player : allPlayers) {
            double totalGames = gameService.getTotalGamesForPlayer(player.getPlayerID());
            double totalWins = gameService.getTotalWinsForPlayer(player.getPlayerID());

            double winPercentage = totalGames == 0 ? 0 : (double) totalWins / totalGames * 100;

            result.add(new PlayerWinPercentage(player, winPercentage));
        }

        return result;
    }


}
