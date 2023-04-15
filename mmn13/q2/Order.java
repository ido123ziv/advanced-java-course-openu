package com.example.mmn13;

import java.util.ArrayList;

public class Order {
    private double sumBuy;
    private ArrayList<Item> items;

    public Order(){
        this.sumBuy = 0;
        this.items = new ArrayList<>();
    }
    public Order(ArrayList<Item> itemArrayList){
        this.items = itemArrayList;
        for (Item item : itemArrayList){
            sumBuy += item.getPrice();
        }
    }

    public void addItem(Item item){
        this.sumBuy += item.getPrice();
        this.items.add(item);
    }

    public void removeItem(Item item){
        this.sumBuy -= item.getPrice();
        this.items.remove(item);
    }

    public void closeOrder(String name){
        FilesHandler.saveToFile(name, this.items.toString());
    }


}
