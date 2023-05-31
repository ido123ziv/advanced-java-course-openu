package q2;
/**
 * Thread Class for Traffic Light
 * Author: Ido Ziv 2023
 */
public class TrafficLightThread extends Thread{
    private final TrafficLightController trafficGUI; // using this object to let thread access attributes of controller

    /**
     * Constructor of TrafficLightThread
     * Creates a Thread for application
     * @param gui -> which controller to use
     */
    public TrafficLightThread(TrafficLightController gui) {
        trafficGUI = gui;
    }

    /**
     * Implements the thread action of run
     * runs a loop until broken to change the traffic lights
     * checks current timeout and update accordingly
     * flashes pedestrians light for twice the time of the timout, if timeout is 6 second will flash 12 times
     */
    public void run() {
        super.run();
        int countToTen = 0;
        int timeout;
        while (!trafficGUI.isStop){
            if (trafficGUI.side > 0)
                timeout = trafficGUI.redTime;
            else
                timeout = trafficGUI.greenTime;
            if (countToTen > (timeout * 2)){
                trafficGUI.flip();
                countToTen = 0;
            }
            else
                countToTen ++;
            trafficGUI.flash();
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}
