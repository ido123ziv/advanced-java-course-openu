package q1;

public class RowMultiplyJob extends Thread {

    private final int[][] result;
    private final int[][] matrix1;
    private final int[][] matrix2;
    private final int mat1Row;
    private final int mat2Col;

    private ThreadsCreator monitor;

    private final int id;

    public RowMultiplyJob(int[][] resultMatrix,int[][] inMatrix1,int[][] inMatrix2, int currentRow, int currentCol, ThreadsCreator m){
        result = resultMatrix;
        matrix1 = inMatrix1;
        matrix2 = inMatrix2;
        mat1Row = currentRow;
        mat2Col = currentCol;
        id = matrix2[0].length * currentRow + currentCol;
        monitor = m;
    }

    @Override
    public void run() {
        super.run();
//        System.out.println("Thread Id: " + id + " Started!");
        result[mat1Row][mat2Col] = 0;
        for (int j =0; j < matrix1[0].length; j++){
            result[mat1Row][mat2Col] += matrix1[mat1Row][j] * matrix2[j][mat2Col];
        }
//        System.out.println(id + " Entering wait");
//        if (mat2Col == matrix2[0].length -1)
//            monitor.donePrint();

        monitor.waitForPrint(id);
        System.out.println("Thread Id: " + id + " got the result: " + result[mat1Row][mat2Col]);
        monitor.donePrint();
    }


}
