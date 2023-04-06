public class Elevator extends Alarm{
    private int floor;

    /**
     * Creates new elevator alarm
     * @param address -> address of alarm
     * @param floor -> floor of elevator alarm
     */
    public Elevator(String address, int floor){
        super(address);
        this.floor = floor;
    }

    /**
     * sets the alarm
     */
    @Override
    public void action() {
        super.action();
        System.out.println("Floor of alarm: " + floor);
    }

    /**
     * reset the floor for the elevator
     */
    public void reset(){
        floor = 0;
    }
}
