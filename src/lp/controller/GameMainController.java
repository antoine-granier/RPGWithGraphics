package lp.controller;

import lp.rooms.FightRoom;
import lp.rooms.Map;
import lp.rooms.StartRoom;
import lp.view.GameView;

import java.io.IOException;

public class GameMainController {

    public static void main(String[] args) throws IOException {
        Map data = new Map();
        GameView view = new GameView(data);
        view.initGraphics();
        GameMainController.mainLoop(data, view);
    }

    private static void mainLoop(Map data, GameView view) throws IOException {
        while (!data.isGameOver()) {
            if(Map.getCurrentRoom() == null) {
                System.out.println("You win !!!");
                data.gameOver();
                view.endScreen("You win !!!");
                break;
            }

            if(Map.getCurrentRoom().roomEvent(data.getPlayer(), view)) {
                if(data.getPlayer().isDead()) {
                    System.out.println("You loose !!!");
                    data.gameOver();
                    view.endScreen("You loose !!!");
                } else {
                        view.drawGrid();
                }
            }
        }
    }
}
