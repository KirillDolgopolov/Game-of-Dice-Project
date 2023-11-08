package cat.itacademy.barcelonactiva.dolgopolov.kirill.s05.t02.Services;

import cat.itacademy.barcelonactiva.dolgopolov.kirill.s05.t02.Controllers.GameController;
import cat.itacademy.barcelonactiva.dolgopolov.kirill.s05.t02.Model.Game;
import cat.itacademy.barcelonactiva.dolgopolov.kirill.s05.t02.Repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameService {

    @Autowired
    GameRepository gameRepository;

    public Game saveGame(Game game) {
        return gameRepository.save(game);
    }

}
