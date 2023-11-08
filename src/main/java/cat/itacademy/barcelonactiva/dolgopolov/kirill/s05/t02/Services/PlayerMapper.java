package cat.itacademy.barcelonactiva.dolgopolov.kirill.s05.t02.Services;

import cat.itacademy.barcelonactiva.dolgopolov.kirill.s05.t02.DTO.PlayerDTO;
import cat.itacademy.barcelonactiva.dolgopolov.kirill.s05.t02.Model.Player;
import lombok.Builder;

public class PlayerMapper {
    public static Player toEntity(PlayerDTO playerDTO) {
        Player player = Player.builder().playerID(playerDTO.getPlayerID()).name(playerDTO.getName()).creationTime(playerDTO.getCreationTime()).build();
        return player;
    }

    public static PlayerDTO toDTO(Player player) {
        PlayerDTO playerDTO = PlayerDTO.builder().playerID(player.getPlayerID()).name(player.getName()).creationTime(player.getCreationTime()).build();
        return playerDTO;
    }
}
