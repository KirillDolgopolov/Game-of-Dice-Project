package cat.itacademy.barcelonactiva.dolgopolov.kirill.s05.t02.Services;

import cat.itacademy.barcelonactiva.dolgopolov.kirill.s05.t02.DTO.GameDTO;
import cat.itacademy.barcelonactiva.dolgopolov.kirill.s05.t02.Model.Game;

public class GameMapper {
    public static GameDTO toDTO(Game game) {
        GameDTO gameDTO = GameDTO.builder().dice1(game.getDice1()).dice2(game.getDice2()).win(game.setResult()).id(game.getGameID()).build();
        return gameDTO;
    }

    public static Game toEntity(GameDTO gameDTO) {
        Game game = Game.builder().dice1(gameDTO.getDice1()).dice2(gameDTO.getDice2()).gameID(gameDTO.getId()).build();
        return game;
    }

}
