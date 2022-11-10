package lp.rooms;

import lp.player.Player;
import lp.weapon.*;

import java.util.ArrayList;
import java.util.Scanner;

public class MerchantRoom implements Room {

    private ArrayList<Weapon> shop;
    private boolean loaded;

    public MerchantRoom() {
        this.shop = new ArrayList<Weapon>();
        this.loaded = false;
    }

    @Override
    public boolean roomEvent(Player player) {
        if(!loaded) {
            switch (player.getCast()) {
                case "Barbarian":
                    shop.add(new Axe());
                    shop.add(new Hammer());
                    break;
                case "Wizard":
                    shop.add(new DemonicCross());
                    shop.add(new BewitchedBook());
                    break;
                case "Archery":
                    shop.add(new Crossbow());
                    shop.add(new Bomb());
                    break;
            }
            loaded = true;
        } else {
            try {
                Scanner sc = new Scanner(System.in);
                System.out.println("Do you want to buy a weapon ? (yes : 0, no : 1)");
                int choice = sc.nextInt();
                while (choice != 0 && choice != 1) {
                    System.out.println("Invalid choice !");
                    System.out.println("Do you want to buy a weapon ? (yes : 0, no : 1)");
                    choice = sc.nextInt();
                }
                if(choice == 0) {
                    System.out.println("Choose your weapon :\n");
                    StringBuilder str = new StringBuilder();
                    for(int i = 0; i < shop.size(); i++) {
                        str.append(i + " : " + shop.get(i).toString() + "\n" + shop.get(i).asciiArt() + "\n");
                    }
                    System.out.println(str.toString());
                    choice = sc.nextInt();
                    while (choice < 0 && choice > shop.size() - 1) {
                        System.out.println("Invalid choice !");
                        choice = sc.nextInt();
                    }
                    if(player.haveNecessaryMoney(shop.get(choice).getPrice())) {
                        player.addToInventory(shop.get(choice));
                    } else {
                        System.out.println("You need more money !");
                    }
                } else {
                    return true;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return true;
        }
        return false;
    }
}
