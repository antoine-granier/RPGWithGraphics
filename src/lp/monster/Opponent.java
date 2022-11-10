package lp.monster;

import lp.player.Player;
import lp.stats.Stats;

import java.io.IOException;
import java.util.ArrayList;

public interface Opponent {
    boolean takeDamage(int value);
    void executeMove(Opponent self, Player player) throws IOException;
    int getCurrentHP();
    int getMaxHP();
    Stats getStats();
    String getName();
    boolean isDead();
    ArrayList<Move> getMoves();
    Move nextMove();
}
