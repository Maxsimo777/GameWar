package com.company.rase.Entity;

public class Archer {

    public String name;
    public float health;
    public boolean privilegia; //false - общая, true - привелигированая
    public int race; //0 - эльфы, 1 - люди, 2- орки, 3 - нежити
    public float attackHPShoot;
    public float attackHP;


    public Archer(String name,float health, boolean privilegia, int race, float attackHPShoot, float attackHP) {
        this.name = name;
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

    public int getRase() {
        return race;
    }

    public void setRase(int rase) {
        this.race = rase;
    }

    public float getAttackHP() {
        return attackHP;
    }

    public void setAttackHP(float attackHP) {
        this.attackHP = attackHP;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getAttackHPShoot() {
        return attackHPShoot;
    }

    public void setAttackHPShoot(float attackHPShoot) {
        this.attackHPShoot = attackHPShoot;
    }

}
