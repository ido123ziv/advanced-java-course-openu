import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

//        first batch
        Smoke s1 = new Smoke("first batch First Smoke alarm", "Ido1");
        Smoke s2 = new Smoke("first batch Second Smoke alarm", "Ido2");
        Fire f1 = new Fire("first batch First Fire alarm", "Ido3");
        Fire f2 = new Fire("first batch Second Fire alarm", "Ido4");
        Elevator e1 = new Elevator("first batch Elevator alarm", 5);

        ArrayList<Alarm> alarmList1 = new ArrayList<Alarm>() {{
            add(s1);
            add(s2);
            add(f1);
            add(f2);
            add(e1);
        }};
//        second batch
        Smoke s3 = new Smoke("second batch First Smoke alarm", "Ido1");
        Smoke s4 = new Smoke("second batch Second Smoke alarm", "Ido2");
        Fire f3 = new Fire(" second batch First Fire alarm", "Ido3");
        Fire f4 = new Fire("second batch Second Fire alarm", "Ido4");
        Elevator e2 = new Elevator("second batch Elevator alarm", 17);

        TestAlarms testFirstBatch = new TestAlarms();
        testFirstBatch.process(alarmList1);        ArrayList<Alarm> alarmList2 = new ArrayList<Alarm>() {{
            add(s3);
            add(s4);
            add(f3);
            add(f4);
            add(e2);
        }};

        TestAlarms testSecondBatch = new TestAlarms();
        testSecondBatch.process(alarmList2);
    }
}