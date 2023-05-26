package q1;

import java.util.ArrayList;

public class ThreadsCreator {

    public static void multiply(int [][] matrix1, int [][] matrix2,int [][] result){
        if (matrix1[0].length != matrix2.length)
            System.out.println("Can't Multiply!");
        else {
            ArrayList<Thread> threadsList = new ArrayList<>();
            int matrix1Rows = matrix1.length;
            int matrix2Cols = matrix2[0].length;
            System.out.println("rows: " + matrix1Rows + " cols: " + matrix2Cols + " mult " + (matrix1Rows * matrix2Cols));
//            for (int i = 0; i < (matrix1Rows * matrix2Cols); i++){
            for (int i =0; i < matrix1Rows; i ++) {
                for (int j = 0; j < matrix2Cols; j ++){
//                    System.out.println("current row: " + i +  " currentCol: " + j );
                    RowMultiplyJob task = new RowMultiplyJob(result, matrix1, matrix2, i , j);
                    Thread thread = new Thread(task);
                    thread.start();
                    threadsList.add(thread);
                    if (threadsList.size() % 10 == 0) {
                        waitForThreads(threadsList);
                    }
                }
            }
        }
    }

    private static void waitForThreads(ArrayList<Thread> threadsList) {
        for (Thread thread : threadsList) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        threadsList.clear();
    }
}
