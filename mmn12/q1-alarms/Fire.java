public class Fire extends Smoke{

    private boolean isActive;

    /**
     * creates an instance of fire alarm
     * @param address -> address of alarm
     * @param operator -> operator of alarm
     */
    public Fire(String address, String operator){
        super(address, operator);
        isActive = true;
    }

    /**
     * starts the alarm
     */
    public void action(){
        super.action();
        isActive = false;
    }
}
