package q2;
import java.io.FileNotFoundException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
public class TrafficLightController {


    @FXML
    private Circle light;

    public void setFillGreen() {
        light.setFill(Color.LIMEGREEN);
    }

    public void setFillYellow() {
        light.setFill(Color.YELLOW);
    }

    public void setFillRed() {
        light.setFill(Color.RED);
    }

    public void setFillWhite() {
        light.setFill(Color.WHITE);
    }
}
