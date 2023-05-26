package q1;

import java.util.ArrayList;

public class ThreadsCreator {

    public static void multiply(int [][] matrix1, int [][] matrix2,int [][] result){
        ArrayList<Thread> threadsList = new ArrayList<>();
        int matrix1Rows = matrix1.length;
        for (int i = 0; i < matrix1Rows; i++){
            RowMultiplyJob task = new RowMultiplyJob(result, matrix1, matrix2, i);
            Thread thread = new Thread(task);
            thread.start();
            threadsList.add(thread);
            if (threadsList.size() % 10 == 0) {
                waitForThreads(threadsList);
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
