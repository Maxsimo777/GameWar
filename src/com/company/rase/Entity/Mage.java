package com.company.rase.Entity;

public class Mage {

    private int health = 100;
    private int race;   //0 - эльфы, 1 - люди, 2- орки, 3 - нежити
    private int attackMage;


    public Mage(int health, int race, int attackMage) {
        this.health = health;
        this.race = race;
        this.attackMage = attackMage;
    }

    public double Improve(double attack) {
        attack = attack*1.5;
        return attack;
    }

    public int AttackMage(int HPattackMage, int race){

        switch (race) {
            case 0: HPattackMage = HPattackMage-10;
            case 1: HPattackMage = HPattackMage-4;
            case 3: HPattackMage = HPattackMage-2;
        }

        return HPattackMage;

    }

    public double Curse (double attack) {
        attack = attack/1.5;
        return attack;
    }

    public int Disease (int attack) {
        attack = attack/2;
        return attack;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getRase() {
        return race;
    }

    public void setRase(int rase) {
        this.race = rase;
    }

    public int getAttackMage() {
        return attackMage;
    }

    public void setAttackMage(int attackMage) {
        this.attackMage = attackMage;
    }


}
