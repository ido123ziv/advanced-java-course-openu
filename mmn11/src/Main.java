public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Register R1 = new Register();
        Register R2 = new Register(100);

        Item i1 = new Item(10, "milk");
        Item i2 = new Item(9, "eggs");
        Item i3 = new Item(8, "tea");
        Item i4 = new Item(7, "honey");

//        testing R1
        System.out.println("Testing R1");
        R1.addItem(i1,2);
        R1.addItem(i2,4);
        R1.addItem(i3,5);
        System.out.println("Cashier: Current Total is:" + R1.getCurrentBuySum());

        System.out.println("Customer: Can I see the details?");
        System.out.println(R1.getCurrentBuyItems());

        System.out.println("Customer: ok then, here is the payment!");
        R1.acceptPayment(100);

        System.out.println("Accepted Payment!\nBalance:" + R2.getBalance());
//        testing R2
        System.out.println("Testing R2");
        R2.addItem(i1,3);
        R2.addItem(i2,3);
        R2.addItem(i4,3);
        System.out.println("Cashier: Current Total is:" + R2.getCurrentBuySum());

        System.out.println("Customer: Can I see the details?");
        System.out.println(R2.getCurrentBuyItems());

        System.out.println("Customer: ok then, here is the payment!");
        R2.acceptPayment(100);

        System.out.println("Accepted Payment!\nBalance:" + R2.getBalance());
//      testing both
        System.out.println("Let's see who has the greater balance?");
        System.out.println("R1: " + R1.getBalance() + " R2: " + R2.getBalance());
        System.out.println("The winner is:" + whoWon(R1,R2,1));
        System.out.println("Let's see who has the greater income?");
        System.out.println("R1: " + R1.getSumOfShopping() + " R2: " + R2.getSumOfShopping());
        System.out.println("The winner is:" + whoWon(R1,R2,-1));

    }
    public static Register whoWon(Register R1, Register R2, int compFlag){
        if (compFlag > 0){
            if (R1.getSumOfShopping() > R2.getSumOfShopping()) return R1;
            return R2;
        }
        if (R1.getBalance() > R2.getBalance()) return R1;
        return R2;
    }
}