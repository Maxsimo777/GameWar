package com.company.rase;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.awt.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import com.company.rase.GroupOneBean;
import javax.naming.*;

public class Game extends Canvas implements Runnable {
    private static final long serialVersionUID = 1L;

    private boolean running;

    public static int WIDTH = 800;
    public static int HEIGHT = 600;
    public static String NAME = "War race";

    private boolean leftPressed = false;
    private boolean rightPressed = false;

    public static Sprite mage;
    public static Sprite archerElf;
    public static Sprite archerElf1;
    public static Sprite archerElf2;
    public static Sprite warriorElf;
    public static Sprite warriorElf1;
    public static Sprite warriorElf2;
    public static Sprite warriorElf3;

    public static Sprite shaman;
    public static Sprite archerOrcs;
    public static Sprite archerOrcs1;
    public static Sprite archerOrcs2;
    public static Sprite goblin;
    public static Sprite goblin1;
    public static Sprite goblin2;
    public static Sprite goblin3;

    public static DrawFistTeam drawFistTeam;

    private static int x = 0;
    private static int y = 0;

    private static int ran;

    JTextArea textArea2 = new JTextArea();

    public void start() {
        running = true;
        new Thread(this).start();
    }

    public void run() {
        long lastTime = System.currentTimeMillis();
        long delta;

        init();

        while (running) {
            delta = System.currentTimeMillis() - lastTime;
            lastTime = System.currentTimeMillis();
            render();
            update(delta);
        }
    }

    public void init() {
        mage = getSprite("com/company/rase/image/Elves/Mage.jpg");
        archerElf = getSprite("com/company/rase/image/Elves/ArcherElf.jpg");
        archerElf1 = getSprite("com/company/rase/image/Elves/ArcherElf.jpg");
        archerElf2 = getSprite("com/company/rase/image/Elves/ArcherElf.jpg");
        warriorElf = getSprite("com/company/rase/image/Elves/WarriorElf.jpg");
        warriorElf1 = getSprite("com/company/rase/image/Elves/WarriorElf.jpg");
        warriorElf2 = getSprite("com/company/rase/image/Elves/WarriorElf.jpg");
        warriorElf3 = getSprite("com/company/rase/image/Elves/WarriorElf.jpg");
        Logic logic = new Logic();
        logic.CreateGame();
        logic.getTypecomandOne();
    }

    public void render() {
        BufferStrategy bs = getBufferStrategy();
        if (bs == null) {
      //      createBufferStrategy(2);
            requestFocus();
            return;
        }

        Graphics g = bs.getDrawGraphics();
        g.setColor(Color.white);
        g.fillRect(0, 0, getWidth(), getHeight());
        mage.draw(g, x + 10, y + 180);
        archerElf.draw(g, 120, 30);
        archerElf1.draw(g, 120, 180);
        archerElf2.draw(g, 120, 330);
        warriorElf.draw(g, 250, 30);
        warriorElf1.draw(g, 250, 180);
        warriorElf2.draw(g, 250, 330);
        warriorElf3.draw(g, 250, 480);
        g.dispose();
        bs.show();
    }

    public void update(long delta) {
     /*   if (leftPressed == true) {
            x--;
        }
        if (rightPressed == true) {
            x++;
        } */
    }

    public Sprite getSprite(String path) {
        BufferedImage sourceImage = null;

        try {
            URL url = this.getClass().getClassLoader().getResource(path);
            sourceImage = ImageIO.read(url);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Sprite sprite = new Sprite(Toolkit.getDefaultToolkit().createImage(sourceImage.getSource()));

        return sprite;
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.setPreferredSize(new Dimension(WIDTH, HEIGHT));
     /*   Frame1 frame1 = new Frame1();
        frame1.setSize(800,400);
        frame1.setResizable(false);
        frame1.pack();
        frame1.setLocationRelativeTo(null);
        frame1.setVisible(true); */


       /* JFrame frame = new JFrame(Game.NAME);
        JTextArea textArea2 = new JTextArea();
        frame.setSize(800, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.add(game, BorderLayout.CENTER);
        frame.pack();
        frame.setResizable(false);
        frame.setVisible(true); */


        // frame.getContentPane().add(new JPanel());
        // ((JPanel)frame.getContentPane().getComponent(0)).add(new JLabel("Hello"));
        // frame.getContentPane().invalidate();
        //  JTextArea  TextArea = new JTextArea(10,30);
        //  TextArea.setText("54353454");



        game.start();
    }

    public JTextArea getTextArea() {
        return textArea2;
    }

    public static class Frame1 extends JFrame {
        private JTextArea textArea1 = new JTextArea();
        public Logic logic1 = new Logic();
        private int type;

        public Frame1() {
            setLayout(new FlowLayout());
            add(textArea1);
            type = logic1.getTypecomandOne();
            if (type == 0) {
                textArea1.setText("Созданная команда расы ельфы");
            } else {
                textArea1.setText("Созданная команда расы люди");
            }
        }

        public JTextArea getTextArea() {
            return textArea1;
        }


    }
}

