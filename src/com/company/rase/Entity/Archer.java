package com.company.rase.Entity;

public class Archer {

private int health;
private boolean privilegia; //false - общая, true - привелигированая
private int race; //0 - эльфы, 1 - люди, 2- орки, 3 - нежити
private int attackHPShoot;
private int attackHP;


    public Archer(int health, boolean privilegia, int race, int attackHPShoot, int attackHP) {
        this.health = health;
        this.privilegia = privilegia;
        this.race = race;
        this.attackHPShoot = attackHPShoot;
        this.attackHP = attackHP;
    }


    public int Shoot (int hpShoot, int race){

    switch (race) {
        case 0: hpShoot = hpShoot-7;
        case 1: hpShoot = hpShoot-5;
        case 2: hpShoot = hpShoot-3;
        case 3: hpShoot = hpShoot-4;
    }

  return hpShoot;

}

public int Attack (int hpAttack, int race) {

    switch (race) {
        case 0: hpAttack = hpAttack-7;
        case 1: hpAttack = hpAttack-5;
        case 2: hpAttack = hpAttack-3;
        case 3: hpAttack = hpAttack-4;
    }

    return hpAttack;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public boolean isPrivilegia() {
        return privilegia;
    }

    public void setPrivilegia(boolean privilegia) {
        this.privilegia = privilegia;
    }

    public int getRase() {
        return race;
    }

    public void setRase(int rase) {
        this.race = rase;
    }

    public int getAttackHP() {
        return attackHP;
    }

    public void setAttackHP(int attackHP) {
        this.attackHP = attackHP;
    }

}
