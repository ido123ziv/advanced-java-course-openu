public class Item {
    private double price;
    private String name;
    public Item(double p, String n){
        this.name = n;
        this.price = p;
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

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
