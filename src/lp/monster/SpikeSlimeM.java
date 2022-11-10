package lp.monster;

import lp.Randomizer;

public class SpikeSlimeM extends AbstractOpponent{
    public SpikeSlimeM() {
        super("Spike Slime M", Randomizer.randomInt(28, 33));
        super.addMove(new Move("Lick", 70, 3, ActionBuilder.stringsToArray("weak"), ActionBuilder.integersToArray("1")));
        super.addMove(new Move("Flame Tackle", 30, 3, ActionBuilder.stringsToArray("damage"), ActionBuilder.integersToArray("8")));
        super.getNextMove();
    }

    //constructor to specify hp in case of split
    public SpikeSlimeM(int hp) {
        super("Spike Slime M", hp);
        super.addMove(new Move("Lick", 70, 3, ActionBuilder.stringsToArray("weak"), ActionBuilder.integersToArray("1")));
        super.addMove(new Move("Flame Tackle", 30, 3, ActionBuilder.stringsToArray("damage"), ActionBuilder.integersToArray("8")));
        super.getNextMove();
    }
}
