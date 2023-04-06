import java.util.Scanner;

public class RunTests {
    private Scanner sc = new Scanner(System.in);

    public BigInt getNum() {
        while (true) {
            try {
                System.out.println("Enter a big number you want: ");
                Scanner myObj = new Scanner(System.in);
                String str = myObj.nextLine();
                BigInt num = new BigInt(str);
                return num;
            } catch (IllegalArgumentException iaex) {
                System.out.println("Invalid number, number starts with +,- and then just digits!\nPlease enter valid number!");
            }
        }
    }
}
