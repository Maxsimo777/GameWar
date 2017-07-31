package com.company.rase;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

public class DrawFistTeam extends Canvas {

    int type;

    public static Sprite mage;
    public static Sprite archerElf;
    public static Sprite archerElf1;
    public static Sprite archerElf2;
    public static Sprite warriorElf;
    public static Sprite warriorElf1;
    public static Sprite warriorElf2;
    public static Sprite warriorElf3;

    private static int x = 0;
    private static int y = 0;

    public void PicturesFirstTeam (int typecomandOne) {
        if (typecomandOne == 0) {
            mage = getSprite("com/company/rase/image/Elves/Mage.jpg");
            archerElf = getSprite("com/company/rase/image/Elves/ArcherElf.jpg");
            archerElf1 = getSprite("com/company/rase/image/Elves/ArcherElf.jpg");
            archerElf2 = getSprite("com/company/rase/image/Elves/ArcherElf.jpg");
            warriorElf = getSprite("com/company/rase/image/Elves/WarriorElf.jpg");
            warriorElf1 = getSprite("com/company/rase/image/Elves/WarriorElf.jpg");
            warriorElf2 = getSprite("com/company/rase/image/Elves/WarriorElf.jpg");
            warriorElf3 = getSprite("com/company/rase/image/Elves/WarriorElf.jpg");
        }
    }

    public void DrawPictureFirstTeam () {
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
}
