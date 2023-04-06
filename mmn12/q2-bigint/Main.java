import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
//        RunTests test = new RunTests();

        BigInt b1 = new BigInt("+12345");
        BigInt b2 = new BigInt("+1234");
        BigInt b3 = new BigInt("-12345");
        BigInt b4 = new BigInt("-1234");
        System.out.println("Testing Equal Positive");
        makeTest(b1,b1);
        System.out.println("Testing Positive");
        makeTest(b1,b2);
        System.out.println("Testing Positive & Negative");
        makeTest(b1,b3);
        System.out.println("Testing Negative");
        makeTest(b3,b4);
        System.out.println("Testing Negative & Positive");
        makeTest(b2,b4);
        System.out.println("Testing Equal Negative");
        makeTest(b3,b3);


    }
    public static void makeTest(BigInt b1, BigInt b2){
        String b1Printable = b1.toString();
        String b2Printable = b2.toString();
        System.out.println(b1Printable + " + " + b2Printable + " = " + b1.plus(b2).toString());
//        System.out.println(b1Printable + " - " + b2Printable + " = " + b1.minus(b2).toString());
//        System.out.println(b1Printable + " * " + b2Printable + " = " + b1.multiply(b2).toString());
//        System.out.println(b1Printable + " == " + b2Printable + " = " + b1.equals(b2));
//        String whoIsBigger = switch (b1.compareTo(b2)) {
//            case 1 -> "b1";
//            case -1 -> "b2";
//            default -> "equal";
//        };
//        System.out.println("Who is bigger? " + b1Printable + " <? " + b2Printable + " => " + whoIsBigger);

    }
}