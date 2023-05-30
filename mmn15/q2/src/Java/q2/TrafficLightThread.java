package q2;

public class TrafficLightThread extends Thread{
    private TrafficLightController trafficGUI;
    public TrafficLightThread(TrafficLightController gui) {
        trafficGUI = gui;
    }
    public void run() {
        System.out.println("Thread Running!");
        super.run();
        while (!trafficGUI.isStop()){
            System.out.println("Whiling!");
            trafficGUI.flip();
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
