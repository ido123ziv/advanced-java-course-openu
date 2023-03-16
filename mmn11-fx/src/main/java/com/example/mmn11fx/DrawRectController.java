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

    /**
     * method to handle buttons clicks
     * @param event
     */
    @FXML
    void drawRect(ActionEvent event) {
        gc.clearRect(0, 0, canv.getWidth(), canv.getHeight());
        drawLines();
        List<Integer> li = data.getCurrentYear(data.currentYear); // getting a random year
        drawBars(li);

    }

    /**
     * helper method to draw the cartesian axis
     */
    public void drawLines(){
        double startPoint = canv.getHeight() / 12, delimiter = 11;
        double y = 100, x = canv.getWidth() / 12;
        gc.strokeLine(startPoint * 2,startPoint *2,  startPoint * 2, canv.getHeight() - 2 * startPoint); // vertical
        gc.strokeLine(startPoint * 2,canv.getHeight() - 2* startPoint, canv.getWidth()-startPoint, canv.getHeight() - 2 * startPoint); // horizontal
        for (int i = 0; i < 12 ; i++){
            double v = (i * delimiter * 2) + x * 2.5 ;
            gc.strokeText("" + (i + 1), v,canv.getHeight() -startPoint - delimiter);
            if (i < 11) { // yaxis
                gc.strokeText("" + (10 - i) * 5 + "", startPoint * 2 - (2 * delimiter), y);
                y = y +  2* delimiter;
            }
        }
    }

    /**
     * helper method to draw the graph on every click
     * @param li
     */
    public void drawBars(List<Integer> li){
        // setting constraints
        int barCount = li.size(), delimiter = (barCount -1);
        double xc = canv.getWidth() / barCount;
        // getting edges
        int highestIndex = getHighestIndex(li), lowestIndex = getLowestIndex(li);
        double yc = canv.getHeight() - 2 *(canv.getHeight() / 12) - delimiter;//  - (li.get(highestIndex) * delimiter) ;
        for (int i = 0; i < barCount ; i ++){
           if (i == highestIndex) gc.setFill(Color.RED); // setting colors
           else if (i == lowestIndex) {
               gc.setFill(Color.BLUE);
           }
           else gc.setFill(Color.GRAY); // if all are equal then make them gray
           gc.fillRect((i *  delimiter *2) + xc * 2.5 , yc - (li.get(i) * 5), delimiter, (li.get(i) * 5));
           gc.setFill(Color.BLACK); // data labels
           gc.strokeText("" + li.get(i) + "",(i *  delimiter *2) + xc * 2.5  ,yc - (li.get(i) * 5) - delimiter);

        }
        title.setText(data.currentYear);
    }

    /**
     *  Helper method to determine the highest item in the list
     * @param li li -> list of avg temps
     * @return the index of the highest member
     */
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

    /**
     * Helper method to determine the lowest item in the list
     * @param li -> list of avg temps
     * @return the index of the lowest member
     */
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