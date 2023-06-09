package q1;

/**
 * This class acts as a monitor for our threads
 */
public class Monitor {
    private int lastId = 1; // last id that printed
    final private int max; // the last item to be printed

    /**
     * Constructor -> builds a Monitor Monitor
     * @param mat -> a matrix to calculate on
     */
    public Monitor(int[][] mat) {
        max = mat.length * mat[0].length;
    }

    /**
     * This method allows a thread to wait until it's turn to print
     * @param threadId -> thread id
     */
    public synchronized void waitForPrint(int threadId) {
        while(threadId >= lastId) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * This method releases the lock on current id by bumping it
     */
    public synchronized void donePrint() {
        lastId++;
        notifyAll();
    }

    /**
     * This method enforces the program to wait for all threads
     */
    public synchronized void waitForAll() {
        while (max + 1 != lastId) {
            try {
                wait();
            } catch (InterruptedException e) { e.printStackTrace(); }
        }
    }

}
