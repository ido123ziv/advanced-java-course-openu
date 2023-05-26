package q1;

public class RowMultiplyJob implements Runnable {

    private final int[][] result;
    private final int[][] matrix1;
    private final int[][] matrix2;
    private final int mat1Row;
    private final int mat2Col;

    private final int id;

    public RowMultiplyJob(int[][] resultMatrix,int[][] inMatrix1,int[][] inMatrix2, int currentRow, int currentCol){
        result = resultMatrix;
        matrix1 = inMatrix1;
        matrix2 = inMatrix2;
        mat1Row = currentRow;
        mat2Col = currentCol;
        id = matrix1.length * currentRow + currentCol;
    }

    @Override
    public void run() {
        result[mat1Row][mat2Col] = 0;
        for (int j =0; j < matrix1[0].length; j++){
            result[mat1Row][mat2Col] += matrix1[mat1Row][j] * matrix2[j][mat2Col];
        }
        System.out.println("Thread Id: " + id + " got the result: " + result[mat1Row][mat2Col]);
    }


}
