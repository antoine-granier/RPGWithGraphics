package lp.monster;

import lp.Randomizer;

public class SpikeSlimeS extends AbstractOpponent {
    public SpikeSlimeS() {
        super("Spike Slime S", Randomizer.randomInt(10, 16));
        super.addMove(new Move("Tackle", 100, 1, ActionBuilder.stringsToArray("damage"), ActionBuilder.integersToArray("5")));
        super.getNextMove();
    }
}
