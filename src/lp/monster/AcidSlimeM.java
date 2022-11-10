package lp.monster;

import lp.Randomizer;

public class AcidSlimeM extends AbstractOpponent {
    public AcidSlimeM() {
        super("Acid Slime M", Randomizer.randomInt(28, 33));
        super.addMove(new Move("Corrosive Spit", 30, 3, ActionBuilder.stringsToArray("damage"), ActionBuilder.integersToArray("7")));
        super.addMove(new Move("Lick", 30, 2, ActionBuilder.stringsToArray("weak"), ActionBuilder.integersToArray("1")));
        super.addMove(new Move("Tackle", 40, 3, ActionBuilder.stringsToArray("damage"), ActionBuilder.integersToArray("10")));
        super.getNextMove();
    }

    //constructor to specify hp in case of split
    public AcidSlimeM(int hp) {
        super("Acid Slime M", hp);
        super.addMove(new Move("Corrosive Spit", 30, 3, ActionBuilder.stringsToArray("damage"), ActionBuilder.integersToArray("7")));
        super.addMove(new Move("Lick", 30, 2, ActionBuilder.stringsToArray("weak"), ActionBuilder.integersToArray("1")));
        super.addMove(new Move("Tackle", 40, 3, ActionBuilder.stringsToArray("damage"), ActionBuilder.integersToArray("10")));
        super.getNextMove();
    }
}
