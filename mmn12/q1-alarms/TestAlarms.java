import java.util.ArrayList;

public class TestAlarms {
    private int counter;

    public TestAlarms(){
        
        counter = 0;
    }

    /***
     * Gets a list of alarms and activates the action of each class,
     * counts the amount of Smoke and fire alarm instances
     * @param alarmList
     */
    public void process(ArrayList<Alarm> alarmList){
        for (Alarm alarm : alarmList) {
            alarm.action();
            if (alarm instanceof Smoke)
                counter++;
            else if (alarm instanceof Elevator)
                ((Elevator) alarm).reset();
        }
        System.out.println("There are: " + counter + " Smoke alarm instances or smoke alarm sons");
    }
}
