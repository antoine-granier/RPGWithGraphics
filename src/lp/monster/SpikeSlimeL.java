package lp.monster;

import lp.Randomizer;

public class SpikeSlimeL extends AbstractOpponent{
    private final int splitThreshold;

    public SpikeSlimeL() {
        super("Spike Slime L", Randomizer.randomInt(65, 70));
        splitThreshold = (super.getMaxHP()/2);
        super.addMove(new Move("Lick", 70, 2, ActionBuilder.stringsToArray("weak"), ActionBuilder.integersToArray("2")));
        super.addMove(new Move("Flame Tackle", 30, 2, ActionBuilder.stringsToArray("damage"), ActionBuilder.integersToArray("16")));
        super.getNextMove();
    }

    //constructor to specify hp in case of split
    public SpikeSlimeL(int hp) {
        super("Spike Slime L", hp);
        splitThreshold = (hp/2);
        super.addMove(new Move("Lick", 70, 2, ActionBuilder.stringsToArray("weak"), ActionBuilder.integersToArray("2")));
        super.addMove(new Move("Flame Tackle", 30, 2, ActionBuilder.stringsToArray("damage"), ActionBuilder.integersToArray("16")));
        super.getNextMove();
    }

    //modified takeDamage() method to activate the split action as soon as the slime gets under 50% hp
    @Override
    public boolean takeDamage(int value) {
        if (super.getCurrentHP()-value < splitThreshold) {
            Move split = new Move("Split", 100, 1, ActionBuilder.stringsToArray("split"), ActionBuilder.integersToArray(String.valueOf(super.getCurrentHP()-value)));
            split.executeActions(this, null);
            return super.takeDamage(999);
        }
        return super.takeDamage(value);
    }
}
