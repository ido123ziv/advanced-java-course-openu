package q2;

public class TrafficLightThread extends Thread{
    private TrafficLightController trafficGUI;
    public TrafficLightThread(TrafficLightController gui) {
        trafficGUI = gui;
    }
    public void run() {
        trafficGUI.setFillGreen();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        trafficGUI.setFillYellow();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        trafficGUI.setFillRed();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        trafficGUI.setFillWhite();
    }
}
