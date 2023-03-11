public class RowInAccount {
    private double priceOfItem;
    private int quantity;

    private double totalSum;

    public RowInAccount(double p, int q){
        this.priceOfItem = p;
        this.quantity = q;
        this.totalSum = p * q;
    }

    public double getTotalSum() {
        return totalSum;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "priceOfItem=" + priceOfItem +
                ", quantity=" + quantity +
                ", totalSum=" + totalSum;
    }
}
