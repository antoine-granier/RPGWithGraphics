package lp.monster.action;

import lp.Log;
import lp.monster.MonsterAction;
import lp.monster.Opponent;
import lp.player.Player;

public class BlockAction implements MonsterAction {
    private final int block;

    public BlockAction(int value) {
        block = value;
    }

    //gives block to the monster
    @Override
    public void doAction(Opponent opponent, Player player) {
        opponent.getStats().addBlock(block);
        Log.getLog().addLog(opponent.getName() + " gains " + block + " stack" + (block > 1 ? "s" : "") + " of block");
    }

    @Override
    public String actionPreview() {
        return "block";
    }
}
