package q1;
import java.util.Random;import java.util.Random;
public class Utils {
    public static int [] [] matrixGenerator(int rowsCount, int colsCount ){
        Random rand = new Random();
        int[][] mat = new int[rowsCount][colsCount];
        for (int i = 0; i < rowsCount; i ++){
            for (int j = 0; j < colsCount; j ++){
                mat[i][j] = rand.nextInt(10);
            }
        }
        return mat;
    }

    public static void printMat(int [][] mat){
        for (int i = 0; i < mat.length; i++){
            for (int j = 0; j < mat[0].length; j++){
                System.out.print(mat[i][j] + " ");
            }
            System.out.println("");
        }
    }
}
