package cat.itacademy.barcelonactiva.dolgopolov.kirill.s05.t02.DTO;

import cat.itacademy.barcelonactiva.dolgopolov.kirill.s05.t02.Model.Player;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class GameDTO {
    private Integer id;
    private Player player;
    private Byte dice1;
    private Byte dice2;
    private boolean win;
}
