package q1;
import java.util.Date;

public class Main {

    public static void main(String [] args){
        int [][] mat1 = Utils.matrixGenerator(5,7);
        int [][] mat2 = Utils.matrixGenerator(7,8);
        int [][] result = new int[mat1.length][mat2[0].length];

        System.out.println("Printing Arrays: \n------------------");
        System.out.println("mat1: ");
        Utils.printMat(mat1);
        System.out.println("----------------\nmat2: ");
        Utils.printMat(mat2);
        System.out.println("----------------\n");
        Date start = new Date();

        ThreadsCreator.multiply(mat1,mat2, result);

        Date end = new Date();
        System.out.println("Process took: " + (end.getTime() - start.getTime()) + " milliseconds" );
        System.out.println("Result: ");
        Utils.printMat(result);
    }




}
