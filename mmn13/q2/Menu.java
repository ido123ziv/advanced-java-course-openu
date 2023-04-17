package com.example.mmn13;

import java.util.ArrayList;
import java.util.HashMap;

public class Menu {
    private ArrayList<Item> appetizers;
    private ArrayList<Item> mains;
    private ArrayList<Item> deserts;
    private ArrayList<Item> drinks;

    private int itemsCounter;
    public Menu(ArrayList<Item> itemArrayList){
        this.appetizers = new ArrayList<>();
        this.mains= new ArrayList<>();
        this.deserts= new ArrayList<>();
        this.drinks= new ArrayList<>();
        for (Item item : itemArrayList){
            switch (item.getType().name()){
                case "Appetizer" -> this.appetizers.add(item);
                case "Main" -> this.mains.add(item);
                case "Desert" -> this.deserts.add(item);
                case "Drink" -> this.drinks.add(item);
            }
        }
        this.itemsCounter = this.appetizers.size() + this.mains.size() + this.deserts.size() + this.drinks.size();
    }

    public int getItemsCounter() {
        return this.itemsCounter;
    }

    public void addItem(Item item){
        switch (item.getType().name()){
            case "Appetizer" -> this.appetizers.add(item);
            case "Main" -> this.mains.add(item);
            case "Desert" -> this.deserts.add(item);
            case "Drink" -> this.drinks.add(item);
        }
    }

    public HashMap<mealCourse,ArrayList<Item>> getMenu() {
        HashMap<mealCourse,ArrayList<Item>> mp = new HashMap<>(){{
            put(mealCourse.Appetizer, appetizers);
            put(mealCourse.Main, mains);
            put(mealCourse.Desert, deserts);
            put(mealCourse.Drink, drinks);
        }};
        return mp;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "appetizers=" + appetizers +
                ", mains=" + mains +
                ", deserts=" + deserts +
                ", drinks=" + drinks +
                '}';
    }
}
