package com.example.mmn11fx;

import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;

import java.util.List;

public class DrawRectController {
    @FXML
    private Canvas canv;
    @FXML
    private Label title;
    private GraphicsContext gc;

    public void initialize() {
        gc = canv.getGraphicsContext2D();
        data.currentYear = "";
        drawLines();
    }

    @FXML
    void drawRect(ActionEvent event) {
//        gc.setFill(Color.GRAY);
        gc.clearRect(0, 0, canv.getWidth(), canv.getHeight());
        drawLines();
        List<Integer> li = data.getCurrentYear(data.currentYear);
        drawBars(li);
        // x y width height
//        gc.fillRect(0, 0, 100, 200);
    }
    public void drawLines(){
        double startPoint = canv.getHeight() / 12, delimiter = 11;
        gc.strokeLine(startPoint * 2,startPoint *2,  startPoint * 2, canv.getHeight() - 2*startPoint);
        gc.strokeLine(startPoint * 2,canv.getHeight() - 2* startPoint, canv.getWidth()-startPoint, canv.getHeight() - 2 * startPoint);
        for (int i = 0; i < 12 ; i++){
            gc.strokeText("" + (i + 1),(i *  delimiter * 2) + (startPoint) *2.5  ,canv.getHeight() -startPoint - delimiter);
        }

    }
    public void drawBars(List<Integer> li){
        int barCount = li.size(), delimiter = (barCount -1);
        double xc = canv.getWidth() / barCount;
//        double yc = (canv.getHeight() - 100) / barCount;
        int highestIndex = getHighestIndex(li), lowestIndex = getLowestIndex(li);
        double yc = canv.getHeight() - 2 *(canv.getHeight() / 12) - delimiter - (li.get(highestIndex) * delimiter) ;
        for (int i = 0; i < barCount ; i ++){
           if (i == highestIndex) gc.setFill(Color.RED);
           else if (i == lowestIndex) {
               gc.setFill(Color.BLUE);
           }
           else gc.setFill(Color.GRAY); // if all are equal then make them gray
           int yLocation = li.get(highestIndex) -  li.get(i);
           gc.fillRect((i *  delimiter *2) + xc * 2.5 , yc + ( delimiter* yLocation), delimiter, (li.get(i) * delimiter));
           gc.setFill(Color.BLACK);
//           gc.strokeText("" + (i + 1),(i *  delimiter * 2) + xc  ,delimiter + yc + ( delimiter* li.get(highestIndex)));
           gc.strokeText("" + li.get(i) + "",(i *  delimiter *2) + xc * 2.5  ,yc + ( delimiter* yLocation) - delimiter);

        }
//        gc.strokeLine(xc -1, 100, xc -1, yc);
//        gc.strokeLine(xc, delimiter + yc + ( delimiter* li.get(highestIndex)), xc + (barCount * delimiter * 2), delimiter + yc + ( delimiter* li.get(highestIndex)) );
        title.setText(data.currentYear);
//        gc.strokeLine(0, yc + li.get(highestIndex) * delimiter, delimiter, li.get(highestIndex) * delimiter );

    }

    public int getHighestIndex(List<Integer> li){
        int max = Integer.MIN_VALUE;
        for (Integer integer : li) {
            if (integer > max) {
                max = integer;

            }
        }
        if (li.contains(max)) return li.indexOf(max);
        return 0;
    }
    public int getLowestIndex(List<Integer> li){
        int min = Integer.MAX_VALUE;
        for (Integer integer : li) {
            if (integer < min) {
                min = integer;

            }
        }
        if (li.contains(min)) return li.indexOf(min);
        return 0;
    }
}