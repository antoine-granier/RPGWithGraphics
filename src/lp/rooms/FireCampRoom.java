package lp.rooms;

import lp.player.Player;

import java.io.IOException;

public class FireCampRoom implements Room {
    @Override
    public boolean roomEvent(Player player) throws IOException {
        player.heal(20);
        return true;
    }
}
