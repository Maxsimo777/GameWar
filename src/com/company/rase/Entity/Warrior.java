package com.company.rase.Entity;

public class Warrior {

  private int health = 100;
  private boolean privilegia; //false - общая, true - привелигированая
  private int attackHP;
  private int race;


    public Warrior(int health, boolean privilegia, int attackHP, int race) {
        this.health = health;
        this.privilegia = privilegia;
        this.attackHP = attackHP;
        this.race = race;
    }

    public int AttackWarrior (int healthHP, int race) {

        switch (race) {
            case 0: healthHP = healthHP-15;
            case 1: healthHP = healthHP-18;
            case 2: healthHP = healthHP-20;
            case 3: healthHP = healthHP-18;
        }

        return healthHP;

    }

}
