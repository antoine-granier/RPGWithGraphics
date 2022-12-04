package lp.monster.action;

import lp.Log;
import lp.monster.MonsterAction;
import lp.monster.Opponent;
import lp.player.Player;

public class StrengthAction implements MonsterAction {

    private final int strength;

    public StrengthAction(int value) {
        strength = value;
    }

    //gives strength to the monster
    @Override
    public void doAction(Opponent opponent, Player player) {
        opponent.getStats().addStrength(strength);
        Log.getLog().addLog(opponent.getName() + " gains " + strength + " stack" + (strength > 1 ? "s" : "") + " of strength");
    }

    @Override
    public String actionPreview() {
        return "strength";
    }
}
