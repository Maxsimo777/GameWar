package com.company.rase.Entity;

public class Warrior {

    public String name;
    public float health;
    public boolean privilegia; //false - общая, true - привелигированая
    public float attackHP;
    public int race;


    public Warrior(String name,float health, boolean privilegia, float attackHP, int race) {
        this.name = name;
        this.health = health;
        this.privilegia = privilegia;
        this.attackHP = attackHP;
        this.race = race;
    }

    public float AttackWarrior (float healthHP, int race) {

        switch (race) {
            case 0: healthHP = healthHP-15;
            case 1: healthHP = healthHP-18;
            case 2: healthHP = healthHP-20;
            case 3: healthHP = healthHP-18;
        }

        return healthHP;

    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getHealth() {
        return health;
    }

    public void setHealth(float health) {
        this.health = health;
    }

    public boolean isPrivilegia() {
        return privilegia;
    }

    public void setPrivilegia(boolean privilegia) {
        this.privilegia = privilegia;
    }

    public float getAttackHP() {
        return attackHP;
    }

    public void setAttackHP(float attackHP) {
        this.attackHP = attackHP;
    }

    public int getRace() {
        return race;
    }

    public void setRace(int race) {
        this.race = race;
    }

}
