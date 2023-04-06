import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//       Testing.Main();
        Register R1 = new Register();
        application(R1);

    }

/**
 * Method to handle cashier application
 * */
    public static void application(Register R){
        int option = 0, currentMenu = 1;
        Scanner sc=new Scanner(System.in);
        List<Item> itemsArray = new ArrayList<>(Arrays.asList(
            new Item(10, "milk"),
            new Item(9, "eggs"),
            new Item(8, "tea"),
            new Item(7, "honey")));

        while (option != -1){ // user not exited
            printMenu(currentMenu);
            option = sc.nextInt();
            if (option > 0 && currentMenu == 1) // main menu
                handleGlobalOption(R,option);
            if (currentMenu == 1 && option == 1){ // main menu chose new buy
                currentMenu = -1;
                printMenu(currentMenu);
            }
            if (currentMenu == -1 && option == 0){ // buy menu chose go back
                handleOptionBuy(R,option,sc, itemsArray);
                currentMenu = 1;
                printMenu(currentMenu);
            }
            if (option > 0 && currentMenu == -1){//buy menu
                handleOptionBuy(R,option,sc, itemsArray);
                if (option == 3) currentMenu =1;
            }
        }
        System.out.println("Thanks for shopping"); // after exit
    }
/**
 * simple method to print menu
 * */
    public static void printMenu(int op){
        String MainMenu = "Please Choose an option:\n" +
                "[1] -> Start new Buy\n" +
                "[2] -> get Cashier Total\n" +
                "[3] -> get Cashier Balance\n" +
                "[-1] -> exit\n" +
                "";
        String BuyMenu = "Please Choose an option:\n" +
                "[0] -> return to main menu\n" +
                "[1] -> Add new Item Buy\n" +
                "[2] -> get current Total\n" +
                "[3] -> Pay\n" +
                "[4] -> See Details\n" +
                "[-1] -> exit\n" +
                "";
        if (op > 0) System.out.println(MainMenu);
        else System.out.println(BuyMenu);
    }
    /**
     * Method used to determine what to do in main menu
     * */
    public static void handleGlobalOption(Register R, int option){
        switch (option) {
            case 1 -> System.out.println("Starting new Buy!");
            case 2 -> System.out.println("Total: " + R.getSumOfShopping());
            case 3 -> System.out.println("Balance: " + R.getBalance());
            default -> System.out.println("Choose valid option!");
        }
    }
    /**
     * Method to determine buy menu
     * */
    public static void handleOptionBuy(Register R, int option, Scanner sc, List<Item> li){
        switch (option) {
            case 0 -> R.cancelBuy();
            case 1 -> {
                System.out.println("Which Item to add?\n" +
                        "0 - milk, 1 - eggs, 2 - tea, 3 - honey\n" +
                        "enter the num please\n");
                int itemIndex = sc.nextInt();
                if (new ArrayList<Integer>() {{
                    add(0);
                    add(1);
                    add(2);
                    add(3);
                } }.contains(itemIndex)){
                System.out.println("How many would you like?\n");
                int q = sc.nextInt();
                if (q >= 0)
                    R.addItem(li.get(itemIndex), q);
                }
            }
            case 2 -> System.out.println(R.getCurrentBuySum());
            case 3 -> {
                System.out.println("That will be " + R.getCurrentBuySum());
                System.out.println("Please enter cash amount");
                double cash = sc.nextDouble();
                R.acceptPayment(cash);
                System.out.println("Payment accepted\nNew Balance is:" + R.getBalance());
            }
            case 4 -> System.out.println(R.getCurrentBuyItems());
            default -> System.out.println("Choose valid option!");
        }
    }

}