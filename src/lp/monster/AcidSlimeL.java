package lp.monster;

import lp.Randomizer;

public class AcidSlimeL extends AbstractOpponent {
    private final int splitThreshold;

    public AcidSlimeL() {
        super("Acid Slime L", Randomizer.randomInt(65, 70));
        splitThreshold = (super.getMaxHP()/2);
        super.addMove(new Move("Corrosive Spit", 30, 3, ActionBuilder.stringsToArray("damage"), ActionBuilder.integersToArray("11")));
        super.addMove(new Move("Lick", 30, 2, ActionBuilder.stringsToArray("weak"), ActionBuilder.integersToArray("2")));
        super.addMove(new Move("Tackle", 40, 2, ActionBuilder.stringsToArray("damage"), ActionBuilder.integersToArray("16")));
        super.getNextMove();
    }

    //constructor to specify hp in case of split
    public AcidSlimeL(int hp) {
        super("Acid Slime L", hp);
        splitThreshold = (hp/2);
        super.addMove(new Move("Corrosive Spit", 30, 3, ActionBuilder.stringsToArray("damage"), ActionBuilder.integersToArray("11")));
        super.addMove(new Move("Lick", 30, 2, ActionBuilder.stringsToArray("weak"), ActionBuilder.integersToArray("2")));
        super.addMove(new Move("Tackle", 40, 2, ActionBuilder.stringsToArray("damage"), ActionBuilder.integersToArray("16")));
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
