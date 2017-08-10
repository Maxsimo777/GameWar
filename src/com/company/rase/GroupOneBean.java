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

public class GroupOneBean {

    int typeGroup;


    public List<Archer> archerListOne;
    public List<Warrior> warriorListOne;
    public Mage mageOne;


    public void CreateFirstTeam(int typeGroup) { //CreateFirstTeam
             /*   mageOne = new Mage("МагЕльфов",100, typeGroup, 10);
                archerListOne = new ArrayList<Archer>();
                archerListOne.add(new Archer("Лучник1",100, false, typeGroup, 7, 3));
                archerListOne.add(new Archer("Лучник2",100, false, typeGroup, 7, 3));
                archerListOne.add(new Archer("Лучник3",100, false, typeGroup, 7, 3));
                warriorListOne = new ArrayList<Warrior>();
                warriorListOne.add(new Warrior("ВоинЕльфов1",100, false, 15, typeGroup));
                warriorListOne.add(new Warrior("ВоинЕльфов2",100, false, 15, typeGroup));
                warriorListOne.add(new Warrior("ВоинЕльфов3",100, false, 15, typeGroup));
                warriorListOne.add(new Warrior("ВоинЕльфов4",100, false, 15, typeGroup)); */
                CreateMage(typeGroup);
                CreateArcher(typeGroup);
                CreateWarrior(typeGroup);
             /*   mageOne = new Mage("МагЛюдей",100, typeGroup, 4);
                archerListOne = new ArrayList<Archer>();
                archerListOne.add(new Archer("Арбалетчик1",100, false, typeGroup, 5, 3));
                archerListOne.add(new Archer("Арбалетчик2",100, false, typeGroup, 5, 3));
                archerListOne.add(new Archer("Арбалетчик3",100, false, typeGroup, 5, 3));
                warriorListOne = new ArrayList<Warrior>();
                warriorListOne.add(new Warrior("ВоинЛюдей1",100, false, 18, typeGroup));
                warriorListOne.add(new Warrior("ВоинЛюдей2",100, false, 18, typeGroup));
                warriorListOne.add(new Warrior("ВоинЛюдей3",100, false, 18, typeGroup));
                warriorListOne.add(new Warrior("ВоинЛюдей4",100, false, 18, typeGroup)); */

    }

    public Mage CreateMage(int type){
        switch (type) {
            case 0:
                mageOne = new Mage("МагЕльфов",100, typeGroup, 10);
                break;
            case 1:
                mageOne = new Mage("МагЛюдей",100, typeGroup, 4);
                break;
        }

        return mageOne;
    }

    public List<Archer> CreateArcher (int type) {
        archerListOne = new ArrayList<Archer>();
        switch (type){
            case 0:
                archerListOne.add(new Archer("Лучник1",100, false, typeGroup, 7, 3));
                archerListOne.add(new Archer("Лучник2",100, false, typeGroup, 7, 3));
                archerListOne.add(new Archer("Лучник3",100, false, typeGroup, 7, 3));
                break;
            case 1:
                archerListOne.add(new Archer("Арбалетчик1",100, false, typeGroup, 5, 3));
                archerListOne.add(new Archer("Арбалетчик2",100, false, typeGroup, 5, 3));
                archerListOne.add(new Archer("Арбалетчик3",100, false, typeGroup, 5, 3));
                break;
        }

        return archerListOne;
    }

    public List<Warrior> CreateWarrior (int type) {
        warriorListOne = new ArrayList<Warrior>();
        switch (type){
            case 0:
                warriorListOne.add(new Warrior("ВоинЕльфов1",100, false, 15, typeGroup));
                warriorListOne.add(new Warrior("ВоинЕльфов2",100, false, 15, typeGroup));
                warriorListOne.add(new Warrior("ВоинЕльфов3",100, false, 15, typeGroup));
                warriorListOne.add(new Warrior("ВоинЕльфов4",100, false, 15, typeGroup));
                break;
            case 1:
                warriorListOne.add(new Warrior("ВоинЛюдей1",100, false, 18, typeGroup));
                warriorListOne.add(new Warrior("ВоинЛюдей2",100, false, 18, typeGroup));
                warriorListOne.add(new Warrior("ВоинЛюдей3",100, false, 18, typeGroup));
                warriorListOne.add(new Warrior("ВоинЛюдей4",100, false, 18, typeGroup));
                break;
        }

        return warriorListOne;
    }

    public int getTypeGroup() {
        return typeGroup;
    }

    public void setTypeGroup(int typeGroup) {
        this.typeGroup = typeGroup;
    }

    public List<Archer> getArcherList() {
        return archerListOne;
    }

    public void setArcherList(List<Archer> archerList) {
        this.archerListOne = archerList;
    }

    public List<Warrior> getWarriorList() {
        return warriorListOne;
    }

    public void setWarriorList(List<Warrior> warriorList) {
        this.warriorListOne = warriorList;
    }

    public Mage getMage() {
        return mageOne;
    }

    public void setMage(Mage mage) {
        this.mageOne = mageOne;
    }
}
