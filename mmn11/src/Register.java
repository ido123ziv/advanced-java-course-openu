import java.util.ArrayList;
import java.util.List;

import static java.lang.System.exit;

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
        this.currentBuyItems.add(new RowInAccount(i.getPrice(),quantity));
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

    public double acceptPayment(double cash){
        double diff = cash - this.currentBuy;
        if (diff < 0){
            System.out.println("Not enough money");
            return -1;
        }
        else {
            this.sumOfShopping += this.currentBuy;
            this.balance += this.currentBuy;
            this.currentBuy = 0;
            this.currentBuyItems = new ArrayList<>();
        }
        return diff;
    }
    public double getBalance(){
        return balance;
    }


    @Override
    public String toString() {
        return "Register{" +
                "balance=" + balance +
                ", sumOfShopping=" + sumOfShopping +
                '}';
    }
}
