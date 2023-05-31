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
        while (!trafficGUI.isStop()){
//            System.out.println("Whiling!");
            if (countToTen > 10){
                trafficGUI.flip();
                countToTen = 0;
            }
            else
                countToTen ++;
            trafficGUI.flash();
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}
