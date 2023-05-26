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
    public static int [] [] resultMatrixGenerator(int rowsCount, int colsCount ){
        int[][] mat = new int[rowsCount][colsCount];
        for (int i = 0; i < rowsCount; i ++){
            for (int j = 0; j < colsCount; j ++){
                mat[i][j] = 0;
            }
        }
        return mat;
    }

    public static void printMat(int [][] mat){
        for (int i = 0; i < mat.length; i++){
            System.out.print("|");
            for (int j = 0; j < mat[0].length; j++){
                System.out.print(edges(mat[i][j]) + "|");
            }
            System.out.println();
        }
    }

    private static String edges(int num){
        if (num < 10)
            return "  " + num + "   ";
        if (num < 100)
            return "  " + num + "  ";
        if (num < 1000)
            return "  " + num + " ";
        return " " + num + " ";

    }
}
