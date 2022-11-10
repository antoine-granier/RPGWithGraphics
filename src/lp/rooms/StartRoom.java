package lp.rooms;

import lp.player.Player;

import java.security.InvalidParameterException;
import java.util.Scanner;

public class StartRoom implements Room{
    @Override
    public boolean roomEvent(Player player) {
        String name = "";
        int choice;
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter your adventurer's name :\n");
            name = sc.next();
            while(name.equals("")) {
                System.out.println("Invalid name\n");
                System.out.println("Enter your adventurer's name :\n");
                name = sc.next();
            }
            System.out.println("Select your cast :\n0 : Barbarian | gold : 150, hp : 250, start weapon : sword(damage : 15)\n1 : Wizard | gold : 250, hp : 100, start weapon : evil stick(damage : 20)\n2 : Archery | gold : 200, hp : 150, start weapon : bow(damage : 25)\n");
            choice = sc.nextInt();
            while (choice != 0 && choice != 1 && choice != 2) {
                System.out.println("Invalid choice\n");
                System.out.println("Select your cast :\n0 : Barbarian | gold : 150, hp : 250, start weapon : sword(damage : 15)\n1 : Wizard | gold : 250, hp : 100, start weapon : evil stick(damage : 20)\n2 : Archery | gold : 200, hp : 150, start weapon : bow(damage : 25)\n");
                choice = sc.nextInt();
            }
            //sc.close();
            switch (choice) {
                case 0:
                    Map.initCast("Barbarian", name);
                    break;
                case 1:
                    Map.initCast("Wizard", name);
                    break;
                case 2:
                    Map.initCast("Archery", name);
                    break;
                default:
                    throw new InvalidParameterException("Invalid cast choice");
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}