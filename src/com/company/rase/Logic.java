package com.company.rase;

import com.company.rase.Entity.*;
import com.company.rase.Entity.File;


import java.lang.*;
import java.util.concurrent.TimeUnit;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Logic  {

    public int typecomandOne = rnd(0,1);
    public int typecomandTwo = rnd(2,3);
    public int selectteam;
    public int selectGroupTeamOne;
    public int selectGroupTeamTwo;
    public Archer selectArcherTeamOne;
    public Archer selectArcherTeamTwo;
    public Mage selectMageTeamOne;
    public Mage selectMageTeamTwo;
    public Warrior selectWarriorTeamOne;
    public Warrior selectWarriorTeamTwo;
    public int selectArcher1t;
    public int selectArcher2t;
    public int selectWarrior1t;
    public int selectWarrior2t;
    public int selectActionMage1t;
    public int selectActionArcher1t;
    public int selectActionWarrior1t;
    public int selectActionMage2t;
    public int selectActionArcher2t;
    public int selectActionWarrior2t;
    public float attackHP1t;
    public float attackHP2t;
    public int selectGroupImprove;


    private float generalhpTeamOne = 800;
    private float getGeneralhpTeamTwo = 800;
    public float hpcharacter;
    public float improveattackshootArcher;
    public float improveattackArcher;
    public float improveattackWarrior;

    boolean priznak;
    boolean priznak1;
    int index;
    int index1;

    boolean priznak2Team;
    boolean priznak12Team;
    int index2Team;
    int index12Team;

    float newattackMage;
    float newattackArcher;
    float newattackshootArcher;
    float newattackWarrior;
    int stroke;
    String text;
    String text1;
    public List<File> listtext;
    public float healthcharacterOne;
    public float healthcharacterTwo;

    public int sizeArcher1t;
    public int sizeWarrior1t;
    public int sizeArcher2t;
    public int sizeWarrior2t;



    public void CreateGame()  {

     /*   try(FileOutputStream fos = new FileOutputStream("D://LOG.txt")) {

            text = "Hello world!" +"\n";
            text1 = "\n" + "433242434";

            byte[] buffer = text.getBytes();
            byte[] buffer1 = text1.getBytes();

            fos.write(buffer, 0, buffer.length);
            fos.write(buffer1, 0, buffer1.length); */
            listtext = new ArrayList<File>();






            GroupOneBean TeamOne = new GroupOneBean();
            TeamOne.CreateFirstTeam(typecomandOne);
           // System.out.print(typecomandOne + "\n");
            if (typecomandOne == 0) {
                System.out.print("Создана первая команда с расой ельфов с общим здоровьем " + generalhpTeamOne +"HP"+"\n");
                listtext.add(new File("Создана первая команда с расой ельфов с общим здоровьем "+ generalhpTeamOne+"HP"));
            } else {
                System.out.print("Создана первая команда с расой людей с общим здоровьем " + generalhpTeamOne +"HP"+"\n");
                listtext.add(new File("Создана первая команда с расой людей с общим здоровьем "+ generalhpTeamOne+"HP"));
            }




            //     System.out.print(TeamOne.CreateArcher(typecomandOne).get(2).getName() + "\n");
            //     System.out.print(TeamOne.getArcherList().get(2).getName() + "\n");


            GroupTwoBean TeamTwo = new GroupTwoBean();
            TeamTwo.CreateTwoTeam(typecomandTwo);
           // System.out.print(typecomandTwo + "\n");
            if (typecomandTwo == 2) {
                System.out.print("Создана вторая команда с расой орков с общим здоровьем " + getGeneralhpTeamTwo +"HP"+"\n");
                listtext.add(new File("Создана вторая команда с расой орков с общим здоровьем "+ getGeneralhpTeamTwo+"HP"));
            } else {
                System.out.print("Создана вторая команда с расой нежити с общим здоровьем " + getGeneralhpTeamTwo +"HP"+ "\n");
                listtext.add(new File("Создана вторая команда с расой нежити с общим  здоровьем "+ getGeneralhpTeamTwo+"HP"));
            }

            stroke = 1;
            while ((generalhpTeamOne >= 0) || (getGeneralhpTeamTwo < 0)) {

                System.out.println((char) 27 + "[31mХод № " + stroke + (char) 27 + "[0m");
                listtext.add(new File("Ход № "+ stroke));

                selectteam = rnd(0, 1);

                if (selectteam == 0) {
                    System.out.print("Выбрана первая команда с общим  здоровьем " + generalhpTeamOne+"HP"+ "\n");
                    listtext.add(new File("Выбрана первая команда с общим  здоровьем "+ generalhpTeamOne+"HP"));

                    sizeArcher1t = TeamOne.getArcherList().size();
                    sizeWarrior1t = TeamOne.getWarriorList().size();

                    for (int i = 0; i <= sizeArcher1t-1; i++) {
                        if (TeamOne.getArcherList().get(i).isPrivilegia() == false) {
                            priznak = false;

                        } else {
                            priznak = true;
                            index = i;
                        }
                    }

                    for (int i = 0; i <= sizeWarrior1t-1; i++) {
                        if (TeamOne.getWarriorList().get(i).isPrivilegia() == false) {
                            priznak1 = false;

                        } else {
                            priznak1 = true;
                            index1 = i;
                        }
                    }

                    if ((priznak == true) || (priznak1 == true)) {
                        System.out.print("Привилегированная группа в команде 1 есть" + "\n");
                        listtext.add(new File("Привилегированная группа в команде 1 есть"));
                        if (priznak == true) {
                            sizeArcher1t = TeamOne.getArcherList().size();
                            if (sizeArcher1t > 0) {
                                selectArcherTeamOne = TeamOne.getArcherList().get(index);
                                healthcharacterOne = selectArcherTeamOne.getHealth();
                                System.out.print("Выбран с привелегией " + selectArcherTeamOne.name + " из команды 1" + "со здоровьем" + healthcharacterOne + "HP" + "\n");
                                listtext.add(new File("Выбран с привелегией " + selectArcherTeamOne.name + " из команды 1" + "со здоровьем" + healthcharacterOne + "HP"));
                                selectActionArcher1t = rnd(0, 1);
                                if (selectActionArcher1t == 0) {
                                    System.out.print(selectArcherTeamOne.name + " из команды 1" + " стреляет в" + "\n");
                                    listtext.add(new File(selectArcherTeamOne.name + " из команды 1" + " стреляет в"));
                                    attackHP1t = selectArcherTeamOne.attackHPShoot;
                                    getTwoTeamHP(attackHP1t, TeamTwo);
                                    getGeneralhpTeamTwo = getGeneralhpTeamTwo - attackHP1t;
                                    System.out.print("Общее здоровье 2 команды составляет  " + getGeneralhpTeamTwo + "\n");
                                    listtext.add(new File("Общее здоровье 2 команды составляет  " + getGeneralhpTeamTwo));
                                    selectArcherTeamOne.setPrivilegia(false);
                                } else {
                                    System.out.print(selectArcherTeamOne.name + " из команды 1" + " атакует" + "\n");
                                    listtext.add(new File(selectArcherTeamOne.name + " из команды 1" + " атакует"));
                                    attackHP1t = selectArcherTeamOne.attackHP;
                                    getTwoTeamHP(attackHP1t, TeamTwo);
                                    getGeneralhpTeamTwo = getGeneralhpTeamTwo - attackHP1t;
                                    System.out.print("Общее здоровье 2 команды составляет  " + getGeneralhpTeamTwo + "\n");
                                    listtext.add(new File("Общее здоровье 2 команды составляет  " + getGeneralhpTeamTwo));
                                    selectArcherTeamOne.setPrivilegia(false);
                                }
                            }
                        }
                        if (priznak1 == true) {
                            sizeWarrior1t = TeamOne.getWarriorList().size();
                            if (sizeWarrior1t > 0) {
                                selectWarriorTeamOne = TeamOne.getWarriorList().get(index1);
                                healthcharacterOne = selectWarriorTeamOne.getHealth();
                                System.out.print("Выбран " + selectWarriorTeamOne.name + " из команды 1" + "со здоровьем" + healthcharacterOne + "\n");
                                listtext.add(new File("Выбран " + selectWarriorTeamOne.name + " из команды 1" + "со здоровьем" + healthcharacterOne));
                                System.out.print(selectWarriorTeamOne.name + " из команды 1" + " атакует мечом" + "\n");
                                listtext.add(new File(selectWarriorTeamOne.name + " из команды 1" + " атакует мечом"));
                                attackHP1t = selectWarriorTeamOne.attackHP;
                                getTwoTeamHP(attackHP1t, TeamTwo);
                                getGeneralhpTeamTwo = getGeneralhpTeamTwo - attackHP1t;
                                System.out.print("Общее здоровье команды 2 составляет " + getGeneralhpTeamTwo + "HP" + "\n");
                                listtext.add(new File("Общее здоровье команды 2 составляет " + getGeneralhpTeamTwo + "HP"));
                                selectWarriorTeamOne.setPrivilegia(false);
                            }
                        }
                    } else {
                        System.out.print("Привилегированной группы в команде 1 нет" + "\n");
                        listtext.add(new File("Привилегированной группы в команде 1 нет"));
                        sizeArcher1t = TeamOne.getArcherList().size();
                        sizeWarrior1t = TeamOne.getWarriorList().size();
                        selectGroupTeamOne = rnd(0, 2);
                        if (selectGroupTeamOne == 1) {
                            if (sizeArcher1t > 0){
                                selectGroupTeamOne = 1;
                            } else selectGroupTeamOne = 2;
                        }

                        if (selectGroupTeamOne == 2){
                            if (sizeWarrior1t > 0){
                                selectGroupTeamOne = 2;
                            } else selectGroupTeamOne = rnd(0,1);
                        }

                        switch (selectGroupTeamOne) {
                            case 0:
                                if (TeamOne.getMage().isDeath() == false) {
                                    selectMageTeamOne = TeamOne.getMage();
                                    healthcharacterOne = selectMageTeamOne.getHealth();
                                    System.out.print("Выбран " + selectMageTeamOne.name + " из команды 1" + "со здоровьем" + healthcharacterOne + "HP" + "\n");
                                    listtext.add(new File("Выбран " + selectMageTeamOne.name + " из команды 1" + "со здоровьем" + healthcharacterOne + "HP"));
                                    selectActionMage1t = rnd(0, 1);
                                    if (selectActionMage1t == 0) {
                                        System.out.print(selectMageTeamOne.name + " из команды 1" + "  улучшает" + "\n");
                                        listtext.add(new File(selectMageTeamOne.name + " из команды 1" + "  улучшает"));
                                        ImproveOneTeam(TeamOne);
                                        break;
                                    } else
                                        System.out.print(selectMageTeamOne.name + " из команды 1" + " атакует магией" + "\n");
                                    listtext.add(new File(selectMageTeamOne.name + " из команды 1" + " атакует магией"));
                                    attackHP1t = selectMageTeamOne.attackMage;
                                    getTwoTeamHP(attackHP1t, TeamTwo);
                                    getGeneralhpTeamTwo = getGeneralhpTeamTwo - attackHP1t;
                                    System.out.print("Общее здоровье команды 2 составляет " + getGeneralhpTeamTwo + "HP" + "\n");
                                    listtext.add(new File("Общее здоровье команды 2 составляет " + getGeneralhpTeamTwo + "HP"));
                                    break;
                                } else selectGroupTeamOne = rnd(1,2);
                            case 1:
                                sizeArcher1t = TeamOne.getArcherList().size();
                                    selectArcher1t = rnd(0, sizeArcher1t-1);
                                    selectArcherTeamOne = TeamOne.getArcherList().get(selectArcher1t);
                                    healthcharacterOne = selectArcherTeamOne.getHealth();
                                    System.out.print("Выбран " + selectArcherTeamOne.name + " из команды 1" + "со здоровьем" + healthcharacterOne + "HP" + "\n");
                                    listtext.add(new File("Выбран " + selectArcherTeamOne.name + " из команды 1" + "со здоровьем" + healthcharacterOne + "HP"));
                                    selectActionArcher1t = rnd(0, 1);
                                    if (selectActionArcher1t == 0) {
                                        System.out.print(selectArcherTeamOne.name + " из команды 1" + " стреляет в" + "\n");
                                        listtext.add(new File(selectArcherTeamOne.name + " из команды 1" + " стреляет в"));
                                        attackHP1t = selectArcherTeamOne.attackHPShoot;
                                        getTwoTeamHP(attackHP1t, TeamTwo);
                                        getGeneralhpTeamTwo = getGeneralhpTeamTwo - attackHP1t;
                                        System.out.print("Общее здоровье команды 2 составляет " + getGeneralhpTeamTwo + "HP" + "\n");
                                        listtext.add(new File("Общее здоровье команды 2 составляет " + getGeneralhpTeamTwo + "HP"));
                                    } else {
                                        System.out.print(selectArcherTeamOne.name + " из команды 1" + " атакует" + "\n");
                                        listtext.add(new File(selectArcherTeamOne.name + " из команды 1" + " атакует"));
                                        attackHP1t = selectArcherTeamOne.attackHP;
                                        getTwoTeamHP(attackHP1t, TeamTwo);
                                        getGeneralhpTeamTwo = getGeneralhpTeamTwo - attackHP1t;
                                        System.out.print("Общее здоровье команды 2 составляет  " + getGeneralhpTeamTwo + "HP" + "\n");
                                        listtext.add(new File("Общее здоровье команды 2 составляет  " + getGeneralhpTeamTwo + "HP"));
                                    }
                                    break;
                            case 2:
                                sizeWarrior1t = TeamOne.getWarriorList().size();
                                    selectWarrior1t = rnd(0, sizeWarrior1t-1);
                                    selectWarriorTeamOne = TeamOne.getWarriorList().get(selectWarrior1t);
                                    healthcharacterOne = selectWarriorTeamOne.getHealth();
                                    System.out.print("Выбран " + selectWarriorTeamOne.name + " из команды 1" + "со здоровьем" + healthcharacterOne + "HP" + "\n");
                                    listtext.add(new File("Выбран " + selectWarriorTeamOne.name + " из команды 1" + "со здоровьем" + healthcharacterOne + "HP"));
                                    System.out.print(selectWarriorTeamOne.name + " из команды 1" + " атакует мечом" + "\n");
                                    listtext.add(new File(selectWarriorTeamOne.name + " из команды 1" + " атакует мечом"));
                                    attackHP1t = selectWarriorTeamOne.attackHP;
                                    getTwoTeamHP(attackHP1t, TeamTwo);
                                    getGeneralhpTeamTwo = getGeneralhpTeamTwo - attackHP1t;
                                    System.out.print("Общее здоровье команды 2 составляет  " + getGeneralhpTeamTwo + "HP" + "\n");
                                    listtext.add(new File("Общее здоровье команды 2 составляет  " + getGeneralhpTeamTwo + "HP"));
                                    break;
                        }

                    }
                } else {
                    System.out.print("Выбрана вторая команда с общим  здоровьем " + getGeneralhpTeamTwo+"HP"+"\n");
                    listtext.add(new File("Выбрана вторая команда с общим  здоровьем " + getGeneralhpTeamTwo+"HP"));

                    sizeArcher2t = TeamTwo.getArcherListTwo().size();
                    sizeWarrior2t = TeamTwo.getWarriorListTwo().size();

                    for (int i = 0; i <= sizeArcher2t-1; i++) {
                        if (TeamTwo.getArcherListTwo().get(i).isPrivilegia() == false) {
                            priznak2Team = false;

                        } else {
                            priznak2Team = true;
                            index2Team = i;
                        }
                    }

                    for (int i = 0; i <= sizeWarrior2t-1; i++) {
                        if (TeamTwo.getWarriorListTwo().get(i).isPrivilegia() == false) {
                            priznak12Team = false;

                        } else {
                            priznak12Team = true;
                            index12Team = i;
                        }
                    }

                    if ((priznak2Team == true) || (priznak12Team == true)) {
                        System.out.print("Привилегированная группа команде 2 есть" + "\n");
                        listtext.add(new File("Привилегированная группа команде 2 есть"));

                        if (priznak2Team == true) {
                            sizeArcher2t = TeamTwo.getArcherListTwo().size();
                            if (sizeArcher2t > 0) {
                                selectArcherTeamTwo = TeamTwo.getArcherListTwo().get(index2Team);
                                healthcharacterTwo = selectArcherTeamTwo.getHealth();
                                System.out.print("Выбран с привелегией " + selectArcherTeamTwo.name + " из команды 2 " + " со здоровьем " + healthcharacterTwo + "HP" + "\n");
                                listtext.add(new File("Выбран с привелегией " + selectArcherTeamTwo.name + " из команды 2 " + " со здоровьем " + healthcharacterTwo + "HP"));
                                selectActionArcher2t = rnd(0, 1);
                                if (selectActionArcher2t == 0) {
                                    System.out.print(selectArcherTeamTwo.name + " из команды 2" + " стреляет в" + "\n");
                                    listtext.add(new File(selectArcherTeamTwo.name + " из команды 2" + " стреляет в"));
                                    attackHP2t = selectArcherTeamTwo.attackHPShoot;
                                    getOneTeamHP(attackHP2t, TeamOne);
                                    generalhpTeamOne = generalhpTeamOne - attackHP2t;
                                    System.out.print("Общее здоровье команды 1 составляет  " + generalhpTeamOne + "\n");
                                    listtext.add(new File("Общее здоровье команды 1 составляет  " + generalhpTeamOne));
                                    selectArcherTeamTwo.setPrivilegia(false);
                                } else {
                                    System.out.print(selectArcherTeamTwo.name + " из команды 2" + " атакует в" + "\n");
                                    attackHP2t = selectArcherTeamTwo.attackHP;
                                    getOneTeamHP(attackHP1t, TeamOne);
                                    generalhpTeamOne = generalhpTeamOne - attackHP2t;
                                    System.out.print("Общее здоровье команды 1 составляет  " + generalhpTeamOne + "\n");
                                    listtext.add(new File("Общее здоровье команды 1 составляет  " + generalhpTeamOne));
                                    selectArcherTeamTwo.setPrivilegia(false);
                                }
                            }
                        }
                        if (priznak12Team == true) {
                            sizeWarrior2t = TeamTwo.getWarriorListTwo().size();
                            if (sizeWarrior2t > 0) {
                                selectWarriorTeamTwo = TeamTwo.getWarriorListTwo().get(index12Team);
                                healthcharacterTwo = selectWarriorTeamTwo.getHealth();
                                System.out.print("Выбран " + selectWarriorTeamTwo.name + " из команды 2" + " со здоровьем " + healthcharacterTwo + "HP" + "\n");
                                listtext.add(new File("Выбран " + selectWarriorTeamTwo.name + " из команды 2" + " со здоровьем " + healthcharacterTwo + "HP"));
                                System.out.print(selectWarriorTeamTwo.name + " из команды 2" + " атакует мечом" + "\n");
                                listtext.add(new File(selectWarriorTeamTwo.name + " из команды 2" + " атакует мечом"));
                                attackHP2t = selectWarriorTeamTwo.attackHP;
                                getOneTeamHP(attackHP1t, TeamOne);
                                generalhpTeamOne = generalhpTeamOne - attackHP1t;
                                System.out.print("Общее здоровье команды 1 составляет  " + generalhpTeamOne + "HP" + "\n");
                                listtext.add(new File("Общее здоровье команды 1 составляет " + generalhpTeamOne + "HP"));
                                selectWarriorTeamTwo.setPrivilegia(false);
                            }
                        }
                    } else {
                        System.out.print("Привелигированой группы в команде 2 нет" + "\n");
                        listtext.add(new File("Привилегированной группы в команде 2 нет"));
                        sizeArcher2t = TeamTwo.getArcherListTwo().size();
                        sizeWarrior2t = TeamTwo.getWarriorListTwo().size();
                        selectGroupTeamTwo = rnd(0, 2);
                        if (selectGroupTeamTwo == 1) {
                            if (sizeArcher2t > 0){
                                selectGroupTeamTwo = 1;
                            } else selectGroupTeamTwo = 2;
                        }

                        if (selectGroupTeamTwo == 2){
                            if (sizeWarrior2t > 0){
                                selectGroupTeamTwo = 2;
                            } else selectGroupTeamTwo = rnd(0,1);
                        }

                        switch (selectGroupTeamTwo) {
                            case 0:
                                if (TeamTwo.getMageTwo().isDeath() == false) {
                                    selectMageTeamTwo = TeamTwo.getMageTwo();
                                    healthcharacterTwo = selectMageTeamTwo.getHealth();
                                    System.out.print("Выбран " + selectMageTeamTwo.name + " из команды 2" + "со здоровьем" + healthcharacterTwo + "\n");
                                    listtext.add(new File("Выбран " + selectMageTeamTwo.name + " из команды 2" + "со здоровьем" + healthcharacterTwo));
                                    if (selectMageTeamTwo.getRase() == 2) {
                                        selectActionMage2t = rnd(0, 1);
                                        if (selectActionMage2t == 0) {
                                            System.out.print(selectMageTeamTwo.name + " из команды 2" + "  улучшает" + "\n");
                                            listtext.add(new File(selectMageTeamTwo.name + " из команды 2" + "  улучшает"));
                                            ImproveTwoTeam(TeamTwo);
                                            break;
                                        } else
                                            System.out.print(selectMageTeamTwo.name + " из команды 2" + " налаживает проклятья на" + "\n");
                                        listtext.add(new File(selectMageTeamTwo.name + " из команды 2" + "  налаживает проклятья на"));
                                        CurseTeam(TeamOne);
                                    }
                                    if (selectMageTeamTwo.getRase() == 3) {
                                        selectActionMage2t = rnd(0, 1);
                                        if (selectActionMage2t == 0) {
                                            System.out.print(selectMageTeamTwo.name + " из команды 2" + "  насылает недуг" + "\n");
                                            listtext.add(new File(selectMageTeamTwo.name + " из команды 2" + "  насылает недуг"));
                                            DiseaseOneTeamHP(TeamOne);
                                            break;
                                        } else
                                            System.out.print(selectMageTeamTwo.name + " из команды 2" + " атакует магией" + "\n");
                                        listtext.add(new File(selectMageTeamTwo.name + " из команды 2" + " атакует магией"));
                                        attackHP2t = selectMageTeamTwo.attackMage;
                                        getOneTeamHP(attackHP2t, TeamOne);
                                        generalhpTeamOne = generalhpTeamOne - attackHP2t;
                                        System.out.print("Общее здоровье команды 1 составляет  " + generalhpTeamOne + "\n");
                                        listtext.add(new File("Общее здоровье команды 1 составляет  " + generalhpTeamOne));
                                    }
                                    break;
                                } else selectGroupTeamTwo = rnd(1,2);
                            case 1:
                                sizeArcher2t = TeamTwo.getArcherListTwo().size();
                                selectArcher2t = rnd(0, sizeArcher2t-1);
                                selectArcherTeamTwo = TeamTwo.getArcherListTwo().get(selectArcher2t);
                                healthcharacterTwo = selectArcherTeamTwo.getHealth();
                                System.out.print("Выбран " + selectArcherTeamTwo.name + " из команды 2"+" со здоровьем"+healthcharacterTwo+"HP"+"\n");
                                listtext.add(new File("Выбран " + selectArcherTeamTwo.name + " из команды 2"+" со здоровьем"+healthcharacterTwo+"HP"));

                                selectActionArcher2t = rnd(0, 1);
                                if (selectActionArcher2t == 0) {
                                    System.out.print(selectArcherTeamTwo.name + " из команды 2" + " стреляет в" + "\n");
                                    listtext.add(new File(selectArcherTeamTwo.name + " из команды 2" + " стреляет в"));
                                    attackHP2t = selectArcherTeamTwo.attackHPShoot;
                                    getOneTeamHP(attackHP2t, TeamOne);
                                    generalhpTeamOne = generalhpTeamOne - attackHP2t;
                                    System.out.print("Общее здоровье 1 команды составляет  " + generalhpTeamOne +"HP"+ "\n");
                                    listtext.add(new File("Общее здоровье команды 1 составляет " + generalhpTeamOne +"HP"));
                                } else {
                                    System.out.print(selectArcherTeamTwo.name + " из команды 2" + " атакует" + "\n");
                                    listtext.add(new File(selectArcherTeamTwo.name + " из команды 2" + " атакует"));
                                    attackHP2t = selectArcherTeamTwo.attackHP;
                                    getOneTeamHP(attackHP1t, TeamOne);
                                    generalhpTeamOne = generalhpTeamOne - attackHP2t;
                                    System.out.print("Общее здоровье 1 команды составляет  " + generalhpTeamOne+"HP" + "\n");
                                    listtext.add(new File("Общее здоровье команды 1 составляет  " + generalhpTeamOne+"HP"));
                                }
                                break;
                            case 2:
                                sizeWarrior2t = TeamTwo.getWarriorListTwo().size();
                                selectWarrior2t = rnd(0, sizeWarrior2t-1);
                                selectWarriorTeamTwo = TeamTwo.getWarriorListTwo().get(selectWarrior2t);
                                healthcharacterTwo = selectWarriorTeamTwo.getHealth();
                                System.out.print("Выбран " + selectWarriorTeamTwo.name + " из команды 1"+"со здоровьем"+healthcharacterTwo+"HP"+ "\n");
                                listtext.add(new File("Выбран " + selectWarriorTeamTwo.name + " из команды 1"+"со здоровьем"+healthcharacterTwo+"HP"));

                                System.out.print(selectWarriorTeamTwo.name + " из команды 2" + " атакует мечом" + "\n");
                                listtext.add(new File(selectWarriorTeamTwo.name + " из команды 2" + " атакует мечом"));
                                attackHP2t = selectWarriorTeamTwo.attackHP;
                                getOneTeamHP(attackHP2t, TeamOne);
                                generalhpTeamOne = generalhpTeamOne - attackHP2t;
                                System.out.print("Общее здоровье 1 команды составляет  " + generalhpTeamOne + "\n");
                                listtext.add(new File("Общее здоровье команды 1 составляет  " + generalhpTeamOne+"HP"));
                                break;
                        }

                    }

                }


                //  generalhpTeamOne = generalhpTeamOne - rnd(10,20);
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //  System.out.print(generalhpTeamOne+ "\n");
                if (generalhpTeamOne <= 0) {
                   // System.out.print("Выграла команда 2" + "\n");
                    System.out.println((char) 27 + "[32mВыграла команда 2 " + (char) 27 + "[0m");
                    listtext.add(new File("Выграла команда 2"));
                    System.exit(0);
                }

                if (getGeneralhpTeamTwo <= 0) {
                   // System.out.print("Выграла команда 1" + "\n");
                    System.out.println((char) 27 + "[32mВыграла команда 1 " + (char) 27 + "[0m");
                    listtext.add(new File("Выграла команда 1"));
                    System.exit(0);
                }

                stroke++;

                try {
                    FileWriter writer = new FileWriter("D://LOG.txt");
                    for (File file : listtext) {
                        String textlog = file.getText();
                        writer.write(textlog + System.getProperty("line.separator"));
                    }
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }


        //   }
      /*  catch(IOException ex){

            System.out.println(ex.getMessage());
        } */
    }

    public static int rnd(int min, int max)
    {
        max -= min;
        return (int) (Math.random() * ++max) + min;
    }

    public float getTwoTeamHP(float param, GroupTwoBean TeamTwo){

      //  System.out.print("Выбираем вторую команду с общим  здоровьем " + getGeneralhpTeamTwo + "\n");
        sizeArcher2t = TeamTwo.getArcherListTwo().size();
        sizeWarrior2t = TeamTwo.getWarriorListTwo().size();
        selectGroupTeamTwo = rnd(0,2);
        if (selectGroupTeamTwo == 1) {
            if (sizeArcher2t > 0){
                selectGroupTeamTwo = 1;
            } else selectGroupTeamTwo = 2;
        }

        if (selectGroupTeamTwo == 2){
            if (sizeWarrior2t > 0){
                selectGroupTeamTwo = 2;
            } else selectGroupTeamTwo = rnd(0,1);
        }

        switch (selectGroupTeamTwo) {
            case 0:
                selectMageTeamTwo = TeamTwo.getMageTwo();
                if (selectMageTeamTwo.isDeath() == false) {
                    System.out.print(selectMageTeamTwo.name + " из команды 2" + "\n");
                    listtext.add(new File(selectMageTeamTwo.name + " из команды 2"));
                    selectMageTeamTwo.setHealth(selectMageTeamTwo.getHealth() - param);
                    hpcharacter = selectMageTeamTwo.getHealth();
                    System.out.print("Персонажу " + selectMageTeamTwo.name + " нанесен урон " + param + " здоровье персонажа составляет " + hpcharacter + "HP" + "\n");
                    listtext.add(new File("Персонажу " + selectMageTeamTwo.name + " нанесен урон " + param + " здоровье персонажа составляет " + hpcharacter + "HP"));
                    if (hpcharacter <= 0) {
                        System.out.println((char) 27 + "[31mПерсонаж " + stroke +" умер "+ (char) 27 + "[0m");
                       // System.out.print("Персонаж " + selectMageTeamTwo.name + " умер" + "\n");
                        listtext.add(new File("Персонаж " + selectMageTeamTwo.name + " умер"));
                        selectMageTeamTwo.setDeath(true);
                    }
                    break;
                } else selectGroupTeamOne = rnd(1,2);
            case 1:
                    sizeArcher2t = TeamTwo.getArcherListTwo().size();
                    selectArcher2t = rnd(0, sizeArcher2t-1);
                    selectArcherTeamTwo = TeamTwo.getArcherListTwo().get(selectArcher2t);
                    System.out.print(selectArcherTeamTwo.name + " из команды 2" + "\n");
                    listtext.add(new File(selectArcherTeamTwo.name + " из команды 2"));
                    selectArcherTeamTwo.setHealth(selectArcherTeamTwo.getHealth() - param);
                    hpcharacter = selectArcherTeamTwo.getHealth();
                    System.out.print("Персонажу " + selectArcherTeamTwo.name + " нанесен урон " + param + " здоровье персонажа составляет " + hpcharacter + "HP" + "\n");
                    listtext.add(new File("Персонажу " + selectArcherTeamTwo.name + " нанесен урон " + param + " здоровье персонажа составляет " + hpcharacter + "HP"));
                    if (hpcharacter <= 0) {
                        System.out.println((char) 27 + "[31mПерсонаж " + selectArcherTeamTwo.name +" умер"+ (char) 27 + "[0m");
                       // System.out.print("Персонаж " + selectArcherTeamTwo.name + " умер" + "\n");
                        listtext.add(new File("Персонаж " + selectArcherTeamTwo.name + " умер"));
                        TeamTwo.getArcherListTwo().remove(selectArcher2t);
                    }
                    break;
            case 2:
                    sizeWarrior2t = TeamTwo.getWarriorListTwo().size();
                    selectWarrior2t = rnd(0, sizeWarrior2t-1);
                    selectWarriorTeamTwo = TeamTwo.getWarriorListTwo().get(selectWarrior2t);
                    System.out.print(selectWarriorTeamTwo.name + " из команды 2" + "\n");
                    listtext.add(new File(selectWarriorTeamTwo.name + " из команды 2"));
                    selectWarriorTeamTwo.setHealth(selectWarriorTeamTwo.getHealth() - param);
                    hpcharacter = selectWarriorTeamTwo.getHealth();
                    System.out.print("Персонажу " + selectWarriorTeamTwo.name + " нанесен урон " + param + " здоровье персонажа составляет " + hpcharacter + "HP" + "\n");
                    listtext.add(new File("Персонажу " + selectWarriorTeamTwo.name + " нанесен урон " + param + " здоровье персонажа составляет " + hpcharacter + "HP"));
                    if (hpcharacter <= 0) {
                        System.out.println((char) 27 + "[31mПерсонаж " + selectWarriorTeamTwo.name +" умер"+ (char) 27 + "[0m");
                       // System.out.print("Персонаж " + selectWarriorTeamTwo.name + "умер" + "\n");
                        listtext.add(new File("Персонаж " + selectWarriorTeamTwo.name + " умер"));
                        TeamTwo.getWarriorListTwo().remove(selectWarrior2t);
                    }
                    break;
        }

      /*  if (hpcharacter < 0) {
            System.out.print("Персонажу " + selectWarriorTeamTwo.name + "умер"+"\n");
            TeamTwo.getWarriorListTwo().remove(selectWarrior2t);
        } */

        return hpcharacter;

    }

    public float ImproveOneTeam(GroupOneBean TeamOne){

      //  System.out.print("Улучшаем команду 1 с общим  здоровьем " + generalhpTeamOne + "\n");
      //  listtext.add(new File(selectMageTeamOne.name + " из команды 1" + "  улучшает"));
        sizeArcher1t = TeamOne.getArcherList().size();
        sizeWarrior1t = TeamOne.getWarriorList().size();
        selectGroupImprove = rnd(1,2);
        if (selectGroupImprove == 1){
            if (sizeArcher1t > 0){
                selectGroupImprove = 1;
            } else selectGroupImprove = 2;
        } else {
            if (sizeWarrior1t > 0){
                selectGroupImprove = 2;
            } else selectGroupImprove = 1;
        }
        switch (selectGroupImprove) {
            case 1:
                sizeArcher1t = TeamOne.getArcherList().size();
                    selectArcher1t = rnd(0, sizeArcher1t-1);
                    selectArcherTeamOne = TeamOne.getArcherList().get(selectArcher1t);
                    System.out.print("Персонажа " + selectArcherTeamOne.name + " из команды 1" + "\n");
                    listtext.add(new File("Персонажа " + selectArcherTeamOne.name + " из команды 1"));
                    selectArcherTeamOne.setAttackHP((float) (selectArcherTeamOne.getAttackHP() * 1.5));
                    selectArcherTeamOne.setAttackHPShoot((float) (selectArcherTeamOne.getAttackHPShoot() * 1.5));
                    selectArcherTeamOne.setPrivilegia(true);
                    improveattackArcher = selectArcherTeamOne.getAttackHP();
                    improveattackshootArcher = selectArcherTeamOne.getAttackHPShoot();
                    boolean priv = selectArcherTeamOne.isPrivilegia();
                    hpcharacter = selectArcherTeamOne.getHealth();
                    System.out.print("У персонажа " + selectArcherTeamOne.name + " улучшен наносимый урон в 1.5 раз" + " здоровье персонажа составляет " + hpcharacter + "HP" + "Сила удара составляет " + improveattackArcher + "HP" + "Сила стрельбы " + improveattackshootArcher + "HP" + "Привелегия " + priv + "\n");
                    listtext.add(new File("У персонажа " + selectArcherTeamOne.name + " улучшен наносимый урон в 1.5 раз" + " здоровье персонажа составляет " + hpcharacter + "HP" + "Сила удара составляет " + improveattackArcher + "HP" + "Сила стрельбы " + improveattackshootArcher + "HP" + "Привелегия " + priv));
                    break;
            case 2:
                sizeWarrior1t = TeamOne.getWarriorList().size();
                    selectWarrior1t = rnd(0, sizeWarrior1t-1);
                    selectWarriorTeamOne = TeamOne.getWarriorList().get(selectWarrior1t);
                    System.out.print("Персонажа " + selectWarriorTeamOne.name + " из команды 1" + "\n");
                    listtext.add(new File("Персонажа " + selectWarriorTeamOne.name + " из команды 1"));
                    selectWarriorTeamOne.setAttackHP((float) (selectWarriorTeamOne.getAttackHP() * 1.5));
                    selectWarriorTeamOne.setPrivilegia(true);
                    improveattackWarrior = selectWarriorTeamOne.getAttackHP();
                    boolean priv1 = selectWarriorTeamOne.isPrivilegia();
                    hpcharacter = selectWarriorTeamOne.getHealth();
                    System.out.print("У персонажа " + selectWarriorTeamOne.name + " улучшен наносимый урон в 1.5 раз" + " здоровье персонажа составляет " + hpcharacter + "HP" + " Сила удара составляет " + improveattackWarrior + "HP" + "Привелегия" + priv1 + "\n");
                    listtext.add(new File("У персонажа " + selectWarriorTeamOne.name + " улучшен наносимый урон в 1.5 раз" + " здоровье персонажа составляет " + hpcharacter + "HP" + " Сила удара составляет " + improveattackWarrior + "HP" + "Привелегия" + priv1));
                    break;
        }

        return hpcharacter;
    }

    public float getOneTeamHP(float param, GroupOneBean TeamOne){

        //System.out.print("Выбираем первую команду с общим  здоровьем " + generalhpTeamOne + "\n");
        sizeArcher1t = TeamOne.getArcherList().size();
        sizeWarrior1t = TeamOne.getWarriorList().size();
        selectGroupTeamOne = rnd(0,2);
        if (selectGroupTeamOne == 1) {
            if (sizeArcher1t > 0){
                selectGroupTeamOne = 1;
            } else selectGroupTeamOne = 2;
        }

        if (selectGroupTeamOne == 2){
            if (sizeWarrior1t > 0){
                selectGroupTeamOne = 2;
            } else selectGroupTeamOne = rnd(0,1);
        }

        switch (selectGroupTeamOne) {
            case 0:
                selectMageTeamOne = TeamOne.getMage();
                if (selectMageTeamOne.isDeath() == false) {
                    System.out.print(selectMageTeamOne.name + " из команды 1" + "\n");
                    listtext.add(new File(selectMageTeamOne.name + " из команды 1"));
                    selectMageTeamOne.setHealth(selectMageTeamOne.getHealth() - param);
                    hpcharacter = selectMageTeamOne.getHealth();
                    System.out.print("Персонажу " + selectMageTeamOne.name + " нанесен урон " + param + "здоровье персонажа составляет" + hpcharacter + "HP" + "\n");
                    listtext.add(new File("Персонажу " + selectMageTeamOne.name + " нанесен урон " + param + "здоровье персонажа составляет" + hpcharacter + "HP"));
                    if (hpcharacter < 0) {
                        System.out.println((char) 27 + "[31mПерсонаж " + selectMageTeamOne.name +" умер"+ (char) 27 + "[0m");
                       // System.out.print("Персонаж " + selectMageTeamOne.name + "умер" + "\n");
                        listtext.add(new File("Персонаж " + selectMageTeamOne.name + " умер"));
                    }
                    break;
                } else selectGroupTeamOne = rnd(1,2);
            case 1:
                sizeArcher1t = TeamOne.getArcherList().size();
                selectArcher1t = rnd(0,sizeArcher1t-1);
                selectArcherTeamOne  = TeamOne.getArcherList().get(selectArcher1t);
                System.out.print(selectArcherTeamOne.name +" из команды 1"+  "\n");
                listtext.add(new File(selectArcherTeamOne.name +" из команды 1"));
                selectArcherTeamOne.setHealth(selectArcherTeamOne.getHealth() - param);
                hpcharacter = selectArcherTeamOne.getHealth();
                System.out.print("Персонажу " + selectArcherTeamOne.name +" нанесен урон"+param+"здоровье персонажа составляет"+hpcharacter+"HP"+"\n");
                listtext.add(new File("Персонажу " + selectArcherTeamOne.name +" нанесен урон"+param+"здоровье персонажа составляет"+hpcharacter+"HP"));
                if (hpcharacter < 0) {
                    System.out.println((char) 27 + "[31mПерсонаж " + selectArcherTeamOne.name +" умер"+ (char) 27 + "[0m");
                   // System.out.print("Персонаж " + selectArcherTeamOne.name + "умер"+"\n");
                    listtext.add(new File("Персонаж " + selectArcherTeamOne.name + " умер"));
                    TeamOne.getArcherList().remove(selectArcher1t);
                }
                break;
            case 2:
                sizeWarrior1t = TeamOne.getWarriorList().size();
                selectWarrior1t = rnd(0,sizeWarrior1t-1);
                selectWarriorTeamOne = TeamOne.getWarriorList().get(selectWarrior1t);
                System.out.print("Выбран " + selectWarriorTeamOne.name +" из команды 1"+  "\n");
                listtext.add(new File(selectWarriorTeamOne.name +" из команды 1"));
                selectWarriorTeamOne.setHealth(selectWarriorTeamOne.getHealth() - param);
                hpcharacter = selectWarriorTeamOne.getHealth();
                System.out.print("Персонажу " + selectWarriorTeamOne.name +" нанесен урон"+param+"здоровье персонажа составляет"+hpcharacter+"HP"+  "\n");
                listtext.add(new File("Персонажу " + selectWarriorTeamOne.name +" нанесен урон "+param+" здоровье персонажа составляет "+hpcharacter+"HP"));
                if (hpcharacter < 0) {
                    System.out.println((char) 27 + "[31mПерсонаж " + selectWarriorTeamOne.name +" умер"+ (char) 27 + "[0m");
                   // System.out.print("Персонаж " + selectWarriorTeamOne.name + "умер"+"\n");
                    listtext.add(new File("Персонаж " + selectWarriorTeamOne.name + " умер"));
                    TeamOne.getWarriorList().remove(selectWarrior1t);
                }
                break;
        }



        return hpcharacter;

    }

    public float ImproveTwoTeam(GroupTwoBean TeamTwo){

      //  System.out.print("Улучшаем команду 2 с общим  здоровьем " + getGeneralhpTeamTwo + "\n");
        sizeArcher1t = TeamTwo.getArcherListTwo().size();
        sizeWarrior1t = TeamTwo.getWarriorListTwo().size();
        selectGroupImprove = rnd(1,2);

        if (selectGroupImprove == 1){
            if (sizeArcher2t > 0){
                selectGroupImprove = 1;
            } else selectGroupImprove = 2;
        } else {
            if (sizeWarrior2t > 0){
                selectGroupImprove = 2;
            } else selectGroupImprove = 1;
        }

        switch (selectGroupImprove) {
            case 1:
                sizeArcher2t = TeamTwo.getArcherListTwo().size();
                selectArcher2t = rnd(0,sizeArcher2t-1);
                selectArcherTeamTwo  = TeamTwo.getArcherListTwo().get(selectArcher2t);
                System.out.print("Персонажа " + selectArcherTeamTwo.name +" из команды 2"+  "\n");
                listtext.add(new File("Персонажа " + selectArcherTeamTwo.name +" из команды 2"));
                selectArcherTeamTwo.setAttackHP((float) (selectArcherTeamTwo.getAttackHP()*1.5));
                selectArcherTeamTwo.setAttackHPShoot((float) (selectArcherTeamTwo.getAttackHPShoot()*1.5));
                selectArcherTeamTwo.setPrivilegia(true);
                improveattackArcher = selectArcherTeamTwo.getAttackHP();
                improveattackshootArcher = selectArcherTeamTwo.getAttackHPShoot();
                boolean priv = selectArcherTeamTwo.isPrivilegia();
                hpcharacter = selectArcherTeamTwo.getHealth();
                System.out.print("У персонажа " + selectArcherTeamTwo.name +" улучшен наносимый урон в 1.5 раз"+" здоровье персонажа составляет "+hpcharacter+"HP"+"Сила удара составляет "+improveattackArcher+"HP"+"Сила стрельбы "+improveattackshootArcher+"HP"+"Привелегия "+priv+"\n");
                listtext.add(new File("У персонажа " + selectArcherTeamTwo.name +" улучшен наносимый урон в 1.5 раз"+" здоровье персонажа составляет "+hpcharacter+"HP"+"Сила удара составляет "+improveattackArcher+"HP"+"Сила стрельбы "+improveattackshootArcher+"HP"+"Привелегия "+priv));
                break;
            case 2:
                sizeWarrior2t = TeamTwo.getWarriorListTwo().size();
                selectWarrior2t = rnd(0,sizeWarrior2t-1);
                selectWarriorTeamTwo = TeamTwo.getWarriorListTwo().get(selectWarrior2t);
                System.out.print("Персонажа " + selectWarriorTeamTwo.name +" из команды 2"+  "\n");
                listtext.add(new File("Персонажа " + selectWarriorTeamTwo.name +" из команды 2"));
                selectWarriorTeamTwo.setAttackHP((float) (selectWarriorTeamTwo.getAttackHP()*1.5));
                selectWarriorTeamTwo.setPrivilegia(true);
                improveattackWarrior = selectWarriorTeamTwo.getAttackHP();
                boolean priv1 = selectWarriorTeamTwo.isPrivilegia();
                hpcharacter = selectWarriorTeamTwo.getHealth();
                System.out.print("У персонажа " + selectWarriorTeamTwo.name +" улучшен наносимый урон в 1.5 раз"+" здоровье персонажа составляет "+hpcharacter+"HP"+" Сила удара составляет "+improveattackWarrior+"HP"+"Привелегия"+priv1+"\n");
                listtext.add(new File("У персонажа " + selectWarriorTeamTwo.name +" улучшен наносимый урон в 1.5 раз"+" здоровье персонажа составляет "+hpcharacter+"HP"+" Сила удара составляет "+improveattackWarrior+"HP"+"Привелегия"+priv1));
                break;
        }

        return hpcharacter;

    }

    public float CurseTeam(GroupOneBean TeamOne){

      //  System.out.print("Выбираем первую команду с общим  здоровьем " + generalhpTeamOne + "\n");

        for (int i = 0; i <= 2; i++) {
            if (TeamOne.getArcherList().get(i).isPrivilegia() == false) {
                priznak = false;

            } else {
                priznak = true;
                index = i;
            }
        }

        for (int i = 0; i <= 3; i++) {
            if (TeamOne.getWarriorList().get(i).isPrivilegia() == false) {
                priznak1 = false;

            } else {
                priznak1 = true;
                index1 = i;
            }
        }

if ((priznak == true)||(priznak1 == true)) {
    if (priznak == true) {
        sizeArcher1t = TeamOne.getArcherList().size();
        if (sizeArcher1t > 0) {
            selectArcherTeamOne = TeamOne.getArcherList().get(index);
            //  System.out.print("Выбран " + selectArcherTeamOne.name +" из команды 1"+  "\n");
            selectArcherTeamOne.setPrivilegia(false);
            System.out.print("Персонажа " + selectArcherTeamOne.name + " из команды 1" + " убрана привелегия" + "\n");
            listtext.add(new File("Персонажа " + selectArcherTeamOne.name + " из команды 1" + " убрана привелегия"));
        }
    }

    if (priznak1 == true) {
        sizeWarrior1t = TeamOne.getWarriorList().size();
        if (sizeWarrior1t > 0) {
            selectWarriorTeamOne = TeamOne.getWarriorList().get(index1);
            // System.out.print("Выбран " + selectWarriorTeamOne.name +" из команды 1"+  "\n");
            selectWarriorTeamOne.setPrivilegia(false);
            System.out.print("Персонажа " + selectWarriorTeamOne.name + " из команды 1" + " убрана привелегия" + "\n");
            listtext.add(new File("Персонажа " + selectWarriorTeamOne.name + " из команды 1" + " убрана привелегия"));
        }
    }
        }

        return hpcharacter;

    }

    public float DiseaseOneTeamHP(GroupOneBean TeamOne){

       // System.out.print("Выбираем первую команду с общим  здоровьем " + generalhpTeamOne + "\n");
        sizeArcher1t = TeamOne.getArcherList().size();
        sizeWarrior1t = TeamOne.getWarriorList().size();

        selectGroupTeamOne = rnd(0, 2);
        if (selectGroupTeamOne == 1) {
            if (sizeArcher1t > 0){
                selectGroupTeamOne = 1;
            } else selectGroupTeamOne = 2;
        }

        if (selectGroupTeamOne == 2){
            if (sizeWarrior1t > 0){
                selectGroupTeamOne = 2;
            } else selectGroupTeamOne = rnd(0,1);
        }

        switch (selectGroupTeamOne) {
            case 0:
                if (TeamOne.getMage().isDeath() == false) {
                    selectMageTeamOne = TeamOne.getMage();
                    //  System.out.print("Выбран " + selectMageTeamOne.name +" из команды 1"+  "\n");
                    selectMageTeamOne.setAttackMage(selectMageTeamOne.getAttackMage() / 2);
                    newattackMage = selectMageTeamOne.attackMage;
                    System.out.print("На персонажа " + selectMageTeamOne.name + " у персонажа уменьшены силы на 50% " + " новая атака составляет " + newattackMage + "HP" + "\n");
                    listtext.add(new File("На персонажа " + selectMageTeamOne.name + " у персонажа уменьшены силы на 50% " + " новая атака составляет " + newattackMage + "HP"));
                    break;
                } else selectGroupTeamOne = rnd(1,2);
            case 1:
                sizeArcher1t = TeamOne.getArcherList().size();
                selectArcher1t = rnd(0,sizeArcher1t-1);
                selectArcherTeamOne  = TeamOne.getArcherList().get(selectArcher1t);
               // System.out.print("Выбран " + selectArcherTeamOne.name +" из команды 1"+  "\n");
                selectArcherTeamOne.setAttackHP(selectArcherTeamOne.getAttackHP()/2);
                selectArcherTeamOne.setAttackHPShoot(selectArcherTeamOne.attackHPShoot/2);
                newattackArcher = selectArcherTeamOne.getAttackHP();
                newattackshootArcher = selectArcherTeamOne.getAttackHPShoot();
                System.out.print("На персонажа " + selectArcherTeamOne.name +" у персонажа уменьшены силы на 50% "+"новая атака составляет "+newattackArcher+"HP"+"новая стрельба из лука составляет"+newattackshootArcher+"HP"+"\n");
                listtext.add(new File("На персонажа " + selectArcherTeamOne.name +" у персонажа уменьшены силы на 50% "+"новая атака составляет "+newattackArcher+"HP"+"новая стрельба из лука составляет"+newattackshootArcher+"HP"));
                break;
            case 2:
                sizeWarrior1t = TeamOne.getWarriorList().size();
                selectWarrior1t = rnd(0,sizeWarrior1t-1);
                selectWarriorTeamOne = TeamOne.getWarriorList().get(selectWarrior1t);
                System.out.print("Выбран " + selectWarriorTeamOne.name +" из команды 2"+  "\n");
                selectWarriorTeamOne.setAttackHP(selectWarriorTeamOne.getAttackHP()/2);
                newattackWarrior = selectWarriorTeamOne.getAttackHP();
                System.out.print("На персонажа " + selectWarriorTeamOne.name +" у персонажа уменьшены силы на 50% "+"новая атака составляет "+newattackWarrior+"HP"+"\n");
                listtext.add(new File("На персонажа " + selectWarriorTeamOne.name +" у персонажа уменьшены силы на 50% "+"новая атака составляет "+newattackWarrior+"HP"));
                break;
        }

        return hpcharacter;

    }


    public int getTypecomandOne() {
        return typecomandOne;
    }

    public void setTypecomandOne(int typecomandOne) {
        this.typecomandOne = typecomandOne;
    }

    public float getGeneralhp() {
        return generalhpTeamOne;
    }

    public void setGeneralhp(float generalhp) {
        this.generalhpTeamOne = generalhp;
    }

}
