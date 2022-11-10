package lp.rooms;

import lp.Randomizer;
import lp.monster.*;
import lp.player.Player;
import lp.weapon.Weapon;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class FightRoom implements Room {
    private TreeMap<Integer, Opponent> opponents;
    private int numberOfOpponents;
    private Player player;
    private boolean chooseWeapon;

    public FightRoom(Player player) {
        this.opponents = new TreeMap<Integer, Opponent>();
        numberOfOpponents = 0;
        this.player = player;
        this.chooseWeapon = false;
        int number = Randomizer.randomInt(0, 6);
        switch (number) {
            case 0:
                addOpponent(new Cultist());
                break;
            case 1:
                addOpponent(new JawWorm());
                break;
            case 2:
                int whichLouse = Randomizer.randomInt(0, 2);
                if (whichLouse == 0) {
                    addOpponent(new RedLouse());
                } else {
                    addOpponent(new GreenLouse());
                }
                whichLouse = Randomizer.randomInt(0, 2);
                if (whichLouse == 0) {
                    addOpponent(new RedLouse());
                } else {
                    addOpponent(new GreenLouse());
                }
                break;
            case 3:
                int whichSlime = Randomizer.randomInt(0, 2);
                if (whichSlime == 0) {
                    addOpponent(new AcidSlimeM());
                } else {
                    addOpponent(new SpikeSlimeM());
                }
                whichSlime = Randomizer.randomInt(0, 2);
                if (whichSlime == 0) {
                    addOpponent(new AcidSlimeS());
                } else {
                    addOpponent(new SpikeSlimeS());
                }
                break;
            case 4:
                addOpponent(new AcidSlimeL());
                break;
            case 5:
                addOpponent(new SpikeSlimeL());
                break;
            default:
                throw new IllegalArgumentException("Could not add monsters to the FightRoom");
        }
    }

    public void addOpponent(Opponent opponent) {
        numberOfOpponents++;
        opponents.put(numberOfOpponents, opponent);
    }

    public TreeMap<Integer, Opponent> getOpponents() {
        return opponents;
    }

    public Player getPlayer() {
        return player;
    }

    //update stats each turn
    private void statsUpdate() {
        player.getStats().turnUpdate();
        for(Map.Entry<Integer, Opponent> entry : opponents.entrySet()) {
            entry.getValue().getStats().turnUpdate();
        }
    }

    public boolean roomEvent(Player player) throws IOException {
        if(!chooseWeapon) {
            try {
                Scanner sc = new Scanner(System.in);
                System.out.println("---------Inventory---------");
                ArrayList<Weapon> inventory = player.getInventory();
                for(Weapon weapon: inventory) {
                    System.out.println(inventory.indexOf(weapon) + " : " + weapon.asciiArt());
                }
                int choice = sc.nextInt();
                while (choice < 0 || choice > inventory.size() - 1) {
                    System.out.println("Invalid choice");
                    choice = sc.nextInt();
                }
                player.changeWeapon(choice);
                chooseWeapon = true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        for(Map.Entry<Integer, Opponent> entry : opponents.entrySet()) {
            entry.getValue().executeMove(entry.getValue(), player);
            entry.getValue().takeDamage(player.makeDamage());
        }
        deadOpponent();
        return victory(player);
    }

    //actualizes the opponents list
    public void deadOpponent() {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(Map.Entry<Integer, Opponent> entry : opponents.entrySet()) {
            if (entry.getValue().isDead()) {
                list.add(entry.getKey());
            }
        }
        for(Integer integer : list) {
            opponents.remove(integer);
            TreeMap<Integer, Opponent> newMap = new TreeMap<Integer, Opponent>();
            int count = 1;
            for(Map.Entry<Integer, Opponent> entry : opponents.entrySet()) {
                newMap.put(count, entry.getValue());
                count++;
            }
            opponents = newMap;
        }
    }

    public boolean victory(Player player) {
        if (opponents.size() == 0) {
            player.giveReward(20);
            return true;
        }
        return false;
    }
}
