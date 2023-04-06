import java.util.Date;

public class Alarm {
    /**
     * current Date
     */
    private final Date date;
    /**
     * Current exception
     */
    private final Exception exception;

    /**
     * string to hold current address
     * */
    private final String address;


    /**
     * @param a -> the address of the alarm
     */
    public Alarm(String a){
        this.exception = new Exception();
        date = new Date();
        if (a == null || a == "null" || a == ""){
            this.exception.BadAlarm();
        }
        this.address = a;
    }

    /**
     * Represent alarm as string
     * */
    @Override
    public String toString() {
        return date.toString();
    }

    /**
     * This method set's details about the alarm
     * */
    public void action(){
        System.out.println("Alarm at: " + address + "\nTime of Alarm:" + date.toString());
    }

}
