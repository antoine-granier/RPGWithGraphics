package lp.view;

import lp.Log;
import lp.Tuple;
import lp.player.Player;
import lp.rooms.FightRoom;
import lp.rooms.Map;
import lp.rooms.StartRoom;
import lp.weapon.Weapon;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GameView {
    private final Map data;
    private final JLabel[][] labels;
    private static final JFrame mainWindow = new JFrame("RPG");
    private boolean move = false;
    private final JPanel center;
    private Weapon merchantChoice = null;
    private boolean merchantIsFinished = false;

    public GameView(Map data) {
        this.data = data;
        this.labels = new JLabel[data.getSizeMap()][data.getSizeMap()];
        for (int i = 0; i < data.getSizeMap(); i++) {
            for (int j = 0; j < data.getSizeMap(); j++) {
                JLabel label = new JLabel("", SwingConstants.CENTER);
                label.setBorder(BorderFactory.createLineBorder(Color.black));
                labels[i][j] = label;
            }
        }
        center = new JPanel(new GridLayout(data.getSizeMap(), data.getSizeMap()));
    }

    public void initGraphics() {
        JFrame window = new JFrame("Choose your cast");
        window.setSize(500, 400);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel main = new JPanel();
        main.setLayout(new BoxLayout(main, BoxLayout.Y_AXIS));
        JTextField input = new JTextField();
        JRadioButton radionBtn1 = new JRadioButton("Barbarian | gold : 150, hp : 250, start weapon : sword(damage : 15)", true);
        JRadioButton radionBtn2 = new JRadioButton("Wizard | gold : 250, hp : 100, start weapon : evil stick(damage : 20)");
        JRadioButton radionBtn3 = new JRadioButton("Archery | gold : 200, hp : 150, start weapon : bow(damage : 25)");
        JButton valide = new JButton("Valid");
        valide.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(radionBtn1.isSelected()) {
                    Map.initCast("Barbarian", input.getText());
                } else if(radionBtn2.isSelected()) {
                    Map.initCast("Wizard", input.getText());
                } else {
                    Map.initCast("Archery", input.getText());
                }
                if(Map.getCurrentRoom().getClass() == StartRoom.class) {
                    StartRoom startRoom = (StartRoom) Map.getCurrentRoom();
                    startRoom.choosedCast();
                }
                window.setVisible(false);
                window.dispose();
            }
        });
        ButtonGroup group = new ButtonGroup();
        JLabel label1 = new JLabel("Name : ");
        JLabel label2 = new JLabel("Cast : ");
        main.add(label1);
        main.add(input);
        main.add(label2);
        main.add(radionBtn1);
        main.add(radionBtn2);
        main.add(radionBtn3);
        main.add(valide);
        group.add(radionBtn1);
        group.add(radionBtn2);
        group.add(radionBtn3);
        window.add(main);
        window.setVisible(true);
    }

    public void refreshPlayerPosition(JPanel center) {
        for (int i = data.getSizeMap() - 1; i > -1; i--) {
            for (int j = 0; j < data.getSizeMap(); j++) {
                labels[i][j].setText("");
                center.add(labels[i][j]);
            }
        }
        labels[Map.getX()][Map.getY()].setText("You");
    }

    public void drawGrid() {
        move = false;
        mainWindow.setExtendedState(JFrame.MAXIMIZED_BOTH);
        mainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel main = new JPanel(new BorderLayout());
        JButton btn1 = new JButton("↑");
        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Map.moveTop();
                move = true;
            }
        });
        JButton btn2 = new JButton("←");
        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Map.moveLeft();
                move = true;
            }
        });
        JButton btn3 = new JButton("↓");
        btn3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Map.moveBottom();
                move = true;
            }
        });
        JButton btn4 = new JButton("→");
        btn4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Map.moveRight();
                move = true;
            }
        });
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
        JTextArea area = new JTextArea(10, 1);
        for(String log: Log.getLog().logDisplay(10)) {
            area.append(log + "\n");
        }
        eastPanel.add(area, BorderLayout.NORTH);
        main.add(eastPanel, BorderLayout.EAST);
        JPanel infos = new JPanel();
        infos.setLayout(new BoxLayout(infos, BoxLayout.Y_AXIS));
        Player player = data.getPlayer();
        String name = player.getName();
        int gold = player.getGold();
        int hp = player.getHp();
        infos.add(new JLabel("Name : " + name));
        infos.add(new JLabel("HP : " + hp));
        infos.add(new JLabel("Gold : " + gold));

        refreshPlayerPosition(center);
        mainWindow.add(center, BorderLayout.CENTER);
        mainWindow.add(main, BorderLayout.EAST);
        mainWindow.add(infos, BorderLayout.WEST);
        mainWindow.setVisible(true);
        while (!move) {
            System.out.println("Waiting for a direction...");
        }
        refreshPlayerPosition(center);
    }

    public void chooseWeapon() {
        final boolean[] chooseWeapon = {false};
        JFrame window = new JFrame("Choose weapon");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(600, 400);
        Player player = data.getPlayer();
        JPanel main = new JPanel();
        main.setLayout(new BoxLayout(main, BoxLayout.X_AXIS));
        JLabel label = new JLabel("Choose your weapon : ");
        main.add(label);
        ButtonGroup group = new ButtonGroup();
        JButton valide = new JButton("Valid");
        valide.setEnabled(false);
        valide.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                window.setVisible(false);
                window.dispose();
                chooseWeapon[0] = true;
            }
        });
        for (Weapon weapon: player.getInventory()) {
            JRadioButton radioButton = new JRadioButton(weapon.toString());
            radioButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if(radioButton.isSelected()) {
                        player.changeWeapon(weapon);
                        valide.setEnabled(true);
                    }
                }
            });
            group.add(radioButton);
            main.add(radioButton);
        }
        main.add(valide);
        window.add(main);
        window.setVisible(true);
        while (!chooseWeapon[0]) {
            System.out.println("Waiting for user's choice...");
        }
        if(Map.getCurrentRoom().getClass() == FightRoom.class) {
            FightRoom fightRoom = (FightRoom) Map.getCurrentRoom();
            fightRoom.isLoaded();
        }
    }

    public void MerchantView(ArrayList<Weapon> shop) {
        merchantChoice = null;
        merchantIsFinished = false;
        JFrame window = new JFrame("Merchant");
        JPanel main = new JPanel();
        main.setLayout(new BoxLayout(main, BoxLayout.Y_AXIS));
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(600, 400);
        JPanel radioPanel = new JPanel();
        radioPanel.setLayout(new BoxLayout(radioPanel, BoxLayout.X_AXIS));
        Player player = data.getPlayer();
        int gold = player.getGold();
        ButtonGroup buttonGroup = new ButtonGroup();
        for(Weapon weapon: shop) {
            JRadioButton radioButton = new JRadioButton(weapon.toString());
            if(gold < weapon.getPrice()) {
                radioButton.setEnabled(false);
                radioButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if(radioButton.isSelected()) {
                            merchantChoice = weapon;
                        }
                    }
                });
            }
            buttonGroup.add(radioButton);
            radioPanel.add(radioButton);
        }
        main.add(radioPanel);
        JButton button = new JButton("Valid");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(merchantChoice != null) {
                    player.addToInventory(merchantChoice);
                }
                merchantIsFinished = true;
                window.setVisible(false);
                window.dispose();
            }
        });
        main.add(button);
        window.add(main);
        window.setVisible(true);
        while (!merchantIsFinished) {
            System.out.println("Waiting fo user's choice...");
        }
    }

    public void endScreen(String str) {
        mainWindow.setVisible(false);
        mainWindow.dispose();
        JFrame endScreen = new JFrame(str);
        endScreen.setSize(300, 300);
        JLabel label = new JLabel(str, SwingConstants.CENTER);
        endScreen.add(label, BorderLayout.CENTER);
        endScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        endScreen.setVisible(true);
    }
}
