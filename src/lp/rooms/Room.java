package lp.rooms;

import lp.player.Player;
import lp.view.GameView;

import java.io.IOException;

public interface Room {
    /**
     *
     * @param index use an index to know the choice player
     * @param player
     * @param view
     * @return
     */
    public boolean roomEvent(Player player, GameView view) throws IOException;
}
