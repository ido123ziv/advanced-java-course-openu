package q2;

public class TrafficLightThread extends Thread{
    private TrafficLightController trafficGUI;
    public TrafficLightThread(TrafficLightController gui) {
        trafficGUI = gui;
    }
    public void run() {
        System.out.println("Thread Running!");
        super.run();
        int countToTen = 0;
        int timeout;
        while (!trafficGUI.isStop){
            if (trafficGUI.side > 0)
                timeout = trafficGUI.redTime;
            else
                timeout = trafficGUI.greenTime;
            System.out.println("Timeout: " + timeout);
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
