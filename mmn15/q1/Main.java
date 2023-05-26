package q1;
import java.util.Date;

public class Main {

    public static void main(String [] args){
        int [][] mat1 = Utils.matrixGenerator(5,3);
        int [][] mat2 = Utils.matrixGenerator(3,4);
        int [][] result = Utils.resultMatrixGenerator(mat1.length,mat2[0].length);

        System.out.println("mat1.length: " + mat1.length + " mat1[0].length: " + mat1[0].length);


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
