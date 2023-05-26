package q1;
import java.util.ArrayList;
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

        multiply(mat1,mat2, result);

        Date end = new Date();
        System.out.println("Process took: " + (end.getTime() - start.getTime()) + " milliseconds" );
        System.out.println("Result: ");
        Utils.printMat(result);
    }

    public static void multiply(int [][] matrix1, int [][] matrix2,int [][] result){
        if (matrix1[0].length != matrix2.length)
            System.out.println("Can't Multiply!");
        else {
//            ArrayList<Thread> threadsList = new ArrayList<>();
            ThreadsCreator tc = new ThreadsCreator(result);
            int matrix1Rows = matrix1.length;
            int matrix2Cols = matrix2[0].length;
            RowMultiplyJob[][] rowMultiplyJobs = new RowMultiplyJob[matrix1Rows][matrix2Cols];
            System.out.println("rows: " + matrix1Rows + " cols: " + matrix2Cols + " mult " + (matrix1Rows * matrix2Cols));
            for (int i =0; i < matrix1Rows; i ++) {
                for (int j = 0; j < matrix2Cols; j ++){
                    rowMultiplyJobs[i][j] = new RowMultiplyJob(result, matrix1, matrix2, i , j, tc);
                    rowMultiplyJobs[i][j].start();
//                    Thread thread = new Thread(task);
//                    thread.start();
//                    threadsList.add(thread);
                }
            }
            tc.waitForAll();
        }
    }


}
