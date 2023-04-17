

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
        StringBuilder order = new StringBuilder();
        for (Item item : this.items){
            order.append("Item: ").append(item.getDescription()).append("\nType: ").append(item.getType().name()).append("\nAmount: ").append((int)item.getPrice()).append("\n");
        }
        FilesHandler.saveToFile(name, order.toString());
    }

    public ArrayList<Item> getItems() {
        return items;
    }
}
