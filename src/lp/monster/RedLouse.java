package lp.monster;

import lp.Randomizer;
import lp.player.Player;

public class RedLouse extends AbstractOpponent{
    private final Move curlUp;
    private boolean curlUpUsed;
    public RedLouse() {
        super("Red Louse", Randomizer.randomInt(10, 15));
        super.addMove(new Move("Bite", 75, 3, ActionBuilder.stringsToArray("damage"), ActionBuilder.integersToArray(String.valueOf(Randomizer.randomInt(5, 8)))));
        super.addMove(new Move("Grow", 25, 3, ActionBuilder.stringsToArray("strength"), ActionBuilder.integersToArray("3")));
        curlUp = new Move("Curl up", 100, 1, ActionBuilder.stringsToArray("block"), ActionBuilder.integersToArray(String.valueOf(Randomizer.randomInt(3, 7))));
        curlUpUsed = false;
        super.getNextMove();
    }

    //modified takeDamage() method to give shield to the Louse once a turn after taking damage
    @Override
    public boolean takeDamage(int value) {
        if (!curlUpUsed) {
            curlUp.executeActions(this, null);
            curlUpUsed = true;
        }
        return super.takeDamage(value);
    }

    //prevent curlUp to be used more than once per turn
    @Override
    public void executeMove(Opponent self, Player player) {
        curlUpUsed = false;
        super.executeMove(self, player);
    }
}
