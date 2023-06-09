package q2;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
/**
 * Application Class for Traffic Light
 * Author: Ido Ziv 2023
 */
public class TrafficLightApplication extends Application {
    /**
     * Start the UI of application
     */
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(TrafficLightApplication.class.getResource("trafficLight.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 550);
        stage.setTitle("Traffic Light!");
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Launches application
     * @param args -> cmd line args
     */
    public static void main(String[] args) {
        launch();
    }
}


