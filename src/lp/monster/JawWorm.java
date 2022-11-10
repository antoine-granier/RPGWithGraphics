package lp.monster;

import lp.Randomizer;

public class JawWorm extends AbstractOpponent{
    public JawWorm() {
        super("Jaw Worm", Randomizer.randomInt(40, 44));
        Move chomp = new Move("Chomp", 25, 1, ActionBuilder.stringsToArray("damage"), ActionBuilder.integersToArray("11"));
        super.firstMove(chomp);
        super.addMove(chomp);
        super.addMove(new Move("Bellow", 45, 1, ActionBuilder.stringsToArray("strength#block"), ActionBuilder.integersToArray("3#6")));
        super.addMove(new Move("Thrash", 30, 2, ActionBuilder.stringsToArray("damage#block"), ActionBuilder.integersToArray("7#5")));
    }
}
