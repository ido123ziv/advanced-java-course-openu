import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        syntheticTests();
        getUserInput();

    }
    public static void makeTest(BigInt b1, BigInt b2){
        String b1Printable = b1.toString();
        String b2Printable = b2.toString();
        System.out.println(b1Printable + " + " + b2Printable + " = " + b1.plus(b2).toString());
        System.out.println(b1Printable + " - " + b2Printable + " = " + b1.minus(b2).toString());
        System.out.println(b1Printable + " * " + b2Printable + " = " + b1.multiply(b2).toString());
        System.out.println(b1Printable + " / " + b2Printable + " = " + b1.divide(b2).toString());
        System.out.println(b1Printable + " == " + b2Printable + " = " + b1.equals(b2));
        String whoIsBigger = switch (b1.compareTo(b2)) {
            case 1 -> "b1";
            case -1 -> "b2";
            default -> "equal";
        };
        System.out.println("Who is bigger? " + b1Printable + " <? " + b2Printable + " => " + whoIsBigger);
    }
    public static void printExpectedResult(String s1, String s2){
        int i1 = Integer.parseInt(s1), i2 = Integer.parseInt(s2);
        System.out.println(s1 + " + " + s2 + " = " + (i1 + i2));
        System.out.println(s1 + " - " + s2 + " = " + (i1 - i2));
        System.out.println(s1 + " * " + s2 + " = " + (i1 * i2));
        System.out.println(s1 + " / " + s2 + " = " + (i1 / i2));
        System.out.println(s1 + " == " + s2 + " = " + (i1 == i2));
        String whoIsBigger = switch (Integer.compare(i1,i2)) {
            case 1 -> "b1";
            case -1 -> "b2";
            default -> "equal";
        };
        System.out.println("Who is bigger? " + s1 + " <? " + s2 + " => " + whoIsBigger);
        System.out.println("Now for the real results:");
    }
    public static void syntheticTests(){
        String s1 = "12345";
        String s2 = "1234";
        String s3 = "-12345";
        String s4 = "-1234";
        BigInt b1 = new BigInt("+12345");
        BigInt b2 = new BigInt("+1234");
        BigInt b3 = new BigInt("-12345");
        BigInt b4 = new BigInt("-1234");
        System.out.println("Testing Equal Positive");
        printExpectedResult(s1,s1);
        makeTest(b1,b1);
        System.out.println("Testing Positive");
        printExpectedResult(s1,s2);
        makeTest(b1,b2);
        System.out.println("Testing Positive & Negative");
        printExpectedResult(s1,s3);
        makeTest(b1,b3);
        System.out.println("Testing Negative");
        printExpectedResult(s3,s4);
        makeTest(b3,b4);
        System.out.println("Testing Negative & Positive");
        printExpectedResult(s4,s1);
        makeTest(b4,b1);
        System.out.println("Testing Equal Negative");
        printExpectedResult(s3,s3);
        makeTest(b3,b3);
    }

    public static void getUserInput(){
        Scanner sc = new Scanner(System.in);
        int input = 1;
        while (input != -1) {
            try {
                BigInt b1 = GetNumber(sc);
                BigInt b2 = GetNumber(sc);
                makeTest(b1,b2);
                System.out.println("---------------");
                System.out.println("Want to run again?\nenter any number\nto stop enter -1");
                input =  Integer.parseInt(sc.nextLine());
            } catch (IllegalArgumentException iaex) {
                System.out.println("Invalid number, number starts with +,- and then just digits!\nPlease enter valid number!");
            }
        }
    }
    public static BigInt GetNumber(Scanner sc){
        System.out.println("Enter a big number: ");
        String str1 = sc.nextLine();
        return new BigInt(str1);
    }
}