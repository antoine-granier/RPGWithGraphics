package lp.rooms;

import lp.Log;
import lp.player.Player;
import lp.view.GameView;

import java.io.IOException;

public class TrapRoom implements Room{
    @Override
    public boolean roomEvent(Player player, GameView view) throws IOException {
        player.takeDamage(20);
        Log.getLog().addLog("You take 20 damage from trap");
        return true;
    }
}
