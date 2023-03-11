public class Item {
    private double price;
    private String name;
    public Item(double p, String n){
        this.name = n;
        this.price = p;
    }

    /**
     * return the price of the Item
     * */
    public double getPrice() {
        return price;
    }
    /**
     * return the name of the Item
     * */
    public String getName() {
        return name;
    }
    /**
     * Updates the Item price
     * */
    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Item{" +
                "price=" + price +
                ", name='" + name + '\'' +
                '}';
    }

}
