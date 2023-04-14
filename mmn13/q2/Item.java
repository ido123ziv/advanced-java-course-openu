package com.example.mmn13;

import java.util.Objects;

public class Item {
    private String description;
    private Enum<mealCourse> type;

    private double price;

    public Item(String desc, String type, double pri){
        this.description = desc;
        this.price = pri;
        this.type = determineType(type);
    }

    private Enum<mealCourse> determineType(String type){
        type = type.toLowerCase();
        switch (type) {
            // first
            case "first", "starter", "appetizer" -> {
                return mealCourse.Appetizer;
            }
            // main
            case "main", "entree", "secondi" -> {
                return mealCourse.Main;
            }
            // desert
            case "last", "desert", "sweets" -> {
                return mealCourse.Desert;
            }
        }
        return mealCourse.Drink;
    }
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Item{" +
                "description='" + description + '\'' +
                ", type=" + type +
                ", price=" + price +
                '}';
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Enum<mealCourse> getType() {
        return type;
    }

}
