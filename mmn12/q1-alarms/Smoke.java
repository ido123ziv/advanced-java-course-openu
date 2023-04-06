public class Smoke extends Alarm{
    private String operator;
    public Smoke(String address, String operator) {
        super(address);
        this.operator = operator;
    }

    public void action(){
        super.action();
        System.out.println("Operator is: " + operator);
    }
}
