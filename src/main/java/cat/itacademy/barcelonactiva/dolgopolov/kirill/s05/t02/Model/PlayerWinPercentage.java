package cat.itacademy.barcelonactiva.dolgopolov.kirill.s05.t02.Model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PlayerWinPercentage {
    private Player player;
    private double winPercentage;
}
