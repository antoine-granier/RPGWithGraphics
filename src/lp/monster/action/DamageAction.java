package lp.monster.action;

import lp.monster.MonsterAction;
import lp.monster.Opponent;
import lp.player.Player;

public class DamageAction implements MonsterAction {
    private final int damage;

    public DamageAction(int value) {
        damage = value;
    }

    @Override
    public void doAction(Opponent opponent, Player player) {
        int modifiedDamage = damage;
        modifiedDamage = opponent.getStats().applyAttackerModifiers(modifiedDamage);
        modifiedDamage = player.getStats().applyDefenderModifiers(modifiedDamage);
        player.takeDamage(modifiedDamage);
        System.out.println("You take " + modifiedDamage + " damage from " + opponent.getName());
    }

    @Override
    public String actionPreview() {
        return "damage";
    }
}
