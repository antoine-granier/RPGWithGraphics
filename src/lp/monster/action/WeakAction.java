package lp.monster.action;

import lp.Log;
import lp.monster.MonsterAction;
import lp.monster.Opponent;
import lp.player.Player;

public class WeakAction implements MonsterAction {
    private final int weak;

    public WeakAction(int value) {
        weak = value;
    }

    //apply weak to the player
    @Override
    public void doAction(Opponent opponent, Player player) {
        opponent.getStats().addWeak(weak);
        Log.getLog().addLog(opponent.getName() + " applies " + weak + " stack" + (weak > 1 ? "s" : "") + " of weak to you");
    }

    @Override
    public String actionPreview() {
        return "weak";
    }
}
