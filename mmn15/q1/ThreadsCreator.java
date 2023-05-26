package q1;

import java.util.ArrayList;

public class ThreadsCreator {
    private int lastId = 1;
    final private int max;

    public ThreadsCreator(int[][] mat) {
        max = mat.length * mat[0].length;
    }

    public synchronized void waitForPrint(int num) {
        while(num >= lastId) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public synchronized void donePrint() {
        lastId++;
        notifyAll();
    }

    public synchronized void waitForAll() {
        while (max + 1 != lastId) {
            try {
                wait();
            } catch (InterruptedException e) { e.printStackTrace(); }
        }
    }

}
