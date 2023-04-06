public class Elevator extends Alarm{
    private int floor;

    public Elevator(String address, int floor){
        super(address);
        this.floor = floor;
    }

    @Override
    public void action() {
        super.action();
        System.out.println("Floor of alarm: " + floor);
    }

    public void reset(){
        floor = 0;
    }
}
