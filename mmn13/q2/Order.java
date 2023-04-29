

import java.util.ArrayList;

public class Order {
    private double sumBuy;
    private ArrayList<Item> items;

    /**
     * empty constructor
     */
    public Order(){
        this.sumBuy = 0;
        this.items = new ArrayList<>();
    }

    /**
     * creates an order from existing list
     * @param itemArrayList -> list of items to add
     */
    public Order(ArrayList<Item> itemArrayList){
        this.items = itemArrayList;
        for (Item item : itemArrayList){
            sumBuy += item.getPrice();
        }
    }

    /**
     * add item to current order
     * @param item -> which item to add
     */
    public void addItem(Item item){
        this.sumBuy += item.getPrice();
        this.items.add(item);
    }
    /**
     * remove item to current order
     * @param item -> which item to add
     */

    public void removeItem(Item item){
        this.sumBuy -= item.getPrice();
        this.items.remove(item);
    }

    /**
     * writes to a file the current order summery
     * @param name -> file name
     */
    public void closeOrder(String name){
        StringBuilder order = new StringBuilder();
        for (Item item : this.items){
            order.append("Item: ").append(item.getDescription()).append("\nType: ").append(item.getType().name()).append("\nAmount: ").append((int)item.getPrice()).append("\n");
        }
        FilesHandler.saveToFile(name, order.toString());
    }

    /**
     * retrive the list of items
     * @return -> current items in order
     */
    public ArrayList<Item> getItems() {
        return items;
    }
}
