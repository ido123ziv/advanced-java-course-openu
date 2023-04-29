

import java.util.ArrayList;
import java.util.HashMap;

public class Menu {
    private ArrayList<Item> appetizers;
    private ArrayList<Item> mains;
    private ArrayList<Item> deserts;
    private ArrayList<Item> drinks;

    private int itemsCounter;

    /**
     * constructor
     * @param itemArrayList -> items to add to menu
     */
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

    /**
     * retrieves item count
     * @return the amount of items in menu
     */
    public int getItemsCounter() {
        return this.itemsCounter;
    }

    /**
     * add item to menu
     * @param item -> new item to add
     */
    public void addItem(Item item){
        switch (item.getType().name()){
            case "Appetizer" -> this.appetizers.add(item);
            case "Main" -> this.mains.add(item);
            case "Desert" -> this.deserts.add(item);
            case "Drink" -> this.drinks.add(item);
        }
    }

    /**
     * current menu represented as a map
     * @return -> a map with current menu items
     */
    public HashMap<mealCourse,ArrayList<Item>> getMenu() {
        HashMap<mealCourse,ArrayList<Item>> mp = new HashMap<>(){{
            put(mealCourse.Appetizer, appetizers);
            put(mealCourse.Main, mains);
            put(mealCourse.Desert, deserts);
            put(mealCourse.Drink, drinks);
        }};
        return mp;
    }

    /**
     * presents a text of the list
     * @return -> string representation of the menu
     */
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
