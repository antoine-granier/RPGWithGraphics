package lp.view;

import lp.rooms.Map;
import lp.rooms.StartRoom;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GameView {

    private int width;
    private int height;
    private Map data;
    private ArrayList<JButton> mouvementBtn;
    private ArrayList<JLabel> labels;
    private static JFrame window = new JFrame("RPG");
    private static JPanel main = new JPanel(new BorderLayout());

    public GameView(int width, int height, Map data) {
        this.width = width;
        this.height = height;
        this.data = data;
        this.mouvementBtn = new ArrayList<JButton>();
        this.labels = new ArrayList<JLabel>();
    }

    public void initGraphics() {
        JButton btn1 = new JButton("↑");
        JButton btn2 = new JButton("←");
        JButton btn3 = new JButton("↓");
        JButton btn4 = new JButton("→");
        Dimension size = Toolkit.getDefaultToolkit().getScreenSize();
        window.setSize(size);
        window.setExtendedState(JFrame.MAXIMIZED_BOTH);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel center = new JPanel(new FlowLayout());
        JTextField textField = new JTextField();
        center.add(textField);
        JButton btnBarbarian = new JButton("Barbarian | gold : 150, hp : 250, start weapon : sword(damage : 15)");
        btnBarbarian.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Map.initCast("Barbarian", textField.getText());
                if(Map.getCurrentRoom().getClass() == StartRoom.class) {
                    StartRoom startRoom = (StartRoom) Map.getCurrentRoom();
                    startRoom.choosedCast();
                }
            }
        });
        center.add(btnBarbarian);
        JButton btnWizard = new JButton("Wizard | gold : 250, hp : 100, start weapon : evil stick(damage : 20)");
        btnWizard.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Map.initCast("Wizard", textField.getText());
                if(Map.getCurrentRoom().getClass() == StartRoom.class) {
                    StartRoom startRoom = (StartRoom) Map.getCurrentRoom();
                    startRoom.choosedCast();
                }
            }
        });
        center.add(btnWizard);
        JButton btnArchery = new JButton("Archery | gold : 200, hp : 150, start weapon : bow(damage : 25)");
        btnArchery.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Map.initCast("Archery", textField.getText());
                if(Map.getCurrentRoom().getClass() == StartRoom.class) {
                    StartRoom startRoom = (StartRoom) Map.getCurrentRoom();
                    startRoom.choosedCast();
                }
            }
        });
        center.add(btnArchery);
        main.add(center, BorderLayout.CENTER);
        JPanel movements = new JPanel(new GridLayout(2, 3));
        movements.setPreferredSize(new Dimension(250, 150));
        movements.add(new Label());
        movements.add(btn1);
        movements.add(new Label());
        movements.add(btn2);
        movements.add(btn3);
        movements.add(btn4);
        JPanel eastPanel = new JPanel(new BorderLayout());
        eastPanel.add(movements, BorderLayout.SOUTH);
        main.add(eastPanel, BorderLayout.EAST);
        window.add(main);
        window.setVisible(true);
        //return new GameView(width, height, data, btn, lbs);
    }

    public void changePlayerPosition() {
        labels.get(data.getIntPosition()).setText("You");
    }

    public void drawGrid() {
        BorderLayout layout = (BorderLayout) main.getLayout();
        main.remove(layout.getLayoutComponent(BorderLayout.CENTER));
        JPanel center = new JPanel(new GridLayout(data.getSizeMap(), data.getSizeMap()));
        for(int i = 0; i < data.getSizeMap() * 2; i++) {
            JLabel label = new JLabel();
            label.setBorder(BorderFactory.createLineBorder(Color.black));
            center.add(label);
            labels.add(label);
        }
        main.add(center, BorderLayout.CENTER);
        window.validate();
    }

    @Override
    public String toString() {
        return "GameView{" +
                "width=" + width +
                ", height=" + height +
                ", data=" + data +
                ", mouvementBtn=" + mouvementBtn +
                ", labels=" + labels +
                '}';
    }
}
