package cat.itacademy.barcelonactiva.dolgopolov.kirill.s05.t02.Repository;

import cat.itacademy.barcelonactiva.dolgopolov.kirill.s05.t02.Model.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends CrudRepository<Player, Long> {
    Player findByName(String name);


}
