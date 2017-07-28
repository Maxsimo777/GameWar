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

    private static int x = 0;
    private static int y = 0;

    private static int ran;

    public void start() {
        running = true;
        new Thread(this).start();
    }

    public void run() {
        long lastTime = System.currentTimeMillis();
        long delta;

        init();

        while(running) {
            delta = System.currentTimeMillis() - lastTime;
            lastTime = System.currentTimeMillis();
            render();
            update(delta);
        }
    }

    public void init() {
        addKeyListener(new KeyInputHandler());
        mage = getSprite("com/company/rase/image/Elves/Mage.jpg");
        archerElf = getSprite("com/company/rase/image/Elves/ArcherElf.jpg");
        archerElf1 = getSprite("com/company/rase/image/Elves/ArcherElf.jpg");
        archerElf2 = getSprite("com/company/rase/image/Elves/ArcherElf.jpg");
        warriorElf = getSprite("com/company/rase/image/Elves/WarriorElf.jpg");
        warriorElf1 = getSprite("com/company/rase/image/Elves/WarriorElf.jpg");
        warriorElf2 = getSprite("com/company/rase/image/Elves/WarriorElf.jpg");
        warriorElf3 = getSprite("com/company/rase/image/Elves/WarriorElf.jpg");
        Logic logic = new Logic();
        logic.CreateGroupTeam();
    }

    public void render() {
        BufferStrategy bs = getBufferStrategy();
        if (bs == null) {
            createBufferStrategy(2);
            requestFocus();
            return;
        }

        Graphics g = bs.getDrawGraphics();
        g.setColor(Color.white);
        g.fillRect(0, 0, getWidth(), getHeight());
        mage.draw(g, x+10, y+180);
        archerElf.draw(g,120,30);
        archerElf1.draw(g,120,180);
        archerElf2.draw(g,120,330);
        warriorElf.draw(g,250,30);
        warriorElf1.draw(g,250,180);
        warriorElf2.draw(g,250,330);
        warriorElf3.draw(g,250,480);
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
        JFrame frame = new JFrame(Game.NAME);
        frame.setSize(800,400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.add(game, BorderLayout.CENTER);
        frame.pack();
        frame.setResizable(false);
        frame.setVisible(true);
     //   frame.getContentPane().add(new JPanel());
      //  ((JPanel)frame.getContentPane().getComponent(0)).add(new JLabel("Hello"));
      //  frame.getContentPane().invalidate();
        game.start();
    }

    private class KeyInputHandler extends KeyAdapter {
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                leftPressed = true;
            }
            if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                rightPressed = true;
            }
        }

        public void keyReleased(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                leftPressed = false;
            }
            if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                rightPressed = false;
            }
        }
    }
}

