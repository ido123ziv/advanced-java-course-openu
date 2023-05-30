package q2;

import javafx.fxml.FXML;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

public class TrafficLightController{


    public Circle LeftTopCirc, RightTopCirc, TopBottomCirc, TopTopCirc;
    public Circle LeftBottomCirc,  RightBottomCirc, BottomTopCirc, BottomBottomCirc;
    public Rectangle LeftTopRec, RightTopRec, TopTopRec, BottomTopRec;
    public Rectangle  LeftBottomRec , RightBottomRec, TopBottomRec, BottomBottomRec;
    @FXML
    private Circle[] topCirc; // top
    private Circle[] bottomCirc;
    private Circle[] northSouthTop;

    private Rectangle[] topRec;
    private Rectangle[] bottomRec;
    private int side;
    private boolean stop;

    public void initialize() throws InterruptedException {
        topCirc = new Circle[] {LeftBottomCirc, RightTopCirc, TopTopCirc, BottomBottomCirc};
        bottomCirc = new Circle[] {BottomTopCirc, BottomBottomCirc, LeftBottomCirc, RightBottomCirc};
        topRec = new Rectangle[] {LeftTopRec, RightTopRec, TopTopRec, BottomTopRec};
        bottomRec = new Rectangle[]{LeftBottomRec, RightBottomRec, TopBottomRec, BottomBottomRec};
        side = 1;
        stop = false;
        System.out.println("Initializing!");
        TrafficLightThread ta = new TrafficLightThread(this);
        ta.start();
    }

    public boolean isStop() {
        return stop;
    }

    public void flip(){
        System.out.println("Flipping!");
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



    public void toStop(){
        stop = true;
    }

}
