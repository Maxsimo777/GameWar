package com.company.rase;

import com.company.rase.Entity.Archer;
import com.company.rase.Entity.Mage;
import com.company.rase.Entity.Warrior;


import java.lang.*;
import java.util.concurrent.TimeUnit;

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


    public void CreateGame()  {

        GroupOneBean TeamOne = new GroupOneBean();
        TeamOne.CreateFirstTeam(typecomandOne);
        System.out.print(typecomandOne+ "\n");
        if (typecomandOne == 0) {
            System.out.print("Первая команда ельфов с общим  здоровьем " + generalhpTeamOne + "\n");
        } else
        {
            System.out.print("Первая команда людей с общим  здоровьем " + generalhpTeamOne+ "\n");
        }

   //     System.out.print(TeamOne.CreateArcher(typecomandOne).get(2).getName() + "\n");
   //     System.out.print(TeamOne.getArcherList().get(2).getName() + "\n");



        GroupTwoBean TeamTwo = new GroupTwoBean();
        TeamTwo.CreateTwoTeam(typecomandTwo);
        System.out.print(typecomandTwo+ "\n");
        if (typecomandTwo == 2) {
            System.out.print("Вторая команда орков с общим  здоровьем " + getGeneralhpTeamTwo + "\n");
        } else {
            System.out.print("Вторая команда нежити с общим  здоровьем " + getGeneralhpTeamTwo + "\n");
        }

       stroke = 1;
       while ((generalhpTeamOne >= 0) || (getGeneralhpTeamTwo < 0)){

           System.out.println((char) 27 + "[31mХод № " +stroke+ (char)27 + "[0m");
           System.out.println("\n");

           selectteam = rnd(0,1);

            if (selectteam == 0) {
                System.out.print("Выбрана первая команда с общим  здоровьем " + generalhpTeamOne + "\n");

                for (int i = 0; i <= 2; i++){
                    if (TeamOne.getArcherList().get(i).isPrivilegia() == false) {
                        priznak = false;

                    } else {
                        priznak = true;
                        index = i;
                    }
                }

                for (int i = 0; i <= 3; i++){
                    if (TeamOne.getWarriorList().get(i).isPrivilegia() == false) {
                        priznak1 = false;

                    } else {
                        priznak1 = true;
                        index1 = i;
                    }
                }

                if ((priznak == true)||(priznak1 == true)) {
                    System.out.print("Привелигированая группа есть" + "\n");
                    if (priznak == true){
                        selectArcherTeamOne = TeamOne.getArcherList().get(index);
                        System.out.print("Выбран с привелегией " + selectArcherTeamOne.name +" из команды 1"+  "\n");
                        selectActionArcher1t = rnd(0,1);
                        if (selectActionArcher1t == 0){
                            System.out.print(selectArcherTeamOne.name +" из команды 1"+ " стреляет в"+  "\n");
                            attackHP1t = selectArcherTeamOne.attackHPShoot;
                            getTwoTeamHP(attackHP1t, TeamTwo);
                            getGeneralhpTeamTwo = getGeneralhpTeamTwo - attackHP1t;
                            System.out.print("Общее здоровье 2 команды составляет  " + getGeneralhpTeamTwo + "\n");
                        } else {
                            System.out.print(selectArcherTeamOne.name +" из команды 1"+ " атакует в"+  "\n");
                            attackHP1t = selectArcherTeamOne.attackHP;
                            getTwoTeamHP(attackHP1t, TeamTwo);
                            getGeneralhpTeamTwo = getGeneralhpTeamTwo - attackHP1t;
                            System.out.print("Общее здоровье 2 команды составляет  " + getGeneralhpTeamTwo + "\n");
                        }
                    }
                    if (priznak1 == true) {
                        selectWarriorTeamOne = TeamOne.getWarriorList().get(index1);
                        System.out.print("Выбран " + selectWarriorTeamOne.name +" из команды 1"+  "\n");
                        System.out.print(selectWarriorTeamOne.name +" из команды 1"+ " атакует мечом"+  "\n");
                        attackHP1t = selectWarriorTeamOne.attackHP;
                        getTwoTeamHP(attackHP1t,TeamTwo);
                        getGeneralhpTeamTwo = getGeneralhpTeamTwo - attackHP1t;
                        System.out.print("Общее здоровье 2 команды составляет  " + getGeneralhpTeamTwo + "\n");
                    }
                } else {
                    System.out.print("Привелигированой группы нет" + "\n");
                    selectGroupTeamOne = rnd(0,2);
                    switch (selectGroupTeamOne) {
                        case 0:
                            selectMageTeamOne = TeamOne.getMage();
                            System.out.print("Выбран " + selectMageTeamOne.name +" из команды 1"+  "\n");
                            selectActionMage1t = rnd(0,1);
                            if (selectActionMage1t == 0){
                                System.out.print(selectMageTeamOne.name +" из команды 1"+ "  улучашает"+  "\n");
                                ImproveOneTeam(TeamOne);
                                break;
                            } else
                                System.out.print(selectMageTeamOne.name +" из команды 1"+ " атакует магией"+  "\n");
                                attackHP1t = selectMageTeamOne.attackMage;
                                getTwoTeamHP(attackHP1t, TeamTwo);
                                getGeneralhpTeamTwo = getGeneralhpTeamTwo - attackHP1t;
                                System.out.print("Общее здоровье 2 команды составляет  " + getGeneralhpTeamTwo + "\n");
                            break;
                        case 1:
                            selectArcher1t = rnd(0,2);
                            selectArcherTeamOne  = TeamOne.getArcherList().get(selectArcher1t);
                            System.out.print("Выбран " + selectArcherTeamOne.name +" из команды 1"+  "\n");
                            selectActionArcher1t = rnd(0,1);
                            if (selectActionArcher1t == 0){
                                System.out.print(selectArcherTeamOne.name +" из команды 1"+ " стреляет в"+  "\n");
                                attackHP1t = selectArcherTeamOne.attackHPShoot;
                                getTwoTeamHP(attackHP1t, TeamTwo);
                                getGeneralhpTeamTwo = getGeneralhpTeamTwo - attackHP1t;
                                System.out.print("Общее здоровье 2 команды составляет  " + getGeneralhpTeamTwo + "\n");
                            } else {
                                System.out.print(selectArcherTeamOne.name +" из команды 1"+ " атакует в"+  "\n");
                                attackHP1t = selectArcherTeamOne.attackHP;
                                getTwoTeamHP(attackHP1t, TeamTwo);
                                getGeneralhpTeamTwo = getGeneralhpTeamTwo - attackHP1t;
                                System.out.print("Общее здоровье 2 команды составляет  " + getGeneralhpTeamTwo + "\n");
                            }
                            break;
                        case 2:
                            selectWarrior1t = rnd(0,3);
                            selectWarriorTeamOne = TeamOne.getWarriorList().get(selectWarrior1t);
                            System.out.print("Выбран " + selectWarriorTeamOne.name +" из команды 1"+  "\n");
                            System.out.print(selectWarriorTeamOne.name +" из команды 1"+ " атакует мечом"+  "\n");
                            attackHP1t = selectWarriorTeamOne.attackHP;
                            getTwoTeamHP(attackHP1t,TeamTwo);
                            getGeneralhpTeamTwo = getGeneralhpTeamTwo - attackHP1t;
                            System.out.print("Общее здоровье 2 команды составляет  " + getGeneralhpTeamTwo + "\n");
                            break;
                    }

                }
            }

            else {
                System.out.print("Выбрана вторая команда с общим  здоровьем " + getGeneralhpTeamTwo + "\n");

                for (int i = 0; i <= 2; i++){
                    if (TeamTwo.getArcherListTwo().get(i).isPrivilegia() == false) {
                        priznak2Team = false;

                    } else {
                        priznak2Team = true;
                        index2Team = i;
                    }
                }

                for (int i = 0; i <= 3; i++){
                    if (TeamOne.getWarriorList().get(i).isPrivilegia() == false) {
                        priznak12Team = false;

                    } else {
                        priznak12Team = true;
                        index12Team = i;
                    }
                }

                if ((priznak2Team == true)||(priznak12Team == true)) {
                    System.out.print("Привелигированая группа есть в команде 2" + "\n");
                    if (priznak2Team == true){
                        selectArcherTeamTwo = TeamTwo.getArcherListTwo().get(index2Team);
                        System.out.print("Выбран с привелегией " + selectArcherTeamTwo.name +" из команды 2"+  "\n");
                        selectActionArcher2t = rnd(0,1);
                        if (selectActionArcher2t == 0){
                            System.out.print(selectArcherTeamTwo.name +" из команды 2"+ " стреляет в"+  "\n");
                            attackHP2t = selectArcherTeamTwo.attackHPShoot;
                            getOneTeamHP(attackHP2t, TeamOne);
                            generalhpTeamOne = generalhpTeamOne - attackHP2t;
                            System.out.print("Общее здоровье 1 команды составляет  " + generalhpTeamOne + "\n");
                        } else {
                            System.out.print(selectArcherTeamTwo.name +" из команды 2"+ " атакует в"+  "\n");
                            attackHP2t = selectArcherTeamTwo.attackHP;
                            getOneTeamHP(attackHP1t, TeamOne);
                            generalhpTeamOne = generalhpTeamOne - attackHP2t;
                            System.out.print("Общее здоровье 1 команды составляет  " + getGeneralhpTeamTwo + "\n");
                        }
                    }
                    if (priznak12Team == true) {
                        selectWarriorTeamTwo = TeamTwo.getWarriorListTwo().get(index12Team);
                        System.out.print("Выбран " + selectWarriorTeamTwo.name +" из команды 2"+  "\n");
                        System.out.print(selectWarriorTeamTwo.name +" из команды 2"+ " атакует мечом"+  "\n");
                        attackHP2t = selectWarriorTeamTwo.attackHP;
                        getOneTeamHP(attackHP1t,TeamOne);
                        generalhpTeamOne = generalhpTeamOne - attackHP1t;
                        System.out.print("Общее здоровье 1 команды составляет  " + generalhpTeamOne + "\n");
                    }
                } else {
                    System.out.print("Привелигированой группы нет" + "\n");
                    selectGroupTeamTwo = rnd(0,2);
                    switch (selectGroupTeamTwo) {
                        case 0:
                            selectMageTeamTwo = TeamTwo.getMageTwo();
                            System.out.print("Выбран " + selectMageTeamTwo.name +" из команды 2"+  "\n");
                            if (selectMageTeamTwo.getRase() == 2) {
                                selectActionMage2t = rnd(0, 1);
                                if (selectActionMage2t == 0) {
                                    System.out.print(selectMageTeamTwo.name + " из команды 2" + "  улучашает" + "\n");
                                    ImproveTwoTeam(TeamTwo);
                                    break;
                                } else
                                    System.out.print(selectMageTeamTwo.name + " из команды 2" + " налаживает проклятье" + "\n");
                                    CurseTeam(TeamOne);
                            }
                            if (selectMageTeamTwo.getRase() == 3){
                                selectActionMage2t = rnd(0, 1);
                                if (selectActionMage2t == 0) {
                                    System.out.print(selectMageTeamTwo.name + " из команды 2" + "  насылает недуг" + "\n");
                                    DiseaseOneTeamHP(TeamOne);
                                    break;
                                } else
                                    System.out.print(selectMageTeamTwo.name + " из команды 2" + " атакует магией" + "\n");
                                attackHP2t = selectMageTeamTwo.attackMage;
                                getOneTeamHP(attackHP2t, TeamOne);
                                generalhpTeamOne = generalhpTeamOne - attackHP2t;
                                System.out.print("Общее здоровье 1 команды составляет  " + generalhpTeamOne + "\n");
                            }
                            break;
                        case 1:
                            selectArcher2t = rnd(0,2);
                            selectArcherTeamTwo  = TeamTwo.getArcherListTwo().get(selectArcher2t);
                            System.out.print("Выбран " + selectArcherTeamTwo.name +" из команды 2"+  "\n");
                            selectActionArcher2t = rnd(0,1);
                            if (selectActionArcher2t == 0){
                                System.out.print(selectArcherTeamTwo.name +" из команды 2"+ " стреляет в"+  "\n");
                                attackHP2t = selectArcherTeamTwo.attackHPShoot;
                                getOneTeamHP(attackHP2t, TeamOne);
                                generalhpTeamOne = generalhpTeamOne - attackHP2t;
                                System.out.print("Общее здоровье 1 команды составляет  " + generalhpTeamOne + "\n");
                            } else {
                                System.out.print(selectArcherTeamTwo.name +" из команды 2"+ " атакует в"+  "\n");
                                attackHP2t = selectArcherTeamTwo.attackHP;
                                getOneTeamHP(attackHP1t, TeamOne);
                                generalhpTeamOne = generalhpTeamOne - attackHP2t;
                                System.out.print("Общее здоровье 1 команды составляет  " + generalhpTeamOne + "\n");
                            }
                            break;
                        case 2:
                            selectWarrior2t = rnd(0,3);
                            selectWarriorTeamTwo = TeamTwo.getWarriorListTwo().get(selectWarrior2t);
                            System.out.print("Выбран " + selectWarriorTeamTwo.name +" из команды 2"+  "\n");
                            System.out.print(selectWarriorTeamTwo.name +" из команды 2"+ " атакует мечом"+  "\n");
                            attackHP2t = selectWarriorTeamTwo.attackHP;
                            getOneTeamHP(attackHP2t,TeamOne);
                            generalhpTeamOne = generalhpTeamOne - attackHP2t;
                            System.out.print("Общее здоровье 1 команды составляет  " + generalhpTeamOne + "\n");
                            break;
                    }

                }

            }


          //  generalhpTeamOne = generalhpTeamOne - rnd(10,20);
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
          //  System.out.print(generalhpTeamOne+ "\n");
           if (generalhpTeamOne < 0) {
               System.out.print("Выграла команда 2"+ "\n");
               System.exit(0);
           }

           if (getGeneralhpTeamTwo < 0){
               System.out.print("Выграла команда 1"+ "\n");
               System.exit(0);
           }

           stroke++;
        }

    }

    public static int rnd(int min, int max)
    {
        max -= min;
        return (int) (Math.random() * ++max) + min;
    }

    public float getTwoTeamHP(float param, GroupTwoBean TeamTwo){

        System.out.print("Выбираем вторую команду с общим  здоровьем " + getGeneralhpTeamTwo + "\n");
        selectGroupTeamTwo = rnd(0,2);
        switch (selectGroupTeamTwo) {
            case 0:
                selectMageTeamTwo = TeamTwo.getMageTwo();
                System.out.print("Выбран " + selectMageTeamTwo.name +" из команды 2"+  "\n");
                selectMageTeamTwo.setHealth(selectMageTeamTwo.getHealth() - param);
                hpcharacter = selectMageTeamTwo.getHealth();
                System.out.print("Персонажу " + selectMageTeamTwo.name +" нанесен урон"+param+"здоровье персонажа составляет"+hpcharacter+  "\n");
                if (hpcharacter < 0) {
                    System.out.print("Персонаж " + selectWarriorTeamTwo.name + "умер"+"\n");
                }
                break;
            case 1:
                selectArcher2t = rnd(0,2);
                selectArcherTeamTwo  = TeamTwo.getArcherListTwo().get(selectArcher2t);
                System.out.print("Выбран " + selectArcherTeamTwo.name +" из команды 2"+  "\n");
                selectArcherTeamTwo.setHealth(selectArcherTeamTwo.getHealth() - param);
                hpcharacter = selectArcherTeamTwo.getHealth();
                System.out.print("Персонажу " + selectArcherTeamTwo.name +" нанесен урон"+param+"здоровье персонажа составляет"+hpcharacter+  "\n");
                if (hpcharacter < 0) {
                    System.out.print("Персонаж " + selectWarriorTeamTwo.name + "умер"+"\n");
                    TeamTwo.getArcherListTwo().remove(selectArcher1t);
                }
                break;
            case 2:
                selectWarrior2t = rnd(0,3);
                selectWarriorTeamTwo = TeamTwo.getWarriorListTwo().get(selectWarrior2t);
                System.out.print("Выбран " + selectWarriorTeamTwo.name +" из команды 2"+  "\n");
                selectWarriorTeamTwo.setHealth(selectWarriorTeamTwo.getHealth() - param);
                hpcharacter = selectWarriorTeamTwo.getHealth();
                System.out.print("Персонажу " + selectWarriorTeamTwo.name +" нанесен урон"+param+"здоровье персонажа составляет"+hpcharacter+  "\n");
                if (hpcharacter < 0) {
                    System.out.print("Персонаж " + selectWarriorTeamOne.name + "умер"+"\n");
                    TeamTwo.getWarriorListTwo().remove(selectWarrior1t);
                }
                break;
        }

        if (hpcharacter < 0) {
            System.out.print("Персонажу " + selectWarriorTeamTwo.name + "умер"+"\n");
            TeamTwo.getWarriorListTwo().remove(selectWarrior2t);
        }

        return hpcharacter;

    }

    public float ImproveOneTeam(GroupOneBean TeamOne){

        System.out.print("Улучшаем команду 1 с общим  здоровьем " + generalhpTeamOne + "\n");
        selectGroupImprove = rnd(1,2);
        switch (selectGroupImprove) {
            case 1:
                selectArcher1t = rnd(0,2);
                selectArcherTeamOne  = TeamOne.getArcherList().get(selectArcher1t);
                System.out.print("Выбран для улучшения персонаж " + selectArcherTeamOne.name +" из команды 1"+  "\n");
                selectArcherTeamOne.setAttackHP((float) (selectArcherTeamOne.getAttackHP()*1.5));
                selectArcherTeamOne.setAttackHPShoot((float) (selectArcherTeamOne.getAttackHPShoot()*1.5));
                selectArcherTeamOne.setPrivilegia(true);
                improveattackArcher = selectArcherTeamOne.getAttackHP();
                improveattackshootArcher = selectArcherTeamOne.getAttackHPShoot();
                boolean priv = selectArcherTeamOne.isPrivilegia();
                hpcharacter = selectArcherTeamOne.getHealth();
                System.out.print("Персонажу " + selectArcherTeamOne.name +" улучшен в 1,5 и привелегирован"+"здоровье персонажа составляет"+hpcharacter+"Сила удара составляет"+improveattackArcher+"Сила стрельбы"+improveattackshootArcher+"Привелегия"+priv+"\n");
                break;
            case 2:
                selectWarrior1t = rnd(0,3);
                selectWarriorTeamOne = TeamOne.getWarriorList().get(selectWarrior1t);
                System.out.print("Выбран для улучшения персонаж " + selectWarriorTeamOne.name +" из команды 1"+  "\n");
                selectWarriorTeamOne.setAttackHP((float) (selectWarriorTeamOne.getAttackHP()*1.5));
                selectWarriorTeamOne.setPrivilegia(true);
                improveattackWarrior = selectWarriorTeamOne.getAttackHP();
                boolean priv1 = selectWarriorTeamOne.isPrivilegia();
                hpcharacter = selectWarriorTeamOne.getHealth();
                System.out.print("Персонажу " + selectWarriorTeamOne.name +" улучшен в 1,5 и привелегирован"+"здоровье персонажа составляет"+hpcharacter+"Сила удара составляет"+improveattackWarrior+"Привелегия"+priv1+"\n");
                break;
        }

        return hpcharacter;
    }

    public float getOneTeamHP(float param, GroupOneBean TeamOne){

        System.out.print("Выбираем первую команду с общим  здоровьем " + generalhpTeamOne + "\n");
        selectGroupTeamOne = rnd(0,2);
        switch (selectGroupTeamOne) {
            case 0:
                selectMageTeamOne = TeamOne.getMage();
                System.out.print("Выбран " + selectMageTeamOne.name +" из команды 1"+  "\n");
                selectMageTeamOne.setHealth(selectMageTeamOne.getHealth() - param);
                hpcharacter = selectMageTeamOne.getHealth();
                System.out.print("Персонажу " + selectMageTeamOne.name +" нанесен урон"+param+"здоровье персонажа составляет"+hpcharacter+  "\n");
                if (hpcharacter < 0) {
                    System.out.print("Персонаж " + selectWarriorTeamOne.name + "умер"+"\n");
                }
                break;
            case 1:
                selectArcher1t = rnd(0,2);
                selectArcherTeamOne  = TeamOne.getArcherList().get(selectArcher1t);
                System.out.print("Выбран " + selectArcherTeamOne.name +" из команды 1"+  "\n");
                selectArcherTeamOne.setHealth(selectArcherTeamOne.getHealth() - param);
                hpcharacter = selectArcherTeamOne.getHealth();
                System.out.print("Персонажу " + selectArcherTeamOne.name +" нанесен урон"+param+"здоровье персонажа составляет"+hpcharacter+  "\n");
                if (hpcharacter < 0) {
                    System.out.print("Персонаж " + selectWarriorTeamOne.name + "умер"+"\n");
                    TeamOne.getArcherList().remove(selectArcher1t);
                }
                break;
            case 2:
                selectWarrior1t = rnd(0,3);
                selectWarriorTeamOne = TeamOne.getWarriorList().get(selectWarrior1t);
                System.out.print("Выбран " + selectWarriorTeamOne.name +" из команды 2"+  "\n");
                selectWarriorTeamOne.setHealth(selectWarriorTeamOne.getHealth() - param);
                hpcharacter = selectWarriorTeamOne.getHealth();
                System.out.print("Персонажу " + selectWarriorTeamOne.name +" нанесен урон"+param+"здоровье персонажа составляет"+hpcharacter+  "\n");
                if (hpcharacter < 0) {
                    System.out.print("Персонаж " + selectWarriorTeamOne.name + "умер"+"\n");
                    TeamOne.getWarriorList().remove(selectWarrior1t);
                }
                break;
        }



        return hpcharacter;

    }

    public float ImproveTwoTeam(GroupTwoBean TeamTwo){

        System.out.print("Улучшаем команду 2 с общим  здоровьем " + getGeneralhpTeamTwo + "\n");
        selectGroupImprove = rnd(1,2);
        switch (selectGroupImprove) {
            case 1:
                selectArcher2t = rnd(0,2);
                selectArcherTeamTwo  = TeamTwo.getArcherListTwo().get(selectArcher2t);
                System.out.print("Выбран для улучшения персонаж " + selectArcherTeamTwo.name +" из команды 2"+  "\n");
                selectArcherTeamTwo.setAttackHP((float) (selectArcherTeamTwo.getAttackHP()*1.5));
                selectArcherTeamTwo.setAttackHPShoot((float) (selectArcherTeamTwo.getAttackHPShoot()*1.5));
                selectArcherTeamTwo.setPrivilegia(true);
                improveattackArcher = selectArcherTeamTwo.getAttackHP();
                improveattackshootArcher = selectArcherTeamTwo.getAttackHPShoot();
                boolean priv = selectArcherTeamTwo.isPrivilegia();
                hpcharacter = selectArcherTeamTwo.getHealth();
                System.out.print("Персонажу " + selectArcherTeamTwo.name +" улучшен в 1,5 и привелегирован"+"здоровье персонажа составляет"+hpcharacter+"Сила удара составляет"+improveattackArcher+"Сила стрельбы"+improveattackshootArcher+"Привелегия"+priv+"\n");
                break;
            case 2:
                selectWarrior2t = rnd(0,3);
                selectWarriorTeamTwo = TeamTwo.getWarriorListTwo().get(selectWarrior2t);
                System.out.print("Выбран для улучшения персонаж " + selectWarriorTeamTwo.name +" из команды 1"+  "\n");
                selectWarriorTeamTwo.setAttackHP((float) (selectWarriorTeamTwo.getAttackHP()*1.5));
                selectWarriorTeamTwo.setPrivilegia(true);
                improveattackWarrior = selectWarriorTeamTwo.getAttackHP();
                boolean priv1 = selectWarriorTeamTwo.isPrivilegia();
                hpcharacter = selectWarriorTeamTwo.getHealth();
                System.out.print("Персонажу " + selectWarriorTeamTwo.name +" улучшен в 1,5 и привелегирован"+"здоровье персонажа составляет"+hpcharacter+"Сила удара составляет"+improveattackWarrior+"Привелегия"+priv1+"\n");
                break;
        }

        return hpcharacter;

    }

    public float CurseTeam(GroupOneBean TeamOne){

        System.out.print("Выбираем первую команду с общим  здоровьем " + generalhpTeamOne + "\n");
        selectGroupTeamOne = rnd(1,2);
        switch (selectGroupTeamOne) {
            case 1:
                selectArcher1t = rnd(0,2);
                selectArcherTeamOne  = TeamOne.getArcherList().get(selectArcher1t);
                System.out.print("Выбран " + selectArcherTeamOne.name +" из команды 1"+  "\n");
                selectArcherTeamOne.setPrivilegia(false);
                System.out.print("С персонажа " + selectArcherTeamOne.name +" из команды 1"+" убрана привелегия"+  "\n");
                break;
            case 2:
                selectWarrior1t = rnd(0,3);
                selectWarriorTeamOne = TeamOne.getWarriorList().get(selectWarrior1t);
                System.out.print("Выбран " + selectWarriorTeamOne.name +" из команды 1"+  "\n");
                selectWarriorTeamOne.setPrivilegia(false);
                System.out.print("С персонажа " + selectArcherTeamOne.name +" из команды 1"+" убрана привелегия"+  "\n");
                break;
        }

        return hpcharacter;

    }

    public float DiseaseOneTeamHP(GroupOneBean TeamOne){

        System.out.print("Выбираем первую команду с общим  здоровьем " + generalhpTeamOne + "\n");
        selectGroupTeamOne = rnd(0,2);
        switch (selectGroupTeamOne) {
            case 0:
                selectMageTeamOne = TeamOne.getMage();
                System.out.print("Выбран " + selectMageTeamOne.name +" из команды 1"+  "\n");
                selectMageTeamOne.setAttackMage(selectMageTeamOne.getAttackMage()/2);
                newattackMage = selectMageTeamOne.attackMage;
                        System.out.print("Персонажу " + selectMageTeamOne.name +" уменьшены силы на 50%"+"новая атака составляет"+newattackMage+"\n");
                break;
            case 1:
                selectArcher1t = rnd(0,2);
                selectArcherTeamOne  = TeamOne.getArcherList().get(selectArcher1t);
                System.out.print("Выбран " + selectArcherTeamOne.name +" из команды 1"+  "\n");
                selectArcherTeamOne.setAttackHP(selectArcherTeamOne.getAttackHP()/2);
                selectArcherTeamOne.setAttackHPShoot(selectArcherTeamOne.attackHPShoot/2);
                newattackArcher = selectArcherTeamOne.getAttackHP();
                newattackshootArcher = selectArcherTeamOne.getAttackHPShoot();
                System.out.print("Персонажу " + selectArcherTeamOne.name +" уменьшены силы на 50%"+"новая атака составляет"+newattackArcher+"новая стрельба из лука составляет"+newattackshootArcher+"\n");
                break;
            case 2:
                selectWarrior1t = rnd(0,3);
                selectWarriorTeamOne = TeamOne.getWarriorList().get(selectWarrior1t);
                System.out.print("Выбран " + selectWarriorTeamOne.name +" из команды 2"+  "\n");
                selectWarriorTeamOne.setAttackHP(selectWarriorTeamOne.getAttackHP()/2);
                newattackWarrior = selectWarriorTeamOne.getAttackHP();
                System.out.print("Персонажу " + selectArcherTeamOne.name +" уменьшены силы на 50%"+"новая атака составляет"+newattackWarrior+"\n");
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
