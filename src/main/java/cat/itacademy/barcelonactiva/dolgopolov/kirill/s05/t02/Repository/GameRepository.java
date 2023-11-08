package cat.itacademy.barcelonactiva.dolgopolov.kirill.s05.t02.Repository;

import cat.itacademy.barcelonactiva.dolgopolov.kirill.s05.t02.Model.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long> {
}
