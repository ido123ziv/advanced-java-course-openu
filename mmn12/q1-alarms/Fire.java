public class Fire extends Smoke{

    private boolean isActive;
    public Fire(String address, String op){
        super(address, op);
        isActive = true;
    }

    public void action(){
        super.action();
        isActive = false;
    }
}
