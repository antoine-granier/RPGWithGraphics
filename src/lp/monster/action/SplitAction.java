package lp.monster.action;

import lp.monster.*;
import lp.player.Player;
import lp.rooms.FightRoom;
import lp.rooms.Map;

public class SplitAction implements MonsterAction{
    private final int slimeLife;

    public SplitAction(int value) {
        slimeLife = value;
    }

    //add two new slimes when the "parents" uses split
    @Override
    public void doAction(Opponent opponent, Player player) {
        String slime = opponent.getName();
        if (slime.equals("Acid Slime L")) {
            ((FightRoom) Map.getCurrentRoom()).addOpponent(new AcidSlimeM(slimeLife));
            ((FightRoom) Map.getCurrentRoom()).addOpponent(new AcidSlimeM(slimeLife));
        } else if (slime.equals("Spike Slime L")) {
            ((FightRoom) Map.getCurrentRoom()).addOpponent(new SpikeSlimeM(slimeLife));
            ((FightRoom) Map.getCurrentRoom()).addOpponent(new SpikeSlimeM(slimeLife));
        }
        System.out.println(opponent.getName() + " splits!");
    }

    @Override
    public String actionPreview() {
        return "split";
    }
}
