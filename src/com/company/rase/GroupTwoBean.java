package com.company.rase;

import com.company.rase.Entity.Archer;
import com.company.rase.Entity.Mage;
import com.company.rase.Entity.Warrior;

import java.util.ArrayList;
import java.util.List;

public class GroupTwoBean {

    int typeGroup;


    public List<Archer> archerListTwo;
    public List<Warrior> warriorListTwo;
    public Mage mageTwo;


    public void CreateTwoTeam (int typeGroup) {
        switch (typeGroup) {
            case 2:
                mageTwo = new Mage("Шаман",100, typeGroup, 10,false);
                archerListTwo = new ArrayList<Archer>();
                archerListTwo.add(new Archer("ЛучникОрков1",100, false, typeGroup, 7, 3));
                archerListTwo.add(new Archer("ЛучникОрков2",100, false, typeGroup, 7, 3));
                archerListTwo.add(new Archer("ЛучникОрков3",100, false, typeGroup, 7, 3));
                warriorListTwo = new ArrayList<Warrior>();
                warriorListTwo.add(new Warrior("Гоблин1",100, false, 15, typeGroup));
                warriorListTwo.add(new Warrior("Гоблин2",100, false, 15, typeGroup));
                warriorListTwo.add(new Warrior("Гоблин3",100, false, 15, typeGroup));
                warriorListTwo.add(new Warrior("Гоблин4",100, false, 15, typeGroup));
                break;
            case 3:
                mageTwo = new Mage("Некромант",100, typeGroup, 4,false);
                archerListTwo = new ArrayList<Archer>();
                archerListTwo.add(new Archer("Охотник1",100, false, typeGroup, 5, 3));
                archerListTwo.add(new Archer("Охотник2",100, false, typeGroup, 5, 3));
                archerListTwo.add(new Archer("Охотник3",100, false, typeGroup, 5, 3));
                warriorListTwo = new ArrayList<Warrior>();
                warriorListTwo.add(new Warrior("Зомби1",100, false, 18, typeGroup));
                warriorListTwo.add(new Warrior("Зомби2",100, false, 18, typeGroup));
                warriorListTwo.add(new Warrior("Зомби3",100, false, 18, typeGroup));
                warriorListTwo.add(new Warrior("Зомби4",100, false, 18, typeGroup));
                break;
        }

    }


    public int getTypeGroup() {
        return typeGroup;
    }

    public void setTypeGroup(int typeGroup) {
        this.typeGroup = typeGroup;
    }

    public List<Archer> getArcherListTwo() {
        return archerListTwo;
    }

    public void setArcherListTwo(List<Archer> archerListTwo) {
        this.archerListTwo = archerListTwo;
    }

    public List<Warrior> getWarriorListTwo() {
        return warriorListTwo;
    }

    public void setWarriorListTwo(List<Warrior> warriorListTwo) {
        this.warriorListTwo = warriorListTwo;
    }

    public Mage getMageTwo() {
        return mageTwo;
    }

    public void setMageTwo(Mage mageTwo) {
        this.mageTwo = mageTwo;
    }

}
