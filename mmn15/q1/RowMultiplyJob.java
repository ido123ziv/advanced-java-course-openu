package q1;

public class RowMultiplyJob implements Runnable {

    private final int[][] result;
    private final int[][] matrix1;
    private final int[][] matrix2;
    private final int row;

    public RowMultiplyJob(int[][] resultMatrix,int[][] inMatrix1,int[][] inMatrix2, int currentRow){
        result = resultMatrix;
        matrix1 = inMatrix1;
        matrix2 = inMatrix2;
        row = currentRow;
    }

    @Override
    public void run() {
        for (int i =0; i < matrix2[0].length; i++){
            result[row][i] = 0;
            for (int j =0; j < matrix1[0].length; j++){
                result[row][i] += matrix1[row][j] * matrix2[j][i];
            }
        }
    }


}
