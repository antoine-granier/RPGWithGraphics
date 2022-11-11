package lp.controller;

import lp.rooms.Map;
import lp.view.GameView;

import java.io.IOException;

public class GameMainController {
    public static void main(String[] args) throws IOException {
        Map data = new Map();
        GameView view = GameView.initGraphics(1200, 800, data);
        GameMainController.mainLoop(data);
    }

    private static void mainLoop(Map data) throws IOException {
        while (!data.isGameOver()) {
            if(data.getCurrentRoom() == null) {
                System.out.println("You win !!!");
                data.gameOver();
                break;
            }
            if(data.getCurrentRoom().roomEvent(data.getPlayer())) {
                if(data.getPlayer().isDead()) {
                    System.out.println("You loose !!!");
                    data.gameOver();
                } else {
                    System.out.println(data.getPlayer().toString());
                    System.out.println(data.displayMap());
                    Map.move();
                    System.out.println(data.displayMap());
                    System.out.println(data.getRoom());
                }
            }
        }
    }
}
