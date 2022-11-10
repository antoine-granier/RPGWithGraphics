package lp.monster.action;

import lp.monster.MonsterAction;
import lp.monster.Opponent;
import lp.player.Player;

public class RitualAction implements MonsterAction {
    private final int ritual;

    public RitualAction(int value) {
        ritual = value;
    }

    //gives ritual to the monster
    @Override
    public void doAction(Opponent opponent, Player player) {
        opponent.getStats().addRitual(ritual);
        System.out.println(opponent.getName() + " gains " + ritual + " stack" + (ritual > 1 ? "s" : "") + " of ritual");
    }

    @Override
    public String actionPreview() {
        return "ritual";
    }
}
