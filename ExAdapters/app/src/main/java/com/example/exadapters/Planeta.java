package com.example.exadapters;

import java.util.ArrayList;
import java.util.List;

public class Planeta {
    public String name;
    public int img; //R.drawable.xxx

    public Planeta(String name, int img) {
        this.name = name;
        this.img = img;
    }

    public static List<Planeta> getPlanetas(){
        List<Planeta> planetas = new ArrayList<>();
        planetas.add(new Planeta("Mercúrio", R.drawable.planeta_01_mercurio));
        planetas.add(new Planeta("Vênus", R.drawable.planeta_02_venus));
        planetas.add(new Planeta("Terra", R.drawable.planeta_03_terra));
        planetas.add(new Planeta("Marte", R.drawable.planeta_04_marte));
        planetas.add(new Planeta("Júpter", R.drawable.planeta_05_jupiter));
        planetas.add(new Planeta("Saturno", R.drawable.planeta_06_saturno));
        planetas.add(new Planeta("Urano", R.drawable.planeta_07_urano));
        planetas.add(new Planeta("Netuno", R.drawable.planeta_08_neptuno));
        return planetas;
    }

}
