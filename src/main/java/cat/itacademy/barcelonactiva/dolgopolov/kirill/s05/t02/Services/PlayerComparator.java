package cat.itacademy.barcelonactiva.dolgopolov.kirill.s05.t02.Services;

import cat.itacademy.barcelonactiva.dolgopolov.kirill.s05.t02.Model.PlayerWinPercentage;

import java.util.Comparator;

public class PlayerComparator implements Comparator<PlayerWinPercentage> {
    @Override
    public int compare(PlayerWinPercentage pl1, PlayerWinPercentage pl2) {
        return Double.compare(pl1.getWinPercentage(), pl2.getWinPercentage());
    }
}

