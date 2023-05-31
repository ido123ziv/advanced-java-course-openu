package q2;

import javafx.fxml.FXML;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

import java.util.Objects;

/**
 * Controller Class for Traffic Light
 * Author: Ido Ziv 2023
 */
public class TrafficLightController{


    /**
     * Addressing UI Components using IDs
     */
    @FXML
    public Circle LeftTopCirc, RightTopCirc, TopBottomCirc, TopTopCirc;
    public Circle LeftBottomCirc,  RightBottomCirc, BottomTopCirc, BottomBottomCirc;
    public Rectangle LeftTopRec, RightTopRec, TopTopRec, BottomTopRec;
    public Rectangle  LeftBottomRec , RightBottomRec, TopBottomRec, BottomBottomRec;
    /**
     * Extra feature -> determine the wait time with the scrollbars
     */
    public Slider redScroll;
    public Slider greenScroll;
    public TextField redTimeText;
    public TextField greenTimeText;

    public int redTime = 3, greenTime = 3; // traffic light default wait time
    public int side; // which side is currently on
    public boolean isStop = false;

    /**
     * Initializing the canvas and threads
     */
    public void initialize() {
        side = 1; // Choose side
        isStop = false;
        System.out.println("Initializing!");
        TrafficLightThread ta = new TrafficLightThread(this); // Start Threads
        redTimeText.setText("Red wait: " + (redTime) + " Seconds"); // setting default
        greenTimeText.setText("Green wait: " + (greenTime) + " Seconds");
        ta.start();
    }

    /**
     * This method handles the flip side, when one side is green turns it to red
     * and turns the other side to green
     */
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
        side = side * -1; // flipping sides
    }

    /**
     * Helper method to get color name from hex code
     * @param colorHex -> hex code representing a color
     * @return -> string of the name of the color
     */
    private String getColorName(String colorHex){
        if (Objects.equals(colorHex, "0xff0000ff")) return "red";
        if (Objects.equals(colorHex, "0xffffffff")) return "white";
        return "lime";
    }

    /**
     * Flashes the traffic light for pedestrians using set color to white or green
     */
    public void flash(){
        if (side < 0){
            if (getColorName(RightBottomRec.getFill().toString()).equals("lime")){
                RightBottomRec.setFill(Color.WHITE);
                LeftBottomRec.setFill(Color.WHITE);
            }
            else {
                RightBottomRec.setFill(Color.LIME);
                LeftBottomRec.setFill(Color.LIME);
            }
        }
        else {
            if (getColorName(TopBottomRec.getFill().toString()).equals("lime")){
                TopBottomRec.setFill(Color.WHITE);
                BottomBottomRec.setFill(Color.WHITE);
            }
            else {
                TopBottomRec.setFill(Color.LIME);
                BottomBottomRec.setFill(Color.LIME);
            }
        }
    }

    /**
     * Method to handle the change of the scroll bar
     * changes the text box and updates the relevant vars
     * @param mouseEvent -> the slider that triggered the change
     */
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
