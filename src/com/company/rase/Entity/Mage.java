package com.company.rase.Entity;

public class Mage {

    public String name;
    public float health = 100;
    public int race;   //0 - эльфы, 1 - люди, 2- орки, 3 - нежити
    public float attackMage;


    public Mage(String name, float health, int race, float attackMage) {
        this.name  = name;
        this.health = health;
        this.race = race;
        this.attackMage = attackMage;
    }

    public float Improve(float attack) {
        attack = (float) (attack*1.5);
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

    public float Curse (float attack) {
        attack = (float) (attack/1.5);
        return attack;
    }

    public float Disease (float attack) {
        attack = attack/2;
        return attack;
    }

    public float getHealth() {
        return health;
    }

    public void setHealth(float health) {
        this.health = health;
    }

    public int getRase() {
        return race;
    }

    public void setRase(int rase) {
        this.race = rase;
    }

    public float getAttackMage() {
        return attackMage;
    }

    public void setAttackMage(float attackMage) {
        this.attackMage = attackMage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
