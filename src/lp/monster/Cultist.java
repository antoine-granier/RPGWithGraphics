package lp.monster;

import lp.Randomizer;

public class Cultist extends AbstractOpponent {
    public Cultist() {
        super("Cultist", Randomizer.randomInt(48, 55));
        super.firstMove(new Move("Incantation", 100, 1, ActionBuilder.stringsToArray("ritual"), ActionBuilder.integersToArray("3")));
        super.addMove(new Move("Dark Strike", 100, 1, ActionBuilder.stringsToArray("damage"), ActionBuilder.integersToArray("6")));
    }
}
