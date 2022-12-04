package lp.rooms;

import lp.Log;
import lp.player.Player;
import lp.view.GameView;

import java.io.IOException;

public class FireCampRoom implements Room {
    @Override
    public boolean roomEvent(Player player, GameView view) throws IOException {
        player.heal(20);
        Log.getLog().addLog("You have healed of 20 health point");
        return true;
    }
}
