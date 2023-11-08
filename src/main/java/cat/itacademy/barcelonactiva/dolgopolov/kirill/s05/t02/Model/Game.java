package cat.itacademy.barcelonactiva.dolgopolov.kirill.s05.t02.Model;

import cat.itacademy.barcelonactiva.dolgopolov.kirill.s05.t02.GameMechanics.DiceSet;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer gameID;

    @ManyToOne
    @JoinColumn(name = "playerID")
    private Player player;

    @Column
    private Byte dice1;
    private Byte dice2;

    @Column
    public boolean win() {
        return dice1 + dice2 == 7;
    }


}
