package q1;
import java.util.Date;

/**
 * Main Class
 * Ido Ziv
 * 26/05/2023
 */
public class Main {

    /**
     * runs the program
     * @param args to run main
     */
    public static void main(String [] args){
        // init the arrays
        int [][] mat1 = Utils.matrixGenerator(5,3);
        int [][] mat2 = Utils.matrixGenerator(3,4);
        int [][] result = Utils.resultMatrixGenerator(mat1.length,mat2[0].length);

        //printing arrays for better UI
        System.out.println("Printing Arrays: \n------------------");
        System.out.println("mat1: ");
        Utils.printMat(mat1);
        System.out.println("----------------\nmat2: ");
        Utils.printMat(mat2);
        System.out.println("----------------\n");

        Date start = new Date();
        // executing multiplication
        multiply(mat1,mat2, result);

        Date end = new Date();
        System.out.println("Process took: " + (end.getTime() - start.getTime()) + " milliseconds" );

        System.out.println("Result: ");
        Utils.printMat(result);
    }

    /**
     * this method handles the multiplication using threads
     * @param matrix1 -> matrix a (size n x m)
     * @param matrix2 -> matrix b (size m x p)
     * @param result -> matrix of the result (size n x p)
     */
    public static void multiply(int [][] matrix1, int [][] matrix2,int [][] result){
        if (matrix1[0].length != matrix2.length)
            System.out.println("Can't Multiply!"); // if the columns of matrix 2 doesn't match the rows of matrix 1
        else {
            Monitor monitor = new Monitor(result);
            int matrix1Rows = matrix1.length;
            int matrix2Cols = matrix2[0].length;
            RowMultiplyJob[][] rowMultiplyJobs = new RowMultiplyJob[matrix1Rows][matrix2Cols];
            for (int i =0; i < matrix1Rows; i ++) { // initializing threads
                for (int j = 0; j < matrix2Cols; j ++){
                    rowMultiplyJobs[i][j] = new RowMultiplyJob(result, matrix1, matrix2, i , j, monitor);
                    rowMultiplyJobs[i][j].start();
                }
            }
            monitor.waitForAll(); // waiting for all threads to finish before printing
        }
    }


}
