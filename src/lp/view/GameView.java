package lp.view;

import lp.rooms.Map;

import javax.swing.*;
import java.awt.*;

public record GameView(int width, int height, Map data) {

    public static GameView initGraphics(int width, int height, Map data) {
        JFrame window = new JFrame("RPG");
        window.setSize(width, height);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel main = new JPanel(new BorderLayout());
        JPanel movements = new JPanel(new GridLayout(2, 3));
        movements.setPreferredSize(new Dimension(250, 150));
        JButton top = new JButton("↑");
        JButton left = new JButton("←");
        JButton bottom = new JButton("↓");
        JButton right = new JButton("→");
        movements.add(new Label());
        movements.add(top);
        movements.add(new Label());
        movements.add(left);
        movements.add(bottom);
        movements.add(right);
        JPanel eastPanel = new JPanel(new BorderLayout());
        eastPanel.add(movements, BorderLayout.SOUTH);
        main.add(eastPanel, BorderLayout.EAST);
        window.add(main);
        window.setVisible(true);
        return new GameView(width, height, data);
    }

    public void draw(Graphics graphics) {

    }
}
