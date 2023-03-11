public class RowInAccount {
    private Item item;
    private int quantity;

    private double totalSum;

    public RowInAccount(double p, String name, int q){
        this.item = new Item(p,name);
        this.quantity = q;
        this.totalSum = p * q;
    }
/**
 * returns the sum of the list
 * */
    public double getTotalSum() {
        return totalSum;
    }
/**
 * Update quantity
 * */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "priceOfItem=" + item.getPrice() +
                ", quantity=" + quantity +
                ", totalSum=" + totalSum;
    }
}
