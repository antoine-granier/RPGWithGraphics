package lp.monster;

import lp.player.Player;

public interface MonsterAction {

    void doAction(Opponent opponent, Player player);
    String actionPreview();
}
