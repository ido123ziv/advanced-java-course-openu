package q1;

public class RowMultiplyJob implements Runnable {

    private final int[][] result;
    private final int[][] matrix1;
    private final int[][] matrix2;
    private final int mat1Row;
    private final int mat2Col;

    public RowMultiplyJob(int[][] resultMatrix,int[][] inMatrix1,int[][] inMatrix2, int currentRow, int currentCol){
        result = resultMatrix;
        matrix1 = inMatrix1;
        matrix2 = inMatrix2;
        mat1Row = currentRow;
        mat2Col = currentCol;
    }

    @Override
    public void run() {
//        for (int i =0; i < matrix2[0].length; i++){
//            result[mat1Row][i] = 0;
        for (int j =0; j < matrix1[0].length; j++){
            result[mat1Row][mat2Col] += matrix1[mat1Row][j] * matrix2[j][mat2Col];
        }
//        }
    }


}
