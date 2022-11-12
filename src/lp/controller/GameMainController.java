package lp.controller;

import lp.rooms.Map;
import lp.rooms.StartRoom;
import lp.view.GameView;

import java.io.IOException;

public class GameMainController {

    public static void main(String[] args) throws IOException {
        Map data = new Map();
        //GameView view = GameView.initGraphics(1200, 800, data);
        GameView view = new GameView(1200, 800, data);
        view.initGraphics();
        GameMainController.mainLoop(data, view);
    }

    private static void mainLoop(Map data, GameView view) throws IOException {
        while (!data.isGameOver()) {
            if(data.getCurrentRoom() == null) {
                System.out.println("You win !!!");
                data.gameOver();
                break;
            }
            //System.out.println("in");

            if(data.getCurrentRoom().roomEvent(data.getPlayer())) {
                System.out.println("in");
                if(data.getPlayer().isDead()) {
                    System.out.println("You loose !!!");
                    data.gameOver();
                } else {
                        view.drawGrid();
                    System.out.println(data.getPlayer().toString());
                    System.out.println(data.displayMap());
                    //Map.move();
                    System.out.println(data.displayMap());
                    System.out.println(data.getRoom());
                }
            }
        }
    }
}
