package com.company.rase;

import com.company.rase.Entity.Archer;
import com.company.rase.Entity.Mage;
import com.company.rase.Entity.Warrior;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class GroupOneBean extends Canvas {

    int typeGroup;

    private List<Archer> archerList;
    private List<Warrior> warriorList;
    private Mage mage1;




    public void CreateFirstTeam (int typeGroup) {
        switch (typeGroup) {
            case 0:
                mage1 = new Mage(100, typeGroup, 10);
                archerList = new ArrayList<Archer>();
                archerList.add(new Archer(100, false, typeGroup, 7, 3));
                archerList.add(new Archer(100, false, typeGroup, 7, 3));
                archerList.add(new Archer(100, false, typeGroup, 7, 3));
                warriorList = new ArrayList<Warrior>();
                warriorList.add(new Warrior(100, false, 15, typeGroup));
                warriorList.add(new Warrior(100, false, 15, typeGroup));
                warriorList.add(new Warrior(100, false, 15, typeGroup));
                warriorList.add(new Warrior(100, false, 15, typeGroup));
            case 1:
                mage1 = new Mage(100, typeGroup, 4);
                archerList = new ArrayList<Archer>();
                archerList.add(new Archer(100, false, typeGroup, 5, 3));
                archerList.add(new Archer(100, false, typeGroup, 5, 3));
                archerList.add(new Archer(100, false, typeGroup, 5, 3));
                warriorList = new ArrayList<Warrior>();
                warriorList.add(new Warrior(100, false, 18, typeGroup));
                warriorList.add(new Warrior(100, false, 18, typeGroup));
                warriorList.add(new Warrior(100, false, 18, typeGroup));
                warriorList.add(new Warrior(100, false, 18, typeGroup));
        }

    }




    public int getTypeGroup() {
        return typeGroup;
    }

    public void setTypeGroup(int typeGroup) {
        this.typeGroup = typeGroup;
    }

    public List<Archer> getArcherList() {
        return archerList;
    }

    public void setArcherList(List<Archer> archerList) {
        this.archerList = archerList;
    }

    public List<Warrior> getWarriorList() {
        return warriorList;
    }

    public void setWarriorList(List<Warrior> warriorList) {
        this.warriorList = warriorList;
    }

    public Mage getMage() {
        return mage1;
    }

    public void setMage(Mage mage) {
        this.mage1 = mage1;
    }
}
