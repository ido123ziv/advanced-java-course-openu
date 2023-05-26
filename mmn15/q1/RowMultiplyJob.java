package q1;

/**
 * Simple implementation of Rows Multiplication
 */
public class RowMultiplyJob extends Thread {

    private final int[][] result; // final matrix to store the result
    private final int[][] matrix1; // first matrix to multiply
    private final int[][] matrix2; // second matrix to multiply
    private final int mat1Row; // current row in work
    private final int mat2Col; // current col in work

    private final Monitor monitor; // monitor to use in these threads

    private final int id; // thread id

    /**
     * Constructor that builds an instance of a row multiplication thread that calculates a column multiply by a row
     * @param resultMatrix -> where to store the result
     * @param inMatrix1 -> first matrix to multiply
     * @param inMatrix2 -> second matrix to multiply
     * @param currentRow -> current row in work
     * @param currentCol -> current col in work
     * @param m -> monitor to use in these threads
     */
    public RowMultiplyJob(int[][] resultMatrix,int[][] inMatrix1,int[][] inMatrix2, int currentRow, int currentCol, Monitor m){
        result = resultMatrix;
        matrix1 = inMatrix1;
        matrix2 = inMatrix2;
        mat1Row = currentRow;
        mat2Col = currentCol;
        id = matrix2[0].length * currentRow + currentCol;
        monitor = m;
    }

    /**
     * Implementation of run of the thread
     * Calculates the cell in the result by multiplying a row by a column
     * waiting for it's turn to print the result
     */
    @Override
    public void run() {
        super.run();
        result[mat1Row][mat2Col] = 0;
        for (int j =0; j < matrix1[0].length; j++){
            result[mat1Row][mat2Col] += matrix1[mat1Row][j] * matrix2[j][mat2Col];
        }
        monitor.waitForPrint(id);
        System.out.println("Thread Id: " + id + " got the result: " + result[mat1Row][mat2Col]);
        monitor.donePrint();
    }


}
