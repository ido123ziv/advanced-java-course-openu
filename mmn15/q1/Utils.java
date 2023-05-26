package q1;
import java.util.Random;

/**
 * Utils class for helper methods
 */
public class Utils {
    /**
     * Static Function that creates a matrix with given size of random number
     * @param rowsCount -> rows size of matrix
     * @param colsCount -> cols size of matrix
     * @return -> a matrix with random numbers
     */
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

    /**
     *  Static Function that creates a matrix with given size of 0's
     * @param rowsCount -> rows size of matrix
     * @param colsCount -> cols size of matrix
     * @return > an initialized matrix with zeros
     */
    public static int [] [] resultMatrixGenerator(int rowsCount, int colsCount ){
        int[][] mat = new int[rowsCount][colsCount];
        for (int i = 0; i < rowsCount; i ++){
            for (int j = 0; j < colsCount; j ++){
                mat[i][j] = 0;
            }
        }
        return mat;
    }

    /**
     * Pretty prints a matrix
     * @param mat -> matrix to print
     */
    public static void printMat(int [][] mat){
        for (int i = 0; i < mat.length; i++){
            System.out.print("|");
            for (int j = 0; j < mat[0].length; j++){
                System.out.print(edges(mat[i][j]) + "|");
            }
            System.out.println();
        }
    }

    /**
     * This method calculates the spaces needed by number size to align pretty print
     * @param num -> number to print
     * @return -> formatted number
     */
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
