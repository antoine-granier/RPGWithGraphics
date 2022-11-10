package lp.rooms;

import lp.Randomizer;
import lp.Tuple;
import lp.player.Player;

import java.util.*;

public class Map {
    private static Room[][] rooms = new Room[4][4];
    private static Player player;
    private String cast;
    private static Tuple currentRoom;
    private boolean isGameOver;
    private String name;

    public Map() {
        isGameOver = false;
        currentRoom = new Tuple(0, 0);
        int remainingFightRoom = 6;
        int remainingMerchant = 1;
        int remainingFireCamp = 2;
        int remainingTrapRoom = 5;
        for(int i = 0; i < rooms.length; i++) {
            for(int j = 0; j < rooms.length; j++) {
                if(i == 0 && j == 0) {
                    rooms[i][j] = new StartRoom();
                } else if(remainingFightRoom == 0 && remainingFireCamp == 0 && remainingMerchant == 0 && remainingTrapRoom == 0) {
                    rooms[i][j] = null;
                } else {
                    int index = 0;
                    while (index == 0) {
                        int number = Randomizer.randomInt(0, 4);
                        switch (number) {
                            case 0:
                                if (remainingFightRoom != 0) {
                                    rooms[i][j] = new FightRoom(player);
                                    index++;
                                    remainingFightRoom--;
                                }
                                break;
                            case 1:
                                if (remainingTrapRoom != 0) {
                                    rooms[i][j] = new TrapRoom();
                                    index++;
                                    remainingTrapRoom--;
                                }
                                break;
                            case 2:
                                if (remainingFireCamp != 0) {
                                    rooms[i][j] = new FireCampRoom();
                                    index++;
                                    remainingFireCamp--;
                                }
                                break;
                            case 3:
                                if (remainingMerchant != 0) {
                                    rooms[i][j] = new MerchantRoom();
                                    index++;
                                    remainingMerchant--;
                                }
                                break;
                            default:
                                throw new IllegalArgumentException("Error in map generation.");
                        }
                    }
                }
            }
        }
    }

    public static void initCast(String cast, String name) {
        cast = cast;
        if(cast.equals("Barbarian")) {
            player = new Player(name, 150, 250, cast);
        } else if(cast.equals("Wizard")) {
            player = new Player(name, 250, 100, cast);
        } else {
            player = new Player(name, 200, 150, cast);
        }
    }

    public void gameOver() {
        isGameOver = true;
    }

    public boolean isGameOver() {
        return isGameOver;
    }

    public static Room getCurrentRoom() {
        return rooms[currentRoom.i()][currentRoom.j()];
    }

    public static Tuple getRoom() {
        return currentRoom;
    }

    public static void move() {
        try {
            Scanner sc = new Scanner(System.in);
            int moveDirection;
            int x = currentRoom.i();
            int y = currentRoom.j();
            if (x == 0) {
                if (y == 0) {
                    System.out.println("0 : go to right\n1 : go to top");
                    moveDirection = sc.nextInt();
                    while (moveDirection != 0 && moveDirection != 1) {
                        System.out.println("0 : go to right\n1 : go to top");
                        moveDirection = sc.nextInt();
                    }
                    switch (moveDirection) {
                        case 0:
                            nextRoom(currentRoom.i(), currentRoom.j() + 1);
                            break;
                        case 1:
                            nextRoom(currentRoom.i() + 1, currentRoom.j());
                            break;
                    }
                } else if(y == rooms.length - 1) {
                    System.out.println("0 : go to left\n1 : go to top");
                    moveDirection = sc.nextInt();
                    while (moveDirection != 0 && moveDirection != 1) {
                        System.out.println("0 : go to left\n1 : go to top");
                        moveDirection = sc.nextInt();
                    }
                    switch (moveDirection) {
                        case 0:
                            nextRoom(currentRoom.i(), currentRoom.j() - 1);
                            break;
                        case 1:
                            nextRoom(currentRoom.i() + 1, currentRoom.j());
                            break;
                    }
                } else {
                    System.out.println("0 : go to left\n1 : go to right\n2 : go to top");
                    moveDirection = sc.nextInt();
                    while (moveDirection != 0 && moveDirection != 1 && moveDirection != 2) {
                        System.out.println("0 : go to left\n1 : go to right\n2 : go to top");
                        moveDirection = sc.nextInt();
                    }
                    switch (moveDirection) {
                        case 0:
                            nextRoom(currentRoom.i(), currentRoom.j() - 1);
                            break;
                        case 1:
                            nextRoom(currentRoom.i(), currentRoom.j() + 1);
                            break;
                        case 2:
                            nextRoom(currentRoom.i() + 1, currentRoom.j());
                            break;
                    }
                }
            } else if(x == rooms.length - 1) {
                if (y == 0) {
                    System.out.println("0 : go to right\n1 : go to bottom");
                    moveDirection = sc.nextInt();
                    while (moveDirection != 0 && moveDirection != 1) {
                        System.out.println("0 : go to right\n1 : go to bottom");
                        moveDirection = sc.nextInt();
                    }
                    switch (moveDirection) {
                        case 0:
                            nextRoom(currentRoom.i(), currentRoom.j() + 1);
                            break;
                        case 1:
                            nextRoom(currentRoom.i() - 1, currentRoom.j());
                            break;
                    }
                } else if(y == rooms.length - 1) {
                    System.out.println("0 : go to left\n1 : go to bottom");
                    moveDirection = sc.nextInt();
                    while (moveDirection != 0 && moveDirection != 1) {
                        System.out.println("0 : go to left\n1 : go to bottom");
                        moveDirection = sc.nextInt();
                    }
                    switch (moveDirection) {
                        case 0:
                            nextRoom(currentRoom.i(), currentRoom.j() - 1);
                            break;
                        case 1:
                            nextRoom(currentRoom.i() - 1, currentRoom.j());
                            break;
                    }
                } else {
                    System.out.println("0 : go to left\n1 : go to right\n2 : go to bottom");
                    moveDirection = sc.nextInt();
                    while (moveDirection != 0 && moveDirection != 1 && moveDirection != 2) {
                        System.out.println("0 : go to left\n1 : go to right\n2 : go to bottom");
                        moveDirection = sc.nextInt();
                    }
                    switch (moveDirection) {
                        case 0:
                            nextRoom(currentRoom.i(), currentRoom.j() - 1);
                            break;
                        case 1:
                            nextRoom(currentRoom.i(), currentRoom.j() + 1);
                            break;
                        case 2:
                            nextRoom(currentRoom.i() - 1, currentRoom.j());
                            break;
                    }
                }
            } else {
                if(y == 0) {
                    System.out.println("0 : go to bottom\n1 : go to right\n2 : go to top");
                    moveDirection = sc.nextInt();
                    while (moveDirection != 0 && moveDirection != 1 && moveDirection != 2) {
                        System.out.println("0 : go to bottom\n1 : go to right\n2 : go to top");
                        moveDirection = sc.nextInt();
                    }
                    switch (moveDirection) {
                        case 0:
                            nextRoom(currentRoom.i() - 1, currentRoom.j());
                            break;
                        case 1:
                            nextRoom(currentRoom.i(), currentRoom.j() + 1);
                            break;
                        case 2:
                            nextRoom(currentRoom.i() + 1, currentRoom.j());
                            break;
                    }
                } else if(y == rooms.length - 1) {
                    System.out.println("0 : go to bottom\n1 : go to left\n2 : go to top");
                    moveDirection = sc.nextInt();
                    while (moveDirection != 0 && moveDirection != 1 && moveDirection != 2) {
                        System.out.println("0 : go to bottom\n1 : go to left\n2 : go to top");
                        moveDirection = sc.nextInt();
                    }
                    switch (moveDirection) {
                        case 0:
                            nextRoom(currentRoom.i() - 1, currentRoom.j());
                            break;
                        case 1:
                            nextRoom(currentRoom.i(), currentRoom.j() - 1);
                            break;
                        case 2:
                            nextRoom(currentRoom.i() + 1, currentRoom.j());
                            break;
                    }
                } else {
                    System.out.println("0 : go to left\n1 : go to bottom\n2 : go to right\n3 : go to top");
                    moveDirection = sc.nextInt();
                    while (moveDirection != 0 && moveDirection != 1 && moveDirection != 2 && moveDirection != 3) {
                        System.out.println("0 : go to left\n1 : go to bottom\n2 : go to right\n3 : go to top");
                        moveDirection = sc.nextInt();
                    }
                    switch (moveDirection) {
                        case 0:
                            nextRoom(currentRoom.i(), currentRoom.j() - 1);
                            break;
                        case 1:
                            nextRoom(currentRoom.i() - 1, currentRoom.j());
                            break;
                        case 2:
                            nextRoom(currentRoom.i(), currentRoom.j() + 1);
                            break;
                        case 3:
                            nextRoom(currentRoom.i() + 1, currentRoom.j());
                            break;
                    }
                }
            }
            System.out.println();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void nextRoom(int i, int j) {
        currentRoom = currentRoom.moveTo(i, j);
    }

    public Player getPlayer() {
        return player;
    }

    public String displayMap() {
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = rooms.length - 1; i >= 0; i--) {
            stringBuilder.append("|");
            for(int j = 0; j < rooms.length; j++) {
                if(i == currentRoom.i() && j == currentRoom.j()) {
                    stringBuilder.append("[ you ]");
                } else if(rooms[i][j] == null) {
                    stringBuilder.append("[ end ]");
                } else {
                    stringBuilder.append("[     ]");
                }
            }
            stringBuilder.append("|\n");
        }
        return stringBuilder.toString();
    }
}