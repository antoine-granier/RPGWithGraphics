package lp.rooms;

import lp.player.Player;

import java.io.IOException;

public interface Room {
    /**
     *
     * @param index use an index to know the choice player
     * @param player
     * @return
     */
    public boolean roomEvent(Player player) throws IOException;
}
