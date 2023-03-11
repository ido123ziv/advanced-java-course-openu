import java.util.ArrayList;
import java.util.List;

public class Register {
    private double balance;
    private double sumOfShopping;
    private double currentBuy;
    private List<RowInAccount> currentBuyItems = new ArrayList<>();


    public Register(){
        this.balance = 0;
        this.sumOfShopping = 0;
        this.currentBuy = 0;
    }
    public Register(int initSum){
        this.balance = initSum;
        this.sumOfShopping = 0;
        this.currentBuy = 0;
    }
    public void addItem(Item i, int quantity){
        this.currentBuy += (i.getPrice() * quantity);
        this.currentBuyItems.add(new RowInAccount(i.getPrice(), i.getName(),quantity));
    }
    public String getCurrentBuyItems(){
        String currentBuyItemsList = "Items list: \n";
        for (int i = 0; i< this.currentBuyItems.size(); i++){
            currentBuyItemsList += (this.currentBuyItems.get(i) + "\n");
        }
        return currentBuyItemsList;
    }
    public double getCurrentBuySum() {
        return currentBuy;
    }

    /**
     * Handles the payment of the buy
     * */
    public double acceptPayment(double cash){
        double diff = cash - this.currentBuy; // calc the diff to return
        if (diff < 0){ // if the buy is valid
            System.out.println("Not enough money");
            return -1;
        }
        else { // add the values of buy and reset others
            this.sumOfShopping += this.currentBuy;
            this.balance += this.currentBuy;
            this.currentBuy = 0;
            this.currentBuyItems = new ArrayList<>();
        }
        return diff;
    }
    /**
     * return the balance of register
     * */
    public double getBalance(){
        return balance;
    }
    /**
     * return total of the registry
     * */
    public double getSumOfShopping() {
        return sumOfShopping;
    }

    @Override
    public String toString() {
        return "Register{" +
                "balance=" + balance +
                ", sumOfShopping=" + sumOfShopping +
                '}';
    }
}
