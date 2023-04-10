public class Smoke extends Alarm{
    private String operator;

    /**
     * creates an instance of smoke alarm
     * @param address -> address of alarm
     * @param operator -> operation of alarm
     */
    public Smoke(String address, String operator) {
        super(address);
        this.operator = operator;
    }

    /**
     * sets the smoke alarm
     */
    public void action(){
        super.action();
        System.out.println("Operator is: " + operator);
    }
}
