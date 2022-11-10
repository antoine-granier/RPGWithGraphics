package lp.weapon;

public class EvilStick extends AbstractWeapon {
    private static int DAMAGE = 20;

    public EvilStick() {
        super(DAMAGE, Rarity.COMMON, 100);
    }

    @Override
    public String asciiArt() {
        return " ,    ,    " +
                "  /( /\\ )\\\n" +
                "  |\\_||_/|\n" +
                "  \\______/\n" +
                "    _\\/_\n" +
                "   ( () )\n" +
                "     {}\n" +
                "     ()\n" +
                "     {}";
    }
}
