package com.company.rase;

import com.company.rase.Entity.Archer;
import java.lang.*;

import static java.lang.System.*;

public class Logic {

    private int typecomandOne = rnd(0,1);
    private int generalhp;


    public void CreateGroupTeam() {

        GroupOneBean TeamOne = new GroupOneBean(typecomandOne);
        System.out.print(typecomandOne);
    }

    public static int rnd(int min, int max)
    {
        max -= min;
        return (int) (Math.random() * ++max) + min;
    }


}
