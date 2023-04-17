

import java.util.Objects;

public class Item {
    private String description;
    private Enum<mealCourse> type;

    private double price;

    /**
     * constructor for Item
     * @param desc -> description of the item
     * @param type -> type of the item (from Enum)
     * @param pri -> price of the item
     */
    public Item(String desc, String type, double pri){
        this.description = desc;
        this.price = pri;
        this.type = determineType(type);
    }

    /**
     * checks which type the item is from free text
     * @param type -> string representing the type
     * @return type (from enum)
     */
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
            // drinks
            case "drink", "beverage", "liquor" -> {
                return mealCourse.Drink;
            }
        }
        return mealCourse.Drink;
    }

    /**
     *
     * @return the price of the item
     */
    public double getPrice() {
        return price;
    }

    /**
     * set the price of the item
     * @param price -> new price
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * builds a string of the item
     * @return -> a string representing the item
     */
    @Override
    public String toString() {
        return "Item{" +
                "description='" + description + '\'' +
                ", type=" + type +
                ", price=" + price +
                '}';
    }

    /**
     *
     * @return description of the item
     */
    public String getDescription() {
        return description;
    }

    /**
     * set the description of item
     * @param description -> new description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     *
     * @return the type of the item
     */
    public Enum<mealCourse> getType() {
        return type;
    }

}
