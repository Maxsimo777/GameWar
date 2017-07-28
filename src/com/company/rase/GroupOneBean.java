package com.company.rase;

import com.company.rase.Entity.Archer;
import com.company.rase.Entity.Mage;
import com.company.rase.Entity.Warrior;

import java.util.ArrayList;
import java.util.List;

public class GroupOneBean {

    int typeGroup;

    private List<Archer> archerList;
    private List<Warrior> warriorList;
    private Mage mage;

    public GroupOneBean(int typeGroup) {

        switch (typeGroup) {
            case 0:
                mage = new Mage(100, typeGroup, 10);
                archerList = new ArrayList<Archer>();
                archerList.add(new Archer(100,false,typeGroup,7, 3));
                archerList.add(new Archer(100,false,typeGroup,7, 3));
                archerList.add(new Archer(100,false,typeGroup,7, 3));
                warriorList = new ArrayList<Warrior>();
                warriorList.add(new Warrior(100, false,15,typeGroup));
                warriorList.add(new Warrior(100, false,15,typeGroup));
                warriorList.add(new Warrior(100, false,15,typeGroup));
                warriorList.add(new Warrior(100, false,15,typeGroup));
            case 1:
                mage = new Mage(100, typeGroup, 4);
                archerList = new ArrayList<Archer>();
                archerList.add(new Archer(100,false,typeGroup,5, 3));
                archerList.add(new Archer(100,false,typeGroup,5, 3));
                archerList.add(new Archer(100,false,typeGroup,5, 3));
                warriorList = new ArrayList<Warrior>();
                warriorList.add(new Warrior(100, false,18,typeGroup));
                warriorList.add(new Warrior(100, false,18,typeGroup));
                warriorList.add(new Warrior(100, false,18,typeGroup));
                warriorList.add(new Warrior(100, false,18,typeGroup));
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
        return mage;
    }

    public void setMage(Mage mage) {
        this.mage = mage;
    }
}
