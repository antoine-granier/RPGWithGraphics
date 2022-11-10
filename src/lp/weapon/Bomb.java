package lp.weapon;

public class Bomb extends AbstractWeapon {
    public static int DAMAGE = 35;

    public Bomb() {
        super(DAMAGE, Rarity.EPIQUE, 250);
    }

    @Override
    public String asciiArt() {
        return "        ,--.!,\n" +
                "     __/   -*-\n" +
                "   ,d08b.  '|`\n" +
                "   0088MM     \n" +
                "   `9MMP'     ";
    }
}
