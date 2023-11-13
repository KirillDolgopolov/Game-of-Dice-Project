package cat.itacademy.barcelonactiva.dolgopolov.kirill.s05.t02.Repository;

import cat.itacademy.barcelonactiva.dolgopolov.kirill.s05.t02.Model.Game;
import cat.itacademy.barcelonactiva.dolgopolov.kirill.s05.t02.Model.Player;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface GameRepository extends JpaRepository<Game, Long> {
    @Transactional
    void deleteAllByPlayer(Player player);

    List<Game> getAllByPlayer(Player player);

    double countByPlayerId(Long playerId);

    double countByPlayerIdAndWinIsTrue(Long playerId);
}
