package q2;

import javafx.fxml.FXML;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

import java.util.Objects;

public class TrafficLightController{


    @FXML
    public Circle LeftTopCirc, RightTopCirc, TopBottomCirc, TopTopCirc;
    public Circle LeftBottomCirc,  RightBottomCirc, BottomTopCirc, BottomBottomCirc;
    public Rectangle LeftTopRec, RightTopRec, TopTopRec, BottomTopRec;
    public Rectangle  LeftBottomRec , RightBottomRec, TopBottomRec, BottomBottomRec;
    public Slider redScroll;
    public Slider greenScroll;
    public TextField redTimeText;
    public TextField greenTimeText;

    public int redTime = 3, greenTime = 3;
    public int side;
    public boolean isStop;

    public void initialize() {
        side = 1;
        isStop = false;
        System.out.println("Initializing!");
        TrafficLightThread ta = new TrafficLightThread(this);
        redTimeText.setText("Red wait: " + (redTime) + " Seconds");
        greenTimeText.setText("Green wait: " + (greenTime) + " Seconds");
        ta.start();
    }

    public void flip(){
//        System.out.println("Flipping!");
        if (side > 0){
          TopTopCirc.setFill(Color.WHITE);
          BottomTopCirc.setFill(Color.WHITE);
          TopBottomCirc.setFill(Color.LIME);
          BottomBottomCirc.setFill(Color.LIME);

          LeftTopCirc.setFill(Color.RED);
          RightTopCirc.setFill(Color.RED);
          RightBottomCirc.setFill(Color.WHITE);
          LeftBottomCirc.setFill(Color.WHITE);

        TopTopRec.setFill(Color.RED);
        BottomTopRec.setFill(Color.RED);
        TopBottomRec.setFill(Color.WHITE);
        BottomBottomRec.setFill(Color.WHITE);

        LeftTopRec.setFill(Color.WHITE);
        RightTopRec.setFill(Color.WHITE);
        RightBottomRec.setFill(Color.LIME);
        LeftBottomRec.setFill(Color.LIME);
        }
        else{
          TopTopCirc.setFill(Color.RED);
          BottomTopCirc.setFill(Color.RED);
          TopBottomCirc.setFill(Color.WHITE);
          BottomBottomCirc.setFill(Color.WHITE);

          LeftTopCirc.setFill(Color.WHITE);
          RightTopCirc.setFill(Color.WHITE);
          RightBottomCirc.setFill(Color.LIME);
          LeftBottomCirc.setFill(Color.LIME);

            TopTopRec.setFill(Color.WHITE);
            BottomTopRec.setFill(Color.WHITE);
            TopBottomRec.setFill(Color.LIME);
            BottomBottomRec.setFill(Color.LIME);

            LeftTopRec.setFill(Color.RED);
            RightTopRec.setFill(Color.RED);
            RightBottomRec.setFill(Color.WHITE);
            LeftBottomRec.setFill(Color.WHITE);
        }
        side = side * -1;
    }

    private String ColorName(String colorHex){
        if (Objects.equals(colorHex, "0xff0000ff")) return "red";
        if (Objects.equals(colorHex, "0xffffffff")) return "white";
        return "lime";
    }

    public void flash(){
        if (side < 0){
            if (ColorName(RightBottomRec.getFill().toString()).equals("lime")){
                RightBottomRec.setFill(Color.WHITE);
                LeftBottomRec.setFill(Color.WHITE);
            }
            else {
                RightBottomRec.setFill(Color.LIME);
                LeftBottomRec.setFill(Color.LIME);
            }
        }
        else {
            if (ColorName(TopBottomRec.getFill().toString()).equals("lime")){
                TopBottomRec.setFill(Color.WHITE);
                BottomBottomRec.setFill(Color.WHITE);
            }
            else {
                TopBottomRec.setFill(Color.LIME);
                BottomBottomRec.setFill(Color.LIME);
            }
        }
    }

    public void toStop(){
        isStop = !isStop;
    }

    public void onSliderChanged(MouseEvent mouseEvent) {
        Slider s = (Slider) mouseEvent.getSource();
        if (Objects.equals(s.getId(), redScroll.getId())){
            redTime = (int) redScroll.getValue();
            redTimeText.setText("Red wait: " + (redTime) + " Seconds");
        }
        else {
            greenTime = (int) greenScroll.getValue();
            greenTimeText.setText("Green wait: " + (greenTime) + " Seconds");
        }
    }
}
